object Loops {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  var i=0                                         //> i  : Int = 0
  
  // statement
  while(i<5) {
  	println(i)
  	i += 1
  }                                               //> 0
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  
  // scala version of the above loop
  for (i <- 0 until 5) {
  	println(i)                                //> 0
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  }
  
  
  val a = Array.fill(5)(math.random)              //> a  : Array[Double] = Array(0.7184682522772871, 0.2847652212279117, 0.9290102
                                                  //| 323939415, 0.6413813058648526, 0.20295954112918557)
  
  for(x <- a) println(x)                          //> 0.7184682522772871
                                                  //| 0.2847652212279117
                                                  //| 0.9290102323939415
                                                  //| 0.6413813058648526
                                                  //| 0.20295954112918557
  
  for(x <-a) yield x*x                            //> res0: Array[Double] = Array(0.5161966295303794, 0.0810912312209815, 0.863060
                                                  //| 0118926453, 0.41136997951290366, 0.04119257533536957)
  a.map(x => x*x)                                 //> res1: Array[Double] = Array(0.5161966295303794, 0.0810912312209815, 0.863060
                                                  //| 0118926453, 0.41136997951290366, 0.04119257533536957)
  
  for(i <- 0 until 5; j <- 5 until 10) yield (i, j)
                                                  //> res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((0,5), (0,6
                                                  //| ), (0,7), (0,8), (0,9), (1,5), (1,6), (1,7), (1,8), (1,9), (2,5), (2,6), (2,
                                                  //| 7), (2,8), (2,9), (3,5), (3,6), (3,7), (3,8), (3,9), (4,5), (4,6), (4,7), (4
                                                  //| ,8), (4,9))
  // add conditional to only print even numbers for a
  for(i <- 0 until 5; if i%2==0; a = 2*i; j <- 5 until 10) yield (a, j)
                                                  //> res3: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((0,5), (0,6
                                                  //| ), (0,7), (0,8), (0,9), (4,5), (4,6), (4,7), (4,8), (4,9), (8,5), (8,6), (8,
                                                  //| 7), (8,8), (8,9))
  
  // alternate syntax using curly braces, line breaks and without semi colons
  for{i <- 0 until 5
			if i%2==0
  		a = 2*i
  		j <- 5 until 10} yield (a, j)     //> res4: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((0,5), (0,6
                                                  //| ), (0,7), (0,8), (0,9), (4,5), (4,6), (4,7), (4,8), (4,9), (8,5), (8,6), (8,
                                                  //| 7), (8,8), (8,9))
  		
  // complete function
  def foo(i:Int):Int = ???                        //> foo: (i: Int)Int
  
  // partial function
  val pf:PartialFunction[Any,String] = {
  	case i:Int => "Number"
  	case s:String => "The string "+s
  }                                               //> pf  : PartialFunction[Any,String] = <function1>
  
  pf(5)                                           //> res5: String = Number
  pf("Hello")                                     //> res6: String = The string Hello
  
}