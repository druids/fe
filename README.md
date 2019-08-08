Fé
==

Fé is a library for money formatting.

[![CircleCI](https://circleci.com/gh/druids/fe.svg?style=svg)](https://circleci.com/gh/druids/fe)
[![Dependencies Status](https://jarkeeper.com/druids/fe/status.png)](https://jarkeeper.com/druids/fe)
[![License](https://img.shields.io/badge/MIT-Clause-blue.svg)](https://opensource.org/licenses/MIT)


Leiningen/Boot
--------------

```clojure
[fe "0.1.1"]
```


Documentation
-------------

```clojure
(require '[fe.core :as fe])

(fe/fmt 10000 "EUR") ;; "10 000.00 EUR"
(fe/fmt 10000 "EUR" {:decimal-pos 0}) ;; "10 000 EUR"
(fe/fmt 10000 "EUR" {:part-sep ","}) ;; "10,000.00 EUR"
(fe/fmt 10000 "EUR" {:decimal-sep ","}) ;; "10 000,00 EUR"
(fe/fmt 10000 "£" {:currency-pos :prefix, :part-sep ","}) ;; "£10,000.00"
```

`fmt` function uses a non-breakable space by default (as Unicode character).

Contribution
------------

### Conventions

* Please follow coding style defined by [`.editorconfig`](http://editorconfig.org)
 and [The Clojure Style Guide](https://github.com/bbatsov/clojure-style-guide)
* Write [good commit messages](https://chris.beams.io/posts/git-commit/)
 and provide an issue ID in a commit message prefixed by `#`
