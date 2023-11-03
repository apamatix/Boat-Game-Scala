  package boat.model

  import scala.util.Random

  abstract class Item() {
    var strength: Int
    var location: Int

    def createStrength(): Unit = {
      strength = 1 + Random.nextInt(4)
    }
  }

  class Current extends Item {
    var strength = 0
    var location = 1 + new Random().nextInt(98)
  }

  class Trap extends Item {
    var strength = 0
    var location = 1 + new Random().nextInt(98)
  }

  class Blank extends Item {
    var strength = 0
    var location = 1 + new Random().nextInt(98)
  }
