(ns day4
  (:require
    [clojure.string :as str]
    [clojure.set :as set]))

(defn checker
  [x y z]
  (let [first-elf (count x)
        second-elf (count y)
        set-range (count z)]
    (if (or (<= first-elf set-range)
            (<= second-elf set-range))
      1
      0)))

(defn range-creator
  [input]
  (let [fst-elf (set (range (first input) (inc (second input))))
        scnd-elf (set (range (second (reverse input)) (inc (last input))))]
    (checker fst-elf scnd-elf (set/intersection fst-elf scnd-elf))))

(def day4-input
  (as-> (slurp "src/day4") n
       (str/split n #"\D")
        (map str/trim n)
        (partition-by empty? n)
        (filter (comp not empty? first) n)
        (reduce (fn [coll val]
                  (conj coll (map read-string val))) [] n)))

(defn da4-part1
  [input]
  (->> input
       (map range-creator)
       (apply +)))

(da4-part1 day4-input)
