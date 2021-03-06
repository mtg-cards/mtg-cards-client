(ns mtg-cards.router
  (:require [reagent.session :as session]
            [secretary.core :as secretary :include-macros true]
            [mtg-cards.action :as action]
            [mtg-cards.pages.search :refer [search]]
            [mtg-cards.pages.card :refer [card]]
            [mtg-cards.pages.sets :refer [sets]]
            [mtg-cards.pages.set-cards :refer [set-cards]]
            [mtg-cards.pages.about :refer [about]]))

(defn create-routes []

  ; Front page, search form and results
  (secretary/defroute "/" []
                      (session/put! :current-page #'search))

  ; Detailed information of a specific card
  (secretary/defroute "/card/:id" [id]
                      (action/get-card-data id)
                      (session/put! :current-page #'card))

  ; List of released sets
  (secretary/defroute "/sets" []
                      (action/get-sets)
                      (session/put! :current-page #'sets))

  ; List of cards belonging to specific set
  (secretary/defroute "/set/:set-code" [set-code]
                      (action/get-set-cards set-code)
                      (session/put! :current-page #'set-cards))

  ; Information about this application and credits
  (secretary/defroute "/about" []
                      (session/put! :current-page #'about)))
