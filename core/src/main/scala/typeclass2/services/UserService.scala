package typeclass2.services

import model.RegisterRequest
import play.api.libs.json.Json
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import typeclass2.tc.FindOne
import typeclass2.model.UserData

object UserService {
  def register(
    rr: RegisterRequest
  )(
    implicit
    FindOneUserData: FindOne[UserData]
  ): Future[UserData] = {
    FindOneUserData(rr.registrationNumber).map {
      case None => UserData(Json.obj("id" -> rr.registrationNumber))
      case Some(user) => user
    }
  }
}
