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
                          private val threeButton: Button,) {

  oneButton.setOnMouseClicked(new EventHandler[input.MouseEvent] {
    override def handle(event: input.MouseEvent) = {
      appendOnExpression("1");
    }
  })


  def appendOnExpression(string: String) =  {
    //    if(checkIfOperatorOrDotLast(string)) {
    //      return
    //    }
    //    checkIfOperator(string)
    display.setText("")
    displayExpression.setText(displayExpression.getText().toString().concat( string))
    //    enableOperatorButtons()
  }

}
