(ns ld39.core
  (:require [datascript.core :as d]
            [rum.core :as rum]))

(enable-console-print!)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Application state

(def schema
  {:db/ident             {:db/unique :db.unique/identity}
   :engine/current-scene {:db/type :db.type/ref}})

(defonce conn (d/create-conn schema))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Components

;; Image viewer


(rum/defc image-viewer []
  [:div "image viewer"])

(rum/defc text-viewer []
  [:div.text-viewer {}
   "Where the text will be. I can try to put a lot and a lot of text to see where this leads in the end. Really though, I'm trying to get the scroll to trigger"])

(rum/defc action-box []
  [:div "action box"])

(rum/defc app []
  [:div.root {}
   [:div.title "Where you are at the moment"]
   (image-viewer)
   (text-viewer)
   (action-box)])

(rum/mount (app) (js/document.getElementById "app"))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )
