object SyntacticSugar {
  val a = Array(1,2,3,4)                          //> a  : Array[Int] = Array(1, 2, 3, 4)
  
  a foreach println                               //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  
  def foo(i:Int):Unit = 0                         //> foo: (i: Int)Unit
  
  foo(5)
  
  foo{5}
  
    foo {
  	println("hi")
  	7
  }                                               //> hi
  
  Array.fill(5)({})                               //> res0: Array[Unit] = Array((), (), (), (), ())
  Array.fill(5){}                                 //> res1: Array[Unit] = Array((), (), (), (), ())
  
  def myWhile(cond: => Boolean)(body: => Unit):Unit ={
  	if (cond) {
  		body
  		myWhile(cond)(body)
  	}
  }                                               //> myWhile: (cond: => Boolean)(body: => Unit)Unit

	var i = 0                                 //> i  : Int = 0
	
	myWhile(i<5) {
		println(i)
		i += 1
	}                                         //> 0
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  
  i = 0
	while(i<5) {
		println(i)
		i += 1
	}                                         //> 0
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
	

}