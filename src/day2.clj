(ns day2
  (:require
    [clojure.string :as str]))

(def result-set
  [{:a "scissors" :b "rock" :res 6}
   {:a "paper" :b "rock" :res 0}
   {:a "rock" :b "scissors" :res 0}
   {:a "paper" :b "scissors" :res 6}
   {:a "rock" :b "paper" :res 6}
   {:a "scissors" :b "paper" :res 0}])

(def item-value-list
  [{:item "rock" :value 1}
   {:item "paper" :value 2}
   {:item "scissors" :value 3}])

(def item-name-list
  {:A "rock" :X "rock"
   :B "paper" :Y "paper"
   :C "scissors" :Z "scissors"})

(def rules-for-part2
  {:scissors 6
   :paper 3
   :rock 0 })

(defn result
  [list]
  (let [x (first list)
        y (second list)]
   (if (= x y )
    3
    (:res (first  (filter #(and (= (:a %) x) (= (:b %) y)) result-set))))))

(defn result-part2
  [x y]
  (if (= 3 y )
    x
    (:b (first  (filter #(and (= (:a %) x) (= (:res %) y)) result-set)))))

(defn get-item-value
  [item]
  (:value (first  (filter #(= (:item %) item) item-value-list))))

(def day2-input
  (->> (slurp "src/day2")
       (str/split-lines)
       (map #(re-seq #"\S" %))))

(defn create-item-list
  [list]
  (partition 2
   (reduce
    (fn [coll val]
      (conj coll
            (get item-name-list (keyword (first val)))
            (get item-name-list (keyword (second val)))))
    [] list)))

(defn day2-part1
  [input]
  (apply + (reduce
    (fn [coll val]
      (conj coll
            (result val)
            (get-item-value (second val))))
    [] (create-item-list input))))

(defn da2-part2
  [input]
  (apply + (reduce
    (fn [coll val]
      (conj coll
            (get rules-for-part2 (keyword (second val)))
            (get-item-value (result-part2 (first val) (get rules-for-part2 (keyword (second val)))))))
    [] (create-item-list input))))

(comment
  (day2-part1 day2-input)
  (da2-part2 day2-input))


