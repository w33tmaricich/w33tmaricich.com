(ns w33tmaricich.core
  (:require [reagent.core :as reagent]
            [w33tmaricich.code :as c]
            [cljs-time.core :as t]))

(def STARTED-DEVELOPING 2012)
(def BORN 1993)
(def PERSON-INFO [{:keyword ":name"
                   :data "\"Alexander Price Maricich\""
                   :type "string"}
                  {:keyword ":age"
                   :data (- (t/year (t/now)) BORN)
                   :type "macro"}
                  {:keyword ":dev-years"
                   :data (- (t/year (t/now)) STARTED-DEVELOPING)
                   :type "macro"}
                  {:keyword ":proficient"
                   :data "#{:c :clojure :clojurescript :java :python}"
                   :type "keyword"}
                  {:keyword ":interests"
                   :data "#{:buddhism :programming :veganism}"
                   :type "keyword"}])

(def app-state
  (reagent/atom {:message "Welcome to w33tmaricich.com!"}))

(defn app 
  "Root structure of our ui"
  []
  [:div
    (c/semi "; Copyright Alexander Maricich 2016")
    (c/br)
    (c/semi "; Powered with cljs and reagent")
    (c/br 2)
    (c/semi "; Site definition ----------------------------------")
    (c/br 2)
    (c/ns-require "com.w33tmaricich" [{:import "contact-information"
                                       :as "email"}
                                      {:import "notible.websites"
                                       :as "sites"}])
    (c/br 2)
    (c/semi "; About me -----------------------------------------")
    (c/br 2)
    (c/s-def "person" (c/s-atom PERSON-INFO))
    (c/br 2)
    (c/semi "; Important links ----------------------------------")


    
  ])


  ;[:div {} (:message @app-state)])

(reagent/render [app] (js/document.querySelector "#cljs-target"))

