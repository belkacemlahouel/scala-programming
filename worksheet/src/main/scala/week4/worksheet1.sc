
object mytrue extends MyBool {
  def ifThenElse[T](t: => T, e: => T) = t
}

object myfalse extends MyBool {
  def ifThenElse[T](t: => T, e: => T) = e
}

abstract class MyBool {
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => MyBool): MyBool = ifThenElse(x, myfalse)
  def || (x: => MyBool): MyBool = ifThenElse(mytrue, x)
  def unary_! : MyBool = ifThenElse(myfalse, mytrue)

  def == (x: MyBool): MyBool = ifThenElse(x, x.unary_!)
  def != (x: MyBool): MyBool = ifThenElse(x.unary_!, x)

  def < (x: MyBool): MyBool = ifThenElse(myfalse, x)
}

object Zero extends Nat {
  def isZero: Boolean = true
  def pred: Nat = throw new Error()
  def + (that: Nat): Nat = that
  def - (that: Nat): Nat = if (that.isZero) Zero else throw new Error()
}

class Succ(n: Nat) extends Nat {
  def isZero = false
  def pred = n
  def + (that: Nat) = if (that.isZero) this else succ + that.pred // new Succ(n + that)
  def - (that: Nat) = if (that.isZero) this else n - that.pred
}

abstract class Nat {
  def isZero: Boolean
  def pred: Nat
  def succ: Nat = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

//---

def a: MyBool = mytrue
def b: MyBool = myfalse
a < b
b < a
a < a
b < b
