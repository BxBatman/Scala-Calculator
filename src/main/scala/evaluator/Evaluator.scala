package evaluator

import scala.annotation.switch

class Evaluator {
  @throws(classOf[ArithmeticException])
  def evaluate(expression: String): Double = {
    for (operator <- Array("+", "-", "*", "/")) {

      val expressionReversed = expression.reverse

      val i = expressionReversed.indexOf(operator)
      val position = expressionReversed.length -i -1

      if (position > 0 && position < expression.length) {

        val left = expression.substring(0,position)
        val right = expression.substring(position+1,expression.length())

        val value0 = evaluate(left)
        val value1 = evaluate(right)

        val res = operator match {
          case "+" => value0.+(value1)
          case "-" => value0.-(value1)
          case "/" => {
            if(value1 !=0.0) {
              value0./(value1)
            } else {
              throw new ArithmeticException("Cannot divide by zero")
            }
          }
          case "*" => value0.*(value1)
        }




        return res
      }
    }
    return expression.toDouble
  }

}
