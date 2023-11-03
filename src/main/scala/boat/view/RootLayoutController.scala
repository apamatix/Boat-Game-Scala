package boat.view

import boat.MainApp
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml

@sfxml
class RootLayoutController() {
  //method to close System program
  def handleClose(action: ActionEvent): Unit = {
    System.exit(0)
  }

  //method to restart game
  def handleRestart(action: ActionEvent): Unit = {
    MainApp.showDifficultyMode()
  }

  //method to display tutorial dialog
  def handleHelp(action: ActionEvent): Unit = {
    MainApp.showTutorial()
  }

}
