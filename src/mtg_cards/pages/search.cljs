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

      [:div
       [:div {:class "row"}
        [:div {:class "col-sm-4 col-xs-6 col-label col-name text-left"} "Name"]
        [:div {:class "col-sm-4 col-xs-2 col-label text-left"}  "P/T"]
        [:div {:class "col-sm-4 col-xs-4 col-label text-left"}  "Mana cost"]]

       (for [{:keys [id name power toughness setName manaCost]} @state/found-cards]
         ^{:key id} [card-link/render id name power toughness setName manaCost])])])
