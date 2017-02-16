object IteratorsSources {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  case class TempData(firstName:String,surname:String,age:Int)
  
  def parseLine(line:String):TempData = {
  	val p = line.split(",").map(_.trim)
  	TempData(p(0).toString,p(1).toString,p(2).toInt)
  }                                               //> parseLine: (line: String)IteratorsSources.TempData
  
  new java.io.File(".").getAbsolutePath()         //> res0: String = C:\eclipse-jee-neon-R-win32-x86_64\.
  val source = io.Source.fromFile("test.csv")     //> source  : scala.io.BufferedSource = non-empty iterator
  
  val lines = source.getLines                     //> lines  : Iterator[String] = non-empty iterator
 	lines.next                                //> res1: String = firstName,surname,age
  val data = lines.map(parseLine).toArray         //> data  : Array[IteratorsSources.TempData] = Array(TempData(joe,bloggs,55), Te
                                                  //| mpData(conor,heffron,28))
  
  source.close
  
}