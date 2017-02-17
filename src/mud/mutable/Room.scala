package mud.mutable

object Room {
  def apply(n: xml.Node): Room = {
    val name = (n \ "@name").text.trim
    val key = (n \ "@keyword").text.trim
    val desc = (n \ "description").text.trim
    val exits = (n \ "exit").map(enode => {
      (enode \ "@dir").text -> (enode \ "@dest").text
    }).toMap
    val items = (n \ "item").map(inode => Item(inode)).toList
    new Room(name, key, desc, exits, items)
  }
}

class Room(
  val name: String,
  val keyword: String,
  val description: String,
  val exits: Map[String, String],
  private var items: List[Item]) {
  
  def print(): Unit = {
    println(name)
    println(description)
    println("Exits: "+exits.keys.mkString(", "))
    println("In this room you see:")
    items.foreach(i => println(i.name))
  }

  def getItem(itemName: String): Option[Item] =
    items.find(_.matches(itemName)).map(item => {
      items = items.diff(List(item))
      item
    })

  def dropItem(item: Item): Unit = items ::= item
}