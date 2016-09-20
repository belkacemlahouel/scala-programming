package funsets

import FunSets._

object Main extends App {

  println(contains(singletonSet(1), 1) == true)
  println(contains(singletonSet(2), 1) == false)
  println(contains(union(singletonSet(1), singletonSet(2)), 3) == false)
  println(contains(union(singletonSet(1), singletonSet(2)), 2) == true)
  println(contains(intersect(singletonSet(1), singletonSet(2)), 10) == false)
  println(contains(intersect(singletonSet(1), singletonSet(1)), 1) == true)
  println(contains(diff(singletonSet(1), singletonSet(2)), 2) == false)
  println(contains(diff(singletonSet(1), singletonSet(2)), 1) == true)
  println(contains(filter(singletonSet(1), (x: Int) => x+x > 2), 1) == false)
  println(contains(filter(singletonSet(1), (x: Int) => x+x == 2), 1) == true)
}
