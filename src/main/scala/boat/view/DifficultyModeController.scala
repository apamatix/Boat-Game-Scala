package boat.view

import boat.MainApp
import scalafx.event.ActionEvent
import scalafx.scene.image.{Image, ImageView}
import scalafxml.core.macros.sfxml

@sfxml
class DifficultyModeController(private val appBackground: ImageView) {
  appBackground.image = new Image("/image/mainBackground.jpg", 900, 600, false, false)

  // Method to start the game with the chosen difficulty
  def startGameEasy(action: ActionEvent): Unit = {
    MainApp.showGame(1)
  }
  //method to show game board with hard difficulty
  def startGameHard(action: ActionEvent): Unit = {
    MainApp.showGame(2)
  }

}
