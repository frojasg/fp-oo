(ns fp-oo.class
  (:gen-class))



;; Exercise 5.4.1
(def apply-message-to
(fn [class instance message args]
    (apply (message (:__instance_methods__ class)) instance args)))

(def make
     (fn [class & args]
      (let [seeded {:__class_symbol__ (:__own_symbol__ class)}]
       (apply-message-to class seeded :add-instance-values args))))

(def send-to
     (fn [instance message & args]
      (let [class (eval (:__class_symbol__ instance))]
      (apply-message-to class instance message args))))


(def Point
{
  :__own_symbol__ 'Point
  :__instance_methods__
  {
    :add-instance-values (fn [this x y]
                           (assoc this :x x :y y))
    :class :__class_symbol__
    :shift (fn [this xinc yinc]
             (make Point (+ (:x this) xinc)
                         (+ (:y this) yinc)))
    :add (fn [this other]
           (send-to this :shift (:x other)
                                (:y other)))
   }
 })

;;(apply-message-to Point (make Point 1 2) :shift [1 3])

;;(send-to (make Point 1 2) :shift [1 3])


;; Exercise 5.4.2

(def Point
{
  :__own_symbol__ 'Point
  :__instance_methods__
  {
    :add-instance-values (fn [this x y]
                           (assoc this :x x :y y))
    :class-name :__class_symbol__
    :class (fn [this] (eval (:__class_symbol__  this)))
    :shift (fn [this xinc yinc]
             (make Point (+ (:x this) xinc)
                         (+ (:y this) yinc)))
    :add (fn [this other]
           (send-to this :shift (:x other)
                                (:y other)))
   }
 })

(def point (make Point 1 2))
(send-to point :class-name)
(send-to point :class)

;; Exercise 5.4.3
(def point (make Point 1 2))


(def Point
{
  :__own_symbol__ 'Point
  :__instance_methods__
  {
    :origin (fn [this] (make Point 0 0))
    :add-instance-values (fn [this x y]
                           (assoc this :x x :y y))
    :class-name :__class_symbol__
    :class (fn [this] (eval (:__class_symbol__  this)))
    :shift (fn [this xinc yinc]
             (make Point (+ (:x this) xinc)
                         (+ (:y this) yinc)))
    :add (fn [this other]
           (send-to this :shift (:x other)
                                (:y other)))
   }
 })

(send-to point :origin)


;; Exercise 5.4.4
(def method-from-message
  (fn [message class]
    (message (:__instance_methods__ class))))

(def apply-message-to
(fn [class instance message args]
    (apply (or (method-from-message message class) message) instance args)))

;;(send-to (make Holder "stuff") :held)

(def Holder
{
  :__own_symbol__ 'Holder
  :__instance_methods__
  {
    :add-instance-values (fn [this held]
                           (assoc this :held held))
  }
})

(def send-to
     (fn [instance message & args]
      (let [class (eval (:__class_symbol__ instance))]
      (apply-message-to class instance message args))))


