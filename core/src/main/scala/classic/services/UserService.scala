package classic.services

import model.RegisterRequest
import play.api.libs.json.{ JsObject, Json }
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import classic.repositories.UserRepository

class UserService(userRepository: UserRepository) {
  def register(
    rr: RegisterRequest
  ): Future[JsObject] = {
    userRepository.findRegistration(rr.registrationNumber).map {
      case None => Json.obj("id" -> rr.registrationNumber)
      case Some(user) => user
    }
  }
}
