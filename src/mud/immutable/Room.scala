package mud.immutable

object Room {
  def apply(n: xml.Node): Room = {
    val name = (n \ "@name").text.trim
    val key = (n \ "@keyword").text.trim
    val desc = (n \ "description").text.trim
    val exits = (n \ "exit").map(enode => {
      (enode \ "@dir").text -> (enode \ "@dest").text
    }).toMap
    val items = (n \ "item").map(inode => Item(inode)).toList
    Room(name, key, desc, exits, items)
  }
}

case class Room(
  name: String,
  keyword: String,
  description: String,
  exits: Map[String, String],
  items: List[Item]) {
  
  def print(): Unit = {
    println(name)
    println(description)
    println("Exits: "+exits.keys.mkString(", "))
    println("In this room you see:")
    items.foreach(i => println(i.name))
  }

  def getItem(itemName: String): Option[(Item, Room)] =
    items.find(_.matches(itemName)).map(item => (item, copy(items = items.diff(List(item)))))

  def dropItem(item: Item): Room = copy(items = item :: items)
}