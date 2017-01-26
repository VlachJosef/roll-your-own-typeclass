package typeclass.tc

trait Show[T] {
  def apply(obj: T): String
}

object Show {
  implicit object StringShow extends Show[String] {
    def apply(obj: String): String = obj
  }

  implicit object BooleanShow extends Show[Boolean] {
    def apply(obj: Boolean): String = obj.toString()
  }
}
