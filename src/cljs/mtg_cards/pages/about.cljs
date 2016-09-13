(ns mtg-cards.pages.about)

(defn about []
  [:div.no-title

   [:div.about-section
    [:h4.work-title "Design & Development"]
    [:div.person-name "Artur Gajewski"]
    [:div.link-icon-section
     [:a {:href "https://fi.linkedin.com/in/arturgajewski"}
      [:i {:class "fa fa-linkedin-square link-icon" :aria-hidden "true"}]]
     " "
     [:a {:href "https://github.com/artur-gajewski"}
      [:i {:class "fa fa-github link-icon" :aria-hidden "true"}]]
     " "
     [:a {:href "https://twitter.com/GajewskiArtur"}
      [:i {:class "fa fa-twitter link-icon" :aria-hidden "true"}]]]]

   [:div.about-section
    [:h4.work-title "API"]
    [:div.person-name "Andrew Backes"]
    [:p "magicthegathering.io"]]

   [:div.about-section
    [:h4.work-title "Card Images"]
    [:div.person-name "Gatherer"]
    [:p "gatherer.wizards.com"]]

   [:div.about-section
    [:h4.work-title "Powered By"]
    [:div.person-name "ClojureScript / Reagent"]]

   [:div.about-section
    [:h4.work-title "Source Code"]
    [:div.person-name "Coming soon!"]]])
