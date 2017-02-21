package specmethods

import org.junit._
import org.junit.Assert._

class TestVect3D {
  @Test def testAddition:Unit = {
    val v1 = Vect3D(1, 2, 3)
    val v2 = Vect3D(4, 5, 6)
    val v3 = v1 + v2
    assertEquals("Addition failed.", Vect3D(5, 7, 9), v3)
  }

  @Test def testMultiplication:Unit = {
    val v1 = Vect3D(1, 2, 3)
    val v2 = v1 * 3
    assertEquals("Multiplication failed.", Vect3D(3, 6, 9), v2)
  }
  
  @Test def testCross:Unit = {
    val v1 = Vect3D(1,0,0)
    val v2 = Vect3D(0,1,0)
    val v3 = v1 cross v2
    assertEquals("Cross product failed.",Vect3D(0,0,1),v3)
  }

}