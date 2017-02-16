object Patterns {
  val strs = "Welcome to the Scala worksheet".split(" ")
                                                  //> strs  : Array[String] = Array(Welcome, to, the, Scala, worksheet)
  
  val lst = List(1,2,3,4,5)                       //> lst  : List[Int] = List(1, 2, 3, 4, 5)
  
  val Array(hour, minute, second) = "5:36:43".split(":")
                                                  //> hour  : String = 5
                                                  //| minute  : String = 36
                                                  //| second  : String = 43
  
  List(1,2,3)                                     //> res0: List[Int] = List(1, 2, 3)
  
  1::2::3::Nil                                    //> res1: List[Int] = List(1, 2, 3)
  
  def listLength(lst:List[Int]):Int = lst match {
  	case Nil => 0
  	case h::t => 1+listLength(t)
  }                                               //> listLength: (lst: List[Int])Int
  
  listLength(lst)                                 //> res2: Int = 5
  
  lst.find(_>2) match {
  	case None => "Not found"
  	case Some(i) => "Found "+i
  }                                               //> res3: String = Found 3
  
  case class Person(name:String,age:Int)
  
  val people = Array(Person("Mark",40), Person("Amber",13))
                                                  //> people  : Array[Patterns.Person] = Array(Person(Mark,40), Person(Amber,13))
                                                  //| 
  
  val Person(n,a) = people(0)                     //> n  : String = Mark
                                                  //| a  : Int = 40
}