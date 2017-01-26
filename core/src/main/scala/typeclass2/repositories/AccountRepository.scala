package typeclass2.repositories

import typeclass2.model.AccountData
import play.api.libs.json.Json
import scala.concurrent.Future

class AccountRepository {
  def findAccount(accountNumber: String): Future[Option[AccountData]] = {
    Future.successful(Some(AccountData(Json.obj("id" -> "123"))))
  }
}
