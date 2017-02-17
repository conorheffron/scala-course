package mud.immutable

trait Character {
  val name: String
  val items: List[Item]
  val currentRoom: String
}