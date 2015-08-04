(set-env!
 :source-paths   #{"src"}
 :resource-paths #{"src"}
 :dependencies '[[org.clojure/clojure "1.6.0"]])

(def +version+ "0.1.0")

(task-options!
 pom  {:project     'test.uberjar
       :version     +version+
       :description "Creates broken uberjar."}
 aot  {:namespace   #{'test.core}}
 jar  {:main        'test.core})

(deftask working-uberjar
  "Builds an uberjar of this project that can be run with java -jar"
  []
  (comp (aot) (pom) (uber :as-jars false) (jar)))

(deftask broken-uberjar
  "Builds an uberjar of this project that can be run with java -jar"
  []
  (comp (aot) (pom) (uber :as-jars true) (jar)))
