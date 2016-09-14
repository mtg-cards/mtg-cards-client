(ns mtg-cards.state
  (:require [reagent.core :as reagent :refer [atom]]))

(defonce loading (reagent/atom false))

(defonce found-cards (reagent/atom []))

(defonce current-card (reagent/atom nil))

(defonce found-sets (reagent/atom []))

(defonce current-set (reagent/atom nil))

(defonce found-set-cards (reagent/atom []))
