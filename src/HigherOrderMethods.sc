object HigherOrderMethods {
  val a = Array(1,2,3,4,5)                        //> a  : Array[Int] = Array(1, 2, 3, 4, 5)
  val b = List(5,2,8,1,9)                         //> b  : List[Int] = List(5, 2, 8, 1, 9)
  val c = Vector.tabulate(10)(i => i*i)           //> c  : scala.collection.immutable.Vector[Int] = Vector(0, 1, 4, 9, 16, 25, 36,
                                                  //|  49, 64, 81)
  a.map(_*2)                                      //> res0: Array[Int] = Array(2, 4, 6, 8, 10)
  b.filter(_<5)                                   //> res1: List[Int] = List(2, 1)
  
}