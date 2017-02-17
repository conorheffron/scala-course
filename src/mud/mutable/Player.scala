package mud.mutable

object Player {
  def apply(name: String,room: String): Player = {
    new Player(name, Nil, room)
  }

  private val commands: Map[String, (String, Player, Map[String, Room]) => Unit] = Map(
    "get" -> ((args, p, rooms) => {
      rooms(p.currentRoom).getItem(args).map(item => {
        p.mItems ::= item
      }) getOrElse {
        println("Item not found.")
      }
    }),
    "drop" -> ((args, p, rooms) => {
      p.items.find(_.matches(args)).map(item => {
        p.mItems = p.items.diff(List(item))
        rooms(p.currentRoom).dropItem(item)
      }) getOrElse {
        println("You don't have that item to drop.")
      }
    }),
    "look" -> ((args, p, rooms) => {
      rooms(p.currentRoom).print()
    }),
    "inv" -> ((args, p, rooms) => {
      println("Your inventory includes:")
      p.items.foreach(i => println(i.name))
    }),
    "help" -> ((args, p, rooms) => {
      println("Your current commands are: "+commands.keys.toArray.sorted.mkString(", "))
    })
  )
}

class Player(val name: String, private var mItems: List[Item], private var mCurrentRoom: String) extends Character {
  def process(input: String, rooms: Map[String, Room]): Unit = {
    if (rooms(currentRoom).exits.contains(input)) {
      mCurrentRoom = rooms(currentRoom).exits(input)
      rooms(currentRoom).print()
    } else {
      val (command, args) = parseCommand(input)
      if (Player.commands.contains(command)) {
        Player.commands(command)(args.trim, this, rooms)
      } else {
        println("Invalid command.")
      }
    }
  }

  def parseCommand(input: String): (String, String) = {
    input.indexWhere(_.isWhitespace) match {
      case -1 => (input, "")
      case i => input.splitAt(i)
    }
  }
  
  def items = mItems
  
  def currentRoom = mCurrentRoom
}