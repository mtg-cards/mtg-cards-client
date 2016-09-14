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
    [:div.credit-item "Andrew Backes"]
    [:p "magicthegathering.io"]]

   [:div.about-section
    [:h4.work-title "Card Images"]
    [:div.credit-item "Gatherer"]
    [:p "gatherer.wizards.com"]]

   [:div.about-section
    [:h4.work-title "Powered By"]
    [:div.credit-item "ClojureScript / Reagent"]]

   [:div.about-section
    [:h4.work-title "Source Code"]
    [:div.credit-item [:a {:href "https://github.com/mtg-cards"} "Github repositories"]]]])
