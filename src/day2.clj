(ns day2)


(def result-set
  [{:a "scissors" :b "stone" :res 3}
   {:a "stone" :b "scissors" :res 0}])


(defn result
  [x y]
  (cond
    (= x y) 1)
  :else "lol")

(comment
  (get result-set :a)
  (:res (first  (filter #(= (:a %) "scissors") result-set)))

  (:a {:a "scissors" :b "stone" :res 3})
  )

