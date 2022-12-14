(ns day3
  (:require
    [clojure.string :as str]
    [clojure.set :as set]))

(def item-priorities (->> (concat (range (int \a) (inc (int \z)))
                                  (range (int \A) (inc (int \Z))))
                          (map-indexed (fn [idx l] [l (inc idx)]))
                          (into {})))

(defn backpack-section
  [backpack]
  (let [half (/ (count backpack) 2)]
    (->> backpack
         ((juxt (partial take half) (partial drop half)))
         (map set)
         (apply set/intersection))))

(defn backpack-section-2
  [backpack]
  (let [half (/ (count backpack) 2)]
    (->> backpack
     (vector (take half backpack) (drop half backpack))
         (map set)
         (apply set/intersection))))

(defn sum
  [items]
  (reduce
    (fn [sum item]
      (+ sum (get item-priorities (int item)))) 0 items))

(defn badge
  [input]
  (apply set/intersection input))

(def day3-input
  (->> (slurp "src/day3")
       (str/split-lines)))

(defn day3-part1
  [input]
  (->> input
       (map backpack-section-2)
       (map sum)
       (apply +)))

(defn day3-part2
  [input]
  (->> input
       (map set)
       (partition 3)
       (map badge)
       (map first)
       (sum)))

(day3-part1 day3-input)
(day3-part2 day3-input)

