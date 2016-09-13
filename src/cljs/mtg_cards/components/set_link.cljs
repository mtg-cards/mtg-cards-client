(ns mtg-cards.components.set-link)

(defn render [code name releaseDate type is-link]
  [:tr
   (if is-link
    [:td.list-data [:a {:href (str "/set/" code)} name]]
    [:td.list-data name])
   [:td.list-data releaseDate]
   [:td.list-data type]])
