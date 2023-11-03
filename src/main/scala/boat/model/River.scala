package boat.model
import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import scala.util.control.Breaks.{break, breakable}

class River() {
  // properties
  val rivers: Array[Item] = new Array[Item](100)

  // method to fill river with random number of currents and traps
  def createRiver(difficultyMode: Int): Unit = {
    var riverItems: ArrayBuffer[Item] = new ArrayBuffer[Item]()
    var random = new Random()

    // Adjust the number of currents and traps based on difficulty mode
    val (minCurrents, maxCurrents, minTraps, maxTraps) = difficultyMode match {
      case 1 => (15, 20, 5, 10)
      case 2 => (10, 15, 10, 15)
    }

    // create currents
    var numOfCurrents: Int = minCurrents + random.nextInt(maxCurrents - minCurrents + 1)
    for (i <- 1 to numOfCurrents) {
      var current: Current = new Current()
      var isLocationValid: Boolean = false
      while (!isLocationValid) {
        var counter: Int = 0
        breakable {
          for (item <- riverItems) {
            if (current.location != item.location) {
              counter += 1
            } else { // create new current if item already exists in location
              current = new Current()
              break
            }
          }
        }


        if (counter == riverItems.size) { // add current to riverItems only when end is reached
          riverItems += current
          isLocationValid = true
        }
      }
    }

    // create traps
    var numOfTraps: Int = minTraps + random.nextInt(maxTraps - minTraps + 1)
    for (i <- 1 to numOfTraps) {
      var trap: Trap = new Trap()
      var isLocationValid: Boolean = false

      while (!isLocationValid) {
        var counter: Int = 0
        breakable {
          for (item <- riverItems) {
            if (trap.location != item.location) {
              counter += 1
            } else { // create new trap if item already exists in location
              trap = new Trap()
              break
            }
          }
        }

        if (counter == riverItems.size) { // add trap to riverItems only when end of riverItems is reached
          riverItems += trap
          isLocationValid = true
        }
      }
    }


    // initialize rivers with blank items
    for (i <- 0 to 99) {
      rivers(i) = new Blank()
    }

    // insert currents and traps into rivers
    for (item <- riverItems) {
      rivers(item.location) = item
    }

    // create new river if too many traps are next to each other -> might cause player to never move forward
    while (!isRiverValid()) {
      if (difficultyMode == 1) createRiver(1)
      else createRiver(2)
    }
  }

  // function to check if there are too many traps next to each other
  def isRiverValid(): Boolean = {
    var count: Int = 0
    for (i <- 0 to 98) {
      if (rivers(i).isInstanceOf[Trap] && rivers(i + 1).isInstanceOf[Trap]) {
        count += 1
      } else {
        count = 0
      }
    }

    if (count < 5) {
      true
    } else {
      false
    }
  }
}