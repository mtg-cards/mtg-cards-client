(ns mtg-cards.handler
  (:require [compojure.core :refer [GET defroutes]]
            [compojure.route :refer [not-found resources]]
            [mtg-cards.middleware :refer [wrap-middleware]]
            [mtg-cards.layout :refer [base-html]]
            [config.core :refer [env]]))

(defroutes routes
           (GET "/*" [] (base-html env))
           (resources "/")
           (not-found "Not Found"))

(def app (wrap-middleware #'routes))
