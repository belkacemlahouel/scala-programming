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
}
