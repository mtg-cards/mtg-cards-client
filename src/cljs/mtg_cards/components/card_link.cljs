(ns mtg-cards.components.card-link
  (:require [mtg-cards.common :as common]))

(defn- format-stats-block [power toughness]
  (let [stats-str (str power "/" toughness)]
    (if (= stats-str "/")
      ""
      (str " (" stats-str ")"))))

(defn render [id name power toughness set-name mana-cost]
  [:div {:class "row row-stripe"}
   [:div {:class "col-sm-4 col-xs-6 col-data card-name"} [:a {:href (str "/card/" id)} name [:br] [:span.set-name set-name]]]
   [:div {:class "col-sm-4 col-xs-2 col-data"} (format-stats-block power toughness)]
   [:div {:class "col-sm-4 col-xs-4 col-data" :dangerouslySetInnerHTML {:__html (common/render-mana-icons mana-cost)}}]])

