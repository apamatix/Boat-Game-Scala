package boat.view

import scalafxml.core.macros.sfxml
import boat.MainApp
import scalafx.event.ActionEvent

@sfxml
class GameplayTutorialController() {
  def handleBack(action: ActionEvent): Unit = {
    MainApp.showMainMenu()
  }
}