(ns day2
  (:require
    [clojure.string :as str]))

(def result-set
  [{:a "scissors" :x "rock" :res 3}
   {:a "paper" :x "rock" :res 0}
   {:a "rock" :b "scissors" :res 0}
   {:a "paper" :b "scissors" :res 3}
   {:a "rock" :b "paper" :res 3}
   {:a "scissors" :b "paper" :res 0}])

(def item-value-list
  [{:item "rock" :value 1}
   {:item "paper" :value 2}
   {:item "scissors" :value 3}])

(defn result
  [x y]
  (if (= x y )
    1
    (:res (first  (filter #(and (= (:a %) x) (= (:b %) y)) result-set)))))

(defn get-item-value
  [item]
  (:value (first  (filter #(= (:item %) item) item-value-list))))

(defn get-item-name
  [key]
  ())

(def day2-input
  (->> (slurp "src/day2")
       (str/split-lines)
       (map #(re-seq #"\S" %))))




(keyword "x")
(get-item-value "stone")
(result "scissors" "paper")

(comment

  (first day2-input)
  (get result-set :a)
  (:res (first  (filter #(= (:a %) "scissors") result-set)))

  (:a {:a "scissors" :b "stone" :res 3})
  )

