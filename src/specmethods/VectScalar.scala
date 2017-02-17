package specmethods

object VectScalar {
  implicit def convert(c:Double):VectScalar = new VectScalar(c)
}

class VectScalar(c:Double) {
  def *(v:Vect3D) = v*c 
}