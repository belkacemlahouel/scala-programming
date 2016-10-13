
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.head")
}

object List {
  def apply(a: Int, b: Int): List[Int] =
    new Cons[Int](a, new Cons[Int](b, new Nil[Int]))

  def apply(a: Int): List[Int] =
    new Cons[Int](a, new Nil[Int])

  def apply(): List[Int] =
    new Nil[Int]
}

def List(a: Int, b: Int): List[Int] =
  List.apply(a, b)

def List(a: Int): List[Int] = List.apply(a)

def List(): List[Int] = List.apply()
