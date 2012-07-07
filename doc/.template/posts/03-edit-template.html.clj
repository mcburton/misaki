(h2 "Template file")
(p "Template files are compiled with [hiccup](aa).")


(h3 "Example")
#-CLJ
;; Define template options here
; @layout  default
; @title   misaki

;; definition your clojure function
(defn header [s] [:header [:h1 s]])

;; "site" variable to access template options
(header (:title site))

[:h2 "Posts"]
[:ul
 (for [p (:posts site)]
   [:li (:title p)])]
CLJ

; /Example

(h3 "Tempalte options")
(p "Template option format:")

#-CLJ
; @key value
CLJ

(h4 "Special options")
(ul
  [
   (p "`layout`: Specify layout file.")
   (p "`title`: Define template title.")
   (p "`format`: Specify template format (`\"html5\"`, `\"xhtml\"`, `\"html4\"`).
      No format template will be compiled by `hiccup.core/html`.")
   ]
  )

(h4 "Access tepalte options")

(p "misaki provides `site` variable to access defined tempalte options. For example, you can access template title with `(:title site)`.")


(h4 "Site updated date")

(p "`(:date site)` is site updated date (org.joda.time.DateTime).")

; /Template options

(h3 "Functions")

(p "You can define your own function in template or layout. However, special variable(e.g., `site` and `contents`) is not accessible in those functions.")

; /Functions

(h3 "Posts")

(p "`(:posts site)` is post data list.")


(h4 "Post data format")

(ul [
     (p "`:title`: Post title.")
     (p "`:url`: Post url.")
     (p "`:date`: Post date (org.joda.time.DateTime).")
     (p "`:file`: Post file (java.io.File).")
     (p "`:tag`: Tag list for this post.")
     (p "`lazy-content`: Delayed post content. Use `force` to get post content.")
     ])

(h4 "Tag list format")

(ul [
     (p "`:name`: Tag name.")
     (p "`:url`: Tag page URL.")
     ])

; /Posts

(h3 "Post tags")

(p "`(:tags site)` is all post's tag data list.")


(h4 "Tag data format")

(ul [
     (p "`:name`: Tag name.")
     (p "`:url`: Tag page URL.")
     (p "`:count`: Tag counts.")
     ])

; /Post tags

(h3 "Code Highlight")

(p "Codes are highlighted by [google-code-prettify](http://code.google.com/p/google-code-prettify/).")

#-CLJ
#-CODE
(println "hello")
CODE
CLJ

(p "`CODE` can be replaced by any string.")
(p "If you define highlight setting, `CODE` string specifies a language.
   To define highlight setting, see [Highlight Setting](aa).")

; /Code Highlight



(h2 "Layout file")
(h3 "Example")

(p "Layout options is same as template options.")

#-CLJ
; @title  default title
; @format html5

[:head
 [:title (:title site)]]
[:body contents]
CLJ

(h4 "Special variable")

(ul [
     (p "`site`: Variable to access layout options.")
     (p "`contents`: Variable to handle template contents.")
     ])


(h4 "Layout in layout")

(p "Layout file can contain `:layout` option.")

[:ul
 [:li "default.clj"
#-CLJ
; @title  default title
; @format html5
[:head [:title (:title site)]]
[:body contents]
CLJ
  ]
 [:li "post.clj"
#-CLJ
; @layout default
; @title  post default title
[:h1 (:title site)]
contents
CLJ
  ]
 ]
; /Example

(h3 "Tag layout")
(p "Tag layout which is defined as `:tag-layout` in _config.clj has special `site` keyword.")

(ul [
     (p "`(:tag-name site)`: Tag name.")
     (p "`(:posts site)`: Post list which contains the tag.")
  ])

; @layout  post
; @title   Edit Template
