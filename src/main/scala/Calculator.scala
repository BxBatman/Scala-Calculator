import javafx.{fxml => jfxf, scene => jfxs}
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafxml.core.{FXMLView, NoDependencyResolver}

object Calculator extends JFXApp {
  val resource = getClass.getResource("Calculator.fxml");

  val root = FXMLView(resource, NoDependencyResolver)
  stage = new PrimaryStage() {
    title = "ScalaFX Sandbox"
    scene = new Scene(root) {
      stylesheets = List(getClass.getResource("style.css").toExternalForm)
    }
  }



}
