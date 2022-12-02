(ns day1
     (:require
          [clojure.string :as str]))

(def day1-input
     (->> (slurp "src/day1")
          (str/split-lines)
          (map str/trim)
          (partition-by empty?)
          (filter (comp not empty? first))))

(defn aoc-day1-2-list
     [input]
     (reduce
          (fn [coll val]
               (conj coll (apply + (map #(Integer/parseInt %) val))))
          [] input))

(defn aoc-day1-qst1
     [list]
     (apply max (aoc-day1-2-list list)))

(defn aoc-day1-qst2
     [list]
     (apply +
            (take-last 3
                       (sort (aoc-day1-2-list list)))))

(comment
     (aoc-day1 day1-input)
     (aoc-day2 day1-input))


