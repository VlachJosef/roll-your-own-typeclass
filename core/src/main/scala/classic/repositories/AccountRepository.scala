package classic.repositories

import play.api.libs.json.{ JsObject, Json }
import scala.concurrent.Future

class AccountRepository {
  def findAccount(accountNumber: String): Future[Option[JsObject]] = {
    Future.successful(Some(Json.obj("id" -> "123")))
  }
}
