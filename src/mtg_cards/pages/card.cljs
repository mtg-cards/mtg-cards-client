(ns mtg-cards.pages.card
  (:require [mtg-cards.common :as common]
            [mtg-cards.state :as state]
            [mtg-cards.components.title :as sub-title]))

(defn- render-row [label key]
  (if (get @state/current-card key)
    [:div.card-data
     [:b label ": "]
     (get @state/current-card key)]))

(defn- render-row-with-mana [label key]
  (if (get @state/current-card key)
    [:div.card-data
     [:b label ": "]
     [:span {:dangerouslySetInnerHTML
             {:__html
              (common/render-mana-icons (get @state/current-card key))}}]]))

(defn card []
  [:div
   [sub-title/render (:name @state/current-card)]

   [:h4.card-type (:type @state/current-card)]

   [:div.row
    [:div {:class "col-md-4 card-image"}
     [:div
      (when (:imageUrl @state/current-card)
        [:img.card {:src (:imageUrl @state/current-card)}])]]

    [:div {:class "col-md-8 card-stats"}
     [:div.card-data
      (if (:text @state/current-card)
        [:p {:dangerouslySetInnerHTML
             {:__html
              (common/render-mana-icons
                (clojure.string/replace (:text @state/current-card) #"\n" "<br/>"))}}])]
     [:div
      (render-row-with-mana "Mana cost" :manaCost)
      (render-row "Power" :power)
      (render-row "Toughness" :toughness)
      (render-row "Rarity" :rarity)
      (render-row "Set" :setName)
      (render-row "Artist" :artist)]]]])
