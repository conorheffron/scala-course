object SetsMaps {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  import collection.mutable
  
  // sets
  val s = Set(1,2,3)                              //> s  : scala.collection.immutable.Set[Int] = Set(1, 2, 3)
  val s2 = s+4                                    //> s2  : scala.collection.immutable.Set[Int] = Set(1, 2, 3, 4)
  s                                               //> res0: scala.collection.immutable.Set[Int] = Set(1, 2, 3)
  
  val mutSet = mutable.Set(1,2,3)                 //> mutSet  : scala.collection.mutable.Set[Int] = Set(1, 2, 3)
  mutSet += 4                                     //> res1: SetsMaps.mutSet.type = Set(1, 2, 3, 4)
  
  // maps / tuples
  val m = Map("Texas" -> "Austin","Colorado" -> "Denver")
                                                  //> m  : scala.collection.immutable.Map[String,String] = Map(Texas -> Austin, Co
                                                  //| lorado -> Denver)
  1 -> 2                                          //> res2: (Int, Int) = (1,2)
  1 -> 2  -> 3                                    //> res3: ((Int, Int), Int) = ((1,2),3)
  
  val mutMap = mutable.Map()                      //> mutMap  : scala.collection.mutable.Map[Nothing,Nothing] = Map()
  
}