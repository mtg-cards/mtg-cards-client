(ns mtg-cards.pages.set-cards
  (:require [mtg-cards.state :as state]
            [mtg-cards.components.card-link :as card-link]))

(defn set-cards []
  [:div.no-title

   [:div.search-form-section
    (when @state/loading
      [:p "Searching, please wait..."])]

   (when-not (empty? @state/found-set-cards)
     [:p (str "Found " (count @state/found-set-cards) " card(s)")]

     [:div.table-responsive
      [:table.table-striped {:class "table"}
       [:thead
        [:tr
         [:th "Name"]
         [:th "P/T"]
         [:th "Mana cost"]
         ]]
       [:tbody
        (for [{:keys [id name power toughness setName manaCost]} @state/found-set-cards]
          ^{:key id} [card-link/render id name power toughness setName manaCost])]]])])
