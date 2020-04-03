import evaluator.Evaluator
import javafx.event.EventHandler
import javafx.fxml.FXML
import javafx.scene.input
import scalafx.scene.control.{Button, Label}
import scalafx.scene.input.MouseEvent
import scalafxml.core.macros.sfxml

@sfxml
class CalculatorPresenter(private val display: Label,
                          private val displayExpression: Label,
                          private val oneButton: Button,
                          private val twoButton: Button,
                          private val threeButton: Button,
                          private val fourButton: Button,
                          private val fiveButton: Button,
                          private val sixButton: Button,
                          private val sevenButton: Button,
                          private val eightButton: Button,
                          private val nineButton: Button,
                          private val zeroButton: Button,
                          private val mul: Button,
                          private val div: Button,
                          private val sub: Button,
                          private val add: Button,
                          private val equal: Button,
                          private val dot: Button,
                          private val clear: Button) {

  var isDot: Boolean = false

  oneButton.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("1");
    }
  })

  twoButton.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("2");
    }
  })

  threeButton.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("3");
    }
  })

  fourButton.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("4");
    }
  })

  fiveButton.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("5");
    }
  })

  sixButton.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("6");
    }
  })

  sevenButton.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("7");
    }
  })


  eightButton.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("8");
    }
  })

  nineButton.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("9");
    }
  })

  zeroButton.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("0");
    }
  })

  add.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("+");
      isDot=false
    }
  })

  div.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("/");
      isDot=false
    }
  })

  sub.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("-");
      isDot=false
    }
  })

  mul.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("*");
      isDot=false
    }
  })

  clear.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("");
      display.setText("")
      displayExpression.setText("")
      disableOperatorButtons()
      isDot=false
    }
  })

  dot.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      if (isDot ==false) {
        appendOnExpression(".")
        isDot = true
      }
    }
  })

  equal.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      if (displayExpression.getText.equals("")) {
        displayExpression.setText("0")
      }

      if(!Array("+", "-", "*", "/", ".").contains(displayExpression.getText().last.toString())) {
        val evaluator = new Evaluator()
        val result = evaluator.evaluate(displayExpression.getText())
        display.text = result.toString()
      }
    }
  })


  disableOperatorButtons()



  def disableOperatorButtons() {
    add.setDisable(true)
    div.setDisable(true)
    mul.setDisable(true)
    sub.setDisable(true)
    dot.setDisable(true)
  }


  def enableOperatorButtons() {
    add.setDisable(false)
    div.setDisable(false)
    mul.setDisable(false)
    sub.setDisable(false)
    dot.setDisable(false)
  }

  def appendOnExpression(string: String) : Unit =  {
        if(checkIfOperatorOrDotLast(string)) {
          return
        }
        checkIfOperator(string)
      display.setText("")
      displayExpression.setText(displayExpression.getText().toString().concat( string))
        enableOperatorButtons()
  }

  def checkIfOperatorOrDotLast(string: String): Boolean = {
    if (string.equals("+") || string.equals("-") || string.equals("/") || string.equals("*") || string.equals(".")) {
      if (Array("+", "-", "*", "/", ".").contains(displayExpression.getText().last.toString())) {
        return true
      }
    }
    return false
  }

  def checkIfOperator(string: String) {
    if ( !display.getText.equals("") && (string.equals("+") || string.equals("-") || string.equals("/") || string.equals("*")) ) {
      displayExpression.setText(display.getText())
    }

  }

}
