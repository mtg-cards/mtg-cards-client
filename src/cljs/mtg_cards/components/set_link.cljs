(ns mtg-cards.components.set-link)

(defn render [code name releaseDate type is-link]
  [:div {:class "row row-stripe"}
   [:div {:class "col-sm-4 col-xs-6 col-data"}
    (if is-link
      [:a {:href (str "/set/" code)} name [:br] [:span.set-name name]]
      name
      )]
   [:div {:class "col-sm-4 col-xs-6 col-data"} releaseDate]
   [:div {:class "col-sm-4 col-xs-12 col-data"} type]])
