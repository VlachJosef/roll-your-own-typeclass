package typeclass.repositories

import play.api.libs.json.{ JsObject, Json }
import scala.concurrent.Future

class UserRepository {
  def findRegistration(registrationNumber: String): Future[Option[JsObject]] = {
    Future.successful(Some(Json.obj("id" -> "123")))
  }
}
