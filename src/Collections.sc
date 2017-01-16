object Collections {
  
  // Arrays & Lists
	val arr = Array(1,2,3)                    //> arr  : Array[Int] = Array(1, 2, 3)
	
	val lst = List(7.5,2,4,9)                 //> lst  : List[Double] = List(7.5, 2.0, 4.0, 9.0)
	
	arr(0)                                    //> res0: Int = 1
	
	lst(2)                                    //> res1: Double = 4.0
	
	// replace item in array
	arr(0) = 99
	
	arr                                       //> res2: Array[Int] = Array(99, 2, 3)
	
	// new list with 1 prepend to lst
	val lst2 = 11 :: lst                      //> lst2  : List[AnyVal] = List(11, 7.5, 2.0, 4.0, 9.0)
	
	lst                                       //> res3: List[Double] = List(7.5, 2.0, 4.0, 9.0)
	
	var arr2 = Array.fill(100)(math.random)   //> arr2  : Array[Double] = Array(0.6670033525715613, 0.7972572361746595, 0.7874
                                                  //| 001496412, 0.41184363477552843, 0.6945648524680746, 0.4852681075376515, 0.52
                                                  //| 03417839402386, 0.595960423618747, 0.25193869992827744, 0.9839117709844305, 
                                                  //| 0.5194768901464292, 0.04174239940709146, 0.6333999717262058, 0.8976167680301
                                                  //| 54, 0.3635693461172296, 0.3121672152148214, 0.020527780743225477, 0.07211762
                                                  //| 326780302, 0.21006991229146044, 0.4655379147329539, 0.6038656192117361, 0.75
                                                  //| 68717986991369, 0.07350958713335076, 0.9114408049503773, 0.1482128459641705,
                                                  //|  0.044550389917952904, 0.5057303224427335, 0.16323835956325183, 0.8234774553
                                                  //| 325561, 0.03087045980795411, 0.9866996396399667, 0.2960872820372057, 0.26071
                                                  //| 50340824904, 0.09604479127373211, 0.425475246626668, 0.9556055852514719, 0.0
                                                  //| 8692461014974817, 0.07338228353569065, 0.9179572136795793, 0.704694123631920
                                                  //| 5, 0.642367462664094, 0.8410805726938437, 0.31138463254361093, 0.34465210769
                                                  //| 434984, 0.19061964347347
                                                  //| Output exceeds cutoff limit.
	
	//def littleArray(i:Int):Array[Int] = Array(i,i,i)
	// rocket operator
	def littleArray(i: => Int):Array[Int] = Array(i,i,i)
                                                  //> littleArray: (i: => Int)Array[Int]
	
	littleArray(util.Random.nextInt(10))      //> res4: Array[Int] = Array(4, 8, 7)
	
	// square each items position for item value
	val arr3 = Array.tabulate(10)(i => i*i)   //> arr3  : Array[Int] = Array(0, 1, 4, 9, 16, 25, 36, 49, 64, 81)
	

	// Vector
	val arr4 = Vector(1,2,3)                  //> arr4  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3)
	
	// Buffer (requires import)
	import collection.mutable
	mutable.Buffer(1,2,3)                     //> res5: scala.collection.mutable.Buffer[Int] = ArrayBuffer(1, 2, 3)
	mutable.ListBuffer(2,3,1)                 //> res6: scala.collection.mutable.ListBuffer[Int] = ListBuffer(2, 3, 1)
	
	// ranges
	10 to 1 by -1                             //> res7: scala.collection.immutable.Range = Range(10, 9, 8, 7, 6, 5, 4, 3, 2, 1
                                                  //| )
  0 to 25 by 5                                    //> res8: scala.collection.immutable.Range = Range(0, 5, 10, 15, 20, 25)
  
  // ranges synta explained with ops below
	(1).+(2)                                  //> res9: Int(3) = 3
	(1).to(10)                                //> res10: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 
                                                  //| 7, 8, 9, 10)
	
	arr ++: arr2                              //> res11: scala.collection.mutable.ArraySeq[AnyVal{def getClass(): Class[_ >: D
                                                  //| ouble with Int <: AnyVal]}] = Array(99, 2, 3, 0.6670033525715613, 0.79725723
                                                  //| 61746595, 0.7874001496412, 0.41184363477552843, 0.6945648524680746, 0.485268
                                                  //| 1075376515, 0.5203417839402386, 0.595960423618747, 0.25193869992827744, 0.98
                                                  //| 39117709844305, 0.5194768901464292, 0.04174239940709146, 0.6333999717262058,
                                                  //|  0.897616768030154, 0.3635693461172296, 0.3121672152148214, 0.02052778074322
                                                  //| 5477, 0.07211762326780302, 0.21006991229146044, 0.4655379147329539, 0.603865
                                                  //| 6192117361, 0.7568717986991369, 0.07350958713335076, 0.9114408049503773, 0.1
                                                  //| 482128459641705, 0.044550389917952904, 0.5057303224427335, 0.163238359563251
                                                  //| 83, 0.8234774553325561, 0.03087045980795411, 0.9866996396399667, 0.296087282
                                                  //| 0372057, 0.2607150340824904, 0.09604479127373211, 0.425475246626668, 0.95560
                                                  //| 55852514719, 0.08692461014974817, 0.07338228353569065, 0.9179572136795793, 0
                                                  //| .7046941236319205, 0.642
                                                  //| Output exceeds cutoff limit.
	
	2 +: arr :+ 9                             //> res12: Array[Int] = Array(2, 99, 2, 3, 9)
	
	arr                                       //> res13: Array[Int] = Array(99, 2, 3)
	
	// useful array methods
	arr.length                                //> res14: Int = 3
	
	arr.tail                                  //> res15: Array[Int] = Array(2, 3)
	
	arr.reverse                               //> res16: Array[Int] = Array(3, 2, 99)
	
	var (before, after) = arr.splitAt(1)      //> before  : Array[Int] = Array(99)
                                                  //| after  : Array[Int] = Array(2, 3)
	arr2.slice(3,6)                           //> res17: Array[Double] = Array(0.41184363477552843, 0.6945648524680746, 0.4852
                                                  //| 681075376515)
	arr.take(3)                               //> res18: Array[Int] = Array(99, 2, 3)
	arr.drop(3)                               //> res19: Array[Int] = Array()
	
	
	arr.isEmpty                               //> res20: Boolean = false
	arr.nonEmpty                              //> res21: Boolean = true
	
	arr.startsWith(Array(1,2))                //> res22: Boolean = false
	
	arr.endsWith(Array(9))                    //> res23: Boolean = false
	
	arr.startsWith(Array(1,2))                //> res24: Boolean = false
	
	arr.indexOf(1)                            //> res25: Int = -1
	
	arr.sum                                   //> res26: Int = 104
	
	arr.product                               //> res27: Int = 594
	
	lst.toArray                               //> res28: Array[Double] = Array(7.5, 2.0, 4.0, 9.0)
	
	arr.par                                   //> res29: scala.collection.parallel.mutable.ParArray[Int] = ParArray(99, 2, 3)
                                                  //| 
	
	arr                                       //> res30: Array[Int] = Array(99, 2, 3)
	val arr5 = Array(1,3,7,8,9)               //> arr5  : Array[Int] = Array(1, 3, 7, 8, 9)
	
	arr.intersect(arr5)                       //> res31: Array[Int] = Array(3)
	arr.union(arr5).distinct                  //> res32: Array[Int] = Array(99, 2, 3, 1, 7, 8, 9)
	arr.diff(arr5)                            //> res33: Array[Int] = Array(99, 2)
	
	arr5.mkString("{",", ","}")               //> res34: String = {1, 3, 7, 8, 9}
	
	arr5.view                                 //> res35: scala.collection.mutable.IndexedSeqView[Int,Array[Int]] = SeqView(..
                                                  //| .)
  arr5.zip(arr)                                   //> res36: Array[(Int, Int)] = Array((1,99), (3,2), (7,3))
  
  
  arr5.zip(arr5.indices)                          //> res37: Array[(Int, Int)] = Array((1,0), (3,1), (7,2), (8,3), (9,4))
	arr5.zipWithIndex                         //> res38: Array[(Int, Int)] = Array((1,0), (3,1), (7,2), (8,3), (9,4))
	
}