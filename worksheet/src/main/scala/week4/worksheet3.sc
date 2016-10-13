trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
    case Prod(e1, e2) => e1.eval * e2.eval
  }

  def show: String = this match {
    case Number(n) => "" + n
    case Var(e) => "" + e
    case Prod(Sum(e1, e2), Sum(e3, e4)) =>
      "(" + e1.show + "+" + e2.show + ")" + "*" + "(" + e3.show + "+" + e4.show + ")"
    case Prod(Sum(e1, e2), e3) =>
      "(" + e1.show + "+" + e2.show + ")" + "*" + e3.show
    case Prod(e1, Sum(e2, e3)) =>
      e1.show + "*" + "(" + e2.show + "+" + e3.show + ")"
    case Sum(e1, e2) => e1.show + "+" + e2.show
    case Prod(e1, e2) => e1.show + "*" + e2.show
  }
}

case class Number(n: Int) extends Expr
case class Var(e1: String) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr

// ---

val t1 = Sum(Number(2), Number(3))
t1.show

val t2 = Prod(Number(2), Number(3))
t2.show

val t3 = Sum(Var("x"), Var("y"))
t3.show

val x1 = Sum(Prod(Number(2), Var("x")), Var("y"))
x1.show

val x2 = Prod(Sum(Number(2), Var("x")), Var("y"))
x2.show

val x3 = Prod(Sum(Prod(Sum(Sum(Var("x"), Var("c")), Var("y")), Sum(Var("a"), Var("b"))), Var("g")), Var("t"))
x3.show
