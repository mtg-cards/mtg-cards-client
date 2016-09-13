(ns mtg-cards.components.card-link
  (:require [mtg-cards.common :as common]))

(defn- format-stats-block [power toughness]
  (let [stats-str (str power "/" toughness)]
    (if (= stats-str "/")
      ""
      (str " (" stats-str ")"))))

(defn render [id name power toughness set-name mana-cost]
  [:tr
   [:td.list-data [:a {:href (str "/card/" id)} name [:br] [:span.set-name set-name]]]
   [:td.list-data (format-stats-block power toughness)]
   [:td.list-data {:dangerouslySetInnerHTML {:__html (common/render-mana-icons mana-cost)}}]])
