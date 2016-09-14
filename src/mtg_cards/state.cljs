(ns mtg-cards.state
  (:require [reagent.core :as reagent :refer [atom]]))

; Text showing the API is being accessed
(defonce loading (reagent/atom false))

; Set of found lists from search
(defonce found-cards (reagent/atom []))

; Current card's data
(defonce current-card (reagent/atom nil))

; List of sets published
(defonce found-sets (reagent/atom []))

; Selected set list
(defonce current-set (reagent/atom nil))

; List of cards found in the selected set list
(defonce found-set-cards (reagent/atom []))
