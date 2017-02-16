object HigherOrderMethods {
  val a = Array(1, 2, 3, 4, 5)                    //> a  : Array[Int] = Array(1, 2, 3, 4, 5)
  val b = List(5, 2, 8, 1, 9)                     //> b  : List[Int] = List(5, 2, 8, 1, 9)
  val c = Vector.tabulate(10)(i => i * i)         //> c  : scala.collection.immutable.Vector[Int] = Vector(0, 1, 4, 9, 16, 25, 36,
                                                  //|  49, 64, 81)

  a.foreach(println)                              //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
  a.map(i => i * 2)                               //> res0: Array[Int] = Array(2, 4, 6, 8, 10)

  a.map(_ * 2)                                    //> res1: Array[Int] = Array(2, 4, 6, 8, 10)
  a.map(_ * 2.0)                                  //> res2: Array[Double] = Array(2.0, 4.0, 6.0, 8.0, 10.0)
  a.map(_ + " is a number")                       //> res3: Array[String] = Array(1 is a number, 2 is a number, 3 is a number, 4 i
                                                  //| s a number, 5 is a number)
  b.filter(_ < 5)                                 //> res4: List[Int] = List(2, 1)

  a.map(i => b.take(i))                           //> res5: Array[List[Int]] = Array(List(5), List(5, 2), List(5, 2, 8), List(5, 2
                                                  //| , 8, 1), List(5, 2, 8, 1, 9))
  a.flatMap(i => b.take(i))                       //> res6: Array[Int] = Array(5, 5, 2, 5, 2, 8, 5, 2, 8, 1, 5, 2, 8, 1, 9)

  c.exists(_ > 50)                                //> res7: Boolean = true
  c.forall(_ < 50)                                //> res8: Boolean = false

  a.reduceLeft((x, y) => x + y)                   //> res9: Int = 15
  a.reduceLeft(_ + _)                             //> res10: Int = 15

  a.foldLeft(0)(_ + _)                            //> res11: Int = 15
  a.foldLeft("0")(_ + _)                          //> res12: String = 012345
  
  b.find(_ == 8)                                  //> res13: Option[Int] = Some(8)
  b.find(_%3 == 0)                                //> res14: Option[Int] = Some(9)
  b.find(_%7 == 0)                                //> res15: Option[Int] = None
  
  b.find(_%3 == 0).map(_/3)                       //> res16: Option[Int] = Some(3)
  
  b.find(_%3 == 0).map(_/3).getOrElse(0)          //> res17: Int = 3

}