(ns day3)


(defn char-range [start end]
  (->(range (int start) (inc (int end)))
    (map char)))

(char-range \a \z)

(into {} (map-indexed (fn [idx l] [l (inc idx)]) (char-range \a \z)))


(range (int \a) (inc (int \z)))