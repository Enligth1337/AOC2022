(ns day1
     (:require
          [clojure.string :as str]))

(def day1-input
     (->> (slurp "src/day1")
          (str/split-lines)
          (map str/trim)
          (partition-by empty?)
          (filter (comp not empty? first))))

(defn aoc-day1
     [input]
     (apply max
            (reduce
                 (fn [coll val]
                  (conj coll (apply + (map #(Integer/parseInt %) val))))
                 [] input)))

(comment
     (aoc-day1 day1-input))

