package mud.immutable

object Player {
  def apply(name: String, room: String): Player = {
    new Player(name, Nil, room)
  }

  private val commands: Map[String, (String, Player, Map[String, Room]) => (Player, Map[String, Room])] = Map(
    "get" -> ((args, p, rooms) => {
      rooms(p.currentRoom).getItem(args).map(t => {
        val (item, room) = t
        (p.copy(items = item :: p.items), rooms + (p.currentRoom -> room))
      }) getOrElse {
        println("Item not found.")
        (p, rooms)
      }
    }),
    "drop" -> ((args, p, rooms) => {
      p.items.find(_.matches(args)).map(item => {
        (p.copy(items = p.items.diff(List(item))), rooms + (p.currentRoom -> rooms(p.currentRoom).dropItem(item)))
      }) getOrElse {
        println("You don't have that item to drop.")
        (p, rooms)
      }
    }),
    "look" -> ((args, p, rooms) => {
      rooms(p.currentRoom).print()
      (p, rooms)
    }),
    "inv" -> ((args, p, rooms) => {
      println("Your inventory includes:")
      p.items.foreach(i => println(i.name))
      (p, rooms)
    }),
    "help" -> ((args, p, rooms) => {
      println("Your current commands are: " + commands.keys.toArray.sorted.mkString(", "))
      (p, rooms)
    })
  )
}

case class Player(name: String, items: List[Item], currentRoom: String) extends Character {
  def process(input: String, rooms: Map[String, Room]): (Player, Map[String, Room]) = {
    if (rooms(currentRoom).exits.contains(input)) {
      val newRoom = rooms(currentRoom).exits(input)
      rooms(newRoom).print()
      (copy(currentRoom = newRoom), rooms)
    } else {
      val (command, args) = parseCommand(input)
      if (Player.commands.contains(command)) {
        Player.commands(command)(args.trim, this, rooms)
      } else {
        println("Invalid command.")
        (this, rooms)
      }
    }
  }

  def parseCommand(input: String): (String, String) = {
    input.indexWhere(_.isWhitespace) match {
      case -1 => (input, "")
      case i => input.splitAt(i)
    }
  }
}