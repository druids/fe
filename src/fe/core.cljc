(ns fe.core
  (:require [clojure.string :as string]
            #?(:cljs [goog.string.format])
            #?(:cljs [goog.string :refer [format]])))

(def space "\u00A0")

(defn- separate-thousands
  [num-part part-sep]
  (->> num-part
       string/reverse
       (partition 3 3 nil)
       reverse
       (map #(string/join (reverse %)))
       (string/join part-sep)))

(def ^:private coerce
  #?(:clj bigdec)
  #?(:cljs double))

(defn fmt
  "Formats a given `amount` as a `currency`.
   Options:
    - `decimal-num`: a number of decimal places, default `2`
    - `decimal-sep`: a separator between a number part and decimal part,
      default `.`
    - `part-sep`: a separator between number parts,
      default a non-breaking space"
  [amount currency & [{:keys [currency-pos
                              decimal-num
                              decimal-sep
                              part-sep]
                       :or {currency-pos :suffix
                            decimal-num 2
                            decimal-sep "."
                            part-sep space}
                       :as opts}]]
  (let [[num-part decimal-part] (-> (str "%." decimal-num "f")
                                    (format (coerce amount))
                                    (string/split #"\."))]
    (string/join ""
                 (concat (when (= :prefix currency-pos)
                           [currency])
                         [(separate-thousands num-part part-sep)]
                         (when (pos? decimal-num)
                            [decimal-sep decimal-part])
                         (when (= :suffix currency-pos)
                           [space currency])))))
