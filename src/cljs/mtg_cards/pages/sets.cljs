(ns mtg-cards.pages.sets
  (:require [mtg-cards.state :as state]
            [mtg-cards.components.set-link :as set-link]))

(defn sets []
  [:div.no-title

   [:div.search-form-section
    (when @state/loading
      [:p "Searching, please wait..."])]

   (when-not (empty? @state/found-sets)
     [:div
       [:div.note
        [:b "Please note: "]
        "currently only the set list is supported, upcoming changes include listing cards based on selected set."]

       [:div.table-responsive
        [:table.table-striped {:class "table"}
         [:thead
          [:tr
           [:th "Name"]
           [:th "Release date"]
           [:th "Type"]
           ]]
         [:tbody
          (for [{:keys [code name releaseDate type]} @state/found-sets]
            ^{:key code} [set-link/render code name releaseDate type false])]]]])])
