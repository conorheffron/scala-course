package mud.mutable

import io.StdIn._
import scala.annotation.tailrec

object MUDServer extends App {
  println("What is your name?")
  val player = Player(readLine(),"inn")
  val rooms = (xml.XML.loadFile("src/map.xml") \ "room").map(n => {
    val room = Room(n)
    room.keyword -> room
  }).toMap
  println("Welcome to a simple text adventure.")
  rooms(player.currentRoom).print()
  var input = ""
  while(input != "quit") {
    print("> ")
    input = readLine().trim
    if (input != "quit") {
      player.process(input, rooms)
    }
  }
  println("Goodbye!")
}