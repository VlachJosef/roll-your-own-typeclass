package typeclass2.repositories

import typeclass2.model.UserData
import play.api.libs.json.Json
import scala.concurrent.Future

class UserRepository {
  def findRegistration(registrationNumber: String): Future[Option[UserData]] = {
    Future.successful(Some(UserData(Json.obj("id" -> "123"))))
  }
}
