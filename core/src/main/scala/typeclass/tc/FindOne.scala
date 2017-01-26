package typeclass.tc

import scala.concurrent.Future
import play.api.libs.json.JsObject
import typeclass.repositories.{ AccountRepository, UserRepository }

trait FindOne[T] {
  def apply(selector: String): Future[Option[T]]
}

object FindOne {
  implicit def findOneUser(implicit userRepository: UserRepository) = new FindOne[JsObject] {
    def apply(selector: String): Future[Option[JsObject]] =
      userRepository.findRegistration(selector)
  }

  implicit def findOneAccount(implicit accountRepository: AccountRepository) = new FindOne[JsObject] {
    def apply(selector: String): Future[Option[JsObject]] =
      accountRepository.findAccount(selector)
  }
}
