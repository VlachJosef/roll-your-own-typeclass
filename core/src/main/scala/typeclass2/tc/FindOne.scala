package typeclass2.tc

import scala.concurrent.Future
import play.api.libs.json.{ Json, JsObject }
import typeclass2.model.{ AccountData, UserData }
import typeclass2.repositories.{ AccountRepository, UserRepository }

trait FindOne[T] {
  def apply(selector: String): Future[Option[T]]
}

object FindOne {
  implicit def findOneUser(implicit userRepository: UserRepository) = new FindOne[UserData] {
    def apply(selector: String): Future[Option[UserData]] =
      userRepository.findRegistration(selector)
  }

  implicit def findOneAccount(implicit accountRepository: AccountRepository) = new FindOne[AccountData] {
    def apply(selector: String): Future[Option[AccountData]] =
      accountRepository.findAccount(selector)
  }
}
