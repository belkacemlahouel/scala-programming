package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c < 0 || c > r) 0
    else if (c == 0 && r == 0) 1
    else pascal(c-1, r-1) + pascal(c, r-1)
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def test(cur: Integer, open: Integer, close: Integer): Boolean =
        if (cur >= chars.length) (open == close)
        else if (chars(cur) == ')') if (open <= close) false else test(cur + 1, open, close + 1)
        else if (chars(cur) == '(') test(cur + 1, open + 1, close)
        else test(cur + 1, open, close)

      test(0, 0, 0)
    }


  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
  }
