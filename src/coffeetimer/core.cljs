(ns coffeetimer.core
  (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(println "This text is printed from src/coffeetimer/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!2"}))

(defn timer []
  [:div {:style {:display :flex
                 :flex 1
                 :flex-direction :column}}
    [:svg {:style {:width "80vmin"
                   :height "80vmin"}
           :view-box "-200 -200 400 400"}
     [:circle {:r 160
               :fill "none"
               :stroke-width 1
               :stroke "white"
               :opacity 0.2}]
     [:g {:style {:animation "rot 5s linear infinite"}}
       [:circle {:style {:animation "ani 4s linear infinite reverse, rot 16s steps(4, start) infinite reverse"}
                 :r 160
                 :fill "none"
                 :stroke-width 4
                 :stroke "white"}]]
     [:text {:font-size 100}
      "00:00"]]])

(defn hello-world []
  [:div {:style {:position :absolute
                 :left 0
                 :top 0
                 :bottom 0
                 :right 0
                 :display :flex
                 :flex-direction :column}}
   [:div {:style {:display :flex
                  :flex 1
                  :flex-direction :row}}
    [:div {:style {:display :flex
                   :flex 1
                   :padding 80}}
      [timer]]
    [:div {:style {:display :flex
                   :flex 1
                   :padding 80}}
      [timer]]]
   [:div {:style {:display :flex
                  :height 140}}]])

(reagent/render-component [hello-world]
                          (. js/document (getElementById "app")))

(defn on-js-reload [])
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
