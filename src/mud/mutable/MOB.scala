package mud.mutable

class MOB(val name: String, val items: List[Item], private var mCurrentRoom: String) extends Character {
  def currentRoom = mCurrentRoom
}