package boat.model

import scala.util.Random

class Player() {
  // properties
  var location: Int = 0

  // methods
  def diceRoll(): Int = {
    1 + Random.nextInt(6)
  }
}

