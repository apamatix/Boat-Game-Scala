package boat

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes._
import scalafxml.core.{FXMLLoader, NoDependencyResolver}
import javafx.{scene => jfxs}
import scalafx.scene.image.Image
import scalafx.scene.media.{Media, MediaPlayer}

object MainApp extends JFXApp {

  var difficultyMode: Int = 1


  def showDifficultyMode(): Unit = {
    val resource = getClass.getResource("view/DifficultySelection.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]()
    this.roots.setCenter(roots)
  }

  // load root layout
  val rootResource = getClass.getResource("view/RootLayout.fxml")
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  loader.load()
  val roots = loader.getRoot[jfxs.layout.BorderPane]

  // Initialize stage
  stage = new PrimaryStage {
    title = "Boat Game"
    scene = new Scene() {
      root = roots
      val music = new Media(getClass().getResource("/mediaGame/GameMusic.mp3").toString)
      val player = new MediaPlayer(music) {
        autoPlay = true
        cycleCount = MediaPlayer.Indefinite
        volume = 0.5 // Set the volume to 50%
      }
    }
    // Set fixed window dimensions
    minWidth = 900
    minHeight = 675
    maxWidth = 900
    maxHeight = 675

    icons += new Image(
      getClass().getResourceAsStream("/image/mainAppLogo.png")
    )
  }

  // function to load main menu
  def showMainMenu(): Unit = {
    val resource = getClass.getResource("view/Menu.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  // function to load instructions page
  def showTutorial(): Unit = {
    val resource = getClass.getResource("view/GameplayTutorial.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  // function to load game
  def showGame(mode: Int): Unit = {
    val resource = getClass.getResource("view/GameLogic.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
    difficultyMode = mode
  }

  // show main menu when app starts
  showMainMenu()
}