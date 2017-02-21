package specmethods

import org.scalatest.FlatSpec

class TestComplex extends FlatSpec {
  behavior of "Complex numbers"
  
  it should "add properly" in {
    val a = Complex(1,2)
    val b = Complex(2,3)
    assert(a+b === Complex(3,5))
  }
}