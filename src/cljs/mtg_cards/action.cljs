(ns mtg-cards.action
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [mtg-cards.state :as state]
            [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [clojure.string :refer [lower-case includes?]]))

(defn search [card-name]
  (reset! state/loading true)
  (reset! state/found-cards nil)
  (go (let [{:keys [body status] :as response}
            (js->clj (<! (http/get (str "https://api.magicthegathering.io/v1/cards?name=" card-name))))]
        (if (= status 200)
          (let [cards (:cards (js->clj body))
                sorted (sort-by :name cards)]
            (reset! state/loading false)
            (reset! state/found-cards sorted))
          nil))))

(defn get-card-data [id]
  (reset! state/current-card nil)
  (reset! state/loading true)
  (go (let [{:keys [body status] :as response}
            (js->clj (<! (http/get (str "https://api.magicthegathering.io/v1/cards/" id))))]
        (if (= status 200)
          (let [card (:card (js->clj body))]
            (reset! state/loading false)
            (reset! state/current-card card))
          nil))))

(defn get-sets []
  (when (empty? @state/found-sets)
    (reset! state/loading true)
    (go (let [{:keys [body status] :as response}
              (js->clj (<! (http/get "https://api.magicthegathering.io/v1/sets")))]
          (if (= status 200)
            (let [sets (:sets (js->clj body))]
              (reset! state/loading false)
              (reset! state/found-sets sets))
            nil)))))

(defn get-set-cards [set-code]
  (when-not (= @state/current-set set-code)
    (reset! state/loading true)
    (reset! state/found-set-cards nil)
    (reset! state/current-set set-code)
    (go (let [{:keys [body status] :as response}
              (js->clj (<! (http/get (str "https://api.magicthegathering.io/v1/cards?pageSize=100&set=" set-code))))]
          (if (= status 200)
            (let [cards (:cards (js->clj body))
                  sorted (sort-by :name cards)]
              (reset! state/loading false)
              (reset! state/found-set-cards sorted))
            nil)))))
