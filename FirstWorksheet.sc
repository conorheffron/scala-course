object FirstWorksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val a = 5                                       //> a  : Int = 5
  
  var b = 5                                       //> b  : Int = 5
  
  var i = 5                                       //> i  : Int = 5
  
  if(a>90) println("yep")
  val nextif = if(a>90) println("yep")            //> nextif  : Unit = ()
  
  val next = if (a%2==0) a/2 else 3*a+1           //> next  : Int = 16
  
  if (a<9) 4                                      //> res0: AnyVal = 4
  if (a<9) "4" else ()                            //> res1: Any = 4
  
  4.toString()                                    //> res2: String = 4
  
  5.toInt                                         //> res3: Int = 5
}