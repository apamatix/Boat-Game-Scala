package boat.view

import scalafxml.core.macros.sfxml
import boat.MainApp
import scalafx.scene.image.{ImageView, Image}
import scalafx.event.ActionEvent

@sfxml
class MenuController(private val appLogo: ImageView, private val appBackground: ImageView) {
  appLogo.image = new Image("/image/mainAppLogo.png")
  appBackground.image = new Image("/image/mainBackground.jpg", 900, 600, false, false)

  def handleStart(action: ActionEvent): Unit = {
    MainApp.showDifficultyMode()
  }

  def handleExit(action: ActionEvent): Unit = {
    System.exit(0)
  }

  def handleGameplayTutorial(action: ActionEvent): Unit = {
    MainApp.showTutorial()
  }
}