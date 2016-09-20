package funsets

import FunSets._

object Main extends App {

  println(!contains(singletonSet(2), 1))
  println(contains(singletonSet(1), 1))

  println(!contains(union(singletonSet(1), singletonSet(2)), 3))
  println(contains(union(singletonSet(1), singletonSet(2)), 2))

  println(!contains(intersect(singletonSet(1), singletonSet(2)), 10))
  println(contains(intersect(singletonSet(1), singletonSet(1)), 1))

  println(!contains(diff(singletonSet(1), singletonSet(2)), 2))
  println(contains(diff(singletonSet(1), singletonSet(2)), 1))

  println(!contains(filter(singletonSet(1), (x: Int) => x+x > 2), 1))
  println(contains(filter(singletonSet(1), (x: Int) => x+x == 2), 1))

  //---

  def s: Set = union(union(singletonSet(1), singletonSet(2)), singletonSet(3))

  println(contains(s, 1))
  println(contains(s, 2))
  println(contains(s, 3))
  println(!contains(s, 4))

  println(!forall(s, (x: Int) => (x < 2)))
  println(forall(s, (x: Int) => (x < 4)))

  println(!exists(s, x => x > 4))
  println(exists(s, x => x < 2))


  def s_sq: Set = map(s, x => x*x)
  println(contains(s_sq, 1))
  println(!contains(s_sq, 2))

  println("Done!")
}
