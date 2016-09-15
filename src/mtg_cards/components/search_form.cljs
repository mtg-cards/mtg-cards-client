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
  [:div {:class "row text-center"}
   [:div.col-lg-12
    [:div.input-groups
     [:form {:class "form-inline" :onSubmit (fn [e] (.preventDefault e))}
      [:input {:type "text"
               :size 40
               :class "form-control card-name-input"
               :placeholder "Enter card name"
               :value @card-name
               :onChange #(reset! card-name (-> % .-target .-value))}]
      [:button {:class "btn btn-primary do-search" :onClick #(submit-form)} "Search"]]]]])
