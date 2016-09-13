(ns mtg-cards.pages.search
  (:require [mtg-cards.state :as state]
            [mtg-cards.components.search-form :as search-form]
            [mtg-cards.components.card-link :as card-link]))

(defn search []
  [:div.no-title

   [:div.search-form-section
    (if @state/loading
      [:p "Searching, please wait..."]
      [search-form/render])]

    (when-not (empty? @state/found-cards)
     [:p (str "Found " (count @state/found-cards) " card(s)")]

     [:div.table-responsive
      [:table.table-striped {:class "table"}
       [:thead
        [:tr
         [:th "Name"]
         [:th "P/T"]
         [:th "Mana cost"]
         ]]
       [:tbody
        (for [{:keys [id name power toughness setName manaCost]} @state/found-cards]
          ^{:key id} [card-link/render id name power toughness setName manaCost])]]])])
