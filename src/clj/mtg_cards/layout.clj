(ns mtg-cards.layout
  (:require [hiccup.page :refer [include-js include-css html5]]))

(defn head [env]
  [:head
   [:meta {:charset "utf-8"}]
   [:meta {:http-equiv "X-UA-Compatible" :content "IE)edge"}]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1"}]
   [:title "Magic: The Gathering - Card Search"]
   (include-css "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css")
   (include-css "https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css")
   (include-css (if (env :dev) "/css/site.css" "/css/site.min.css"))])

(defn base-html [env]
  (html5
    (head env)
    [:body
     [:nav {:class "navbar navbar-inverse navbar-fixed-top"}
      [:div.container-fluid
       [:div.navbar-header
        [:button {:type "button" :class "navbar-toggle collapsed" :data-toggle "collapse" :data-target "#navbar" :aria-expanded "false" :aria-controls= "navbar"}
         [:span.sr-only "Toggle navigation"]
         [:span.icon-bar ""]
         [:span.icon-bar ""]
         [:span.icon-bar ""]]]
       [:div#navbar {:class "collapse navbar-collapse"}
        [:ul {:class "nav navbar-nav"}
         [:li
          [:a {:href "/"} "Search"]]
         [:li
          [:a {:href "/sets"} "Sets"]]
         [:li
          [:a {:href "/about"} "About"]]]]]]
     [:div.container
      [:div.template
       [:img.logo {:src "/images/mtg-logo.png"}]
       [:div#app]]]
     (include-js "https://code.jquery.com/jquery-1.12.4.min.js")
     (include-js "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js")
     (include-js "/js/fix.js")
     (include-js "/js/app.js")]))
