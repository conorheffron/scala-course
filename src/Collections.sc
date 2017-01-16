object Collections {
  
	val arr = Array(1,2,3)                    //> arr  : Array[Int] = Array(1, 2, 3)
	
	val lst = List(7,2,4,9)                   //> lst  : List[Int] = List(7, 2, 4, 9)
	
	arr(0)                                    //> res0: Int = 1
	
	lst(2)                                    //> res1: Int = 4
	
	arr(0) = 99
	
	arr                                       //> res2: Array[Int] = Array(99, 2, 3)
	
	val lst2 = 1 :: lst                       //> lst2  : List[Int] = List(1, 7, 2, 4, 9)
	
	lst                                       //> res3: List[Int] = List(7, 2, 4, 9)

}