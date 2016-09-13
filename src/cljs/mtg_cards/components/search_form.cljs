(ns mtg-cards.components.search-form
  (:require [reagent.core :as reagent]
            [mtg-cards.action :as action]))

(defonce card-name (reagent/atom nil))

(defn clear-form []
  (reset! card-name nil))

(defn- submit-form []
  (action/search @card-name)
  (clear-form))

(defn render []
  [:div
   [:form {:onSubmit (fn [e] (.preventDefault e))}
    [:input {:type "text"
             :placeholder "Enter card name"
             :value @card-name
             :onChange #(reset! card-name (-> % .-target .-value))}]
    [:button {:onClick #(submit-form)} "Search"]]])
