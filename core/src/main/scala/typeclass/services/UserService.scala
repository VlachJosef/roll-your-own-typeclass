package typeclass.services

import model.RegisterRequest
import play.api.libs.json.{ JsObject, Json }
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import typeclass.tc.FindOne

object UserService {
  def register(
    rr: RegisterRequest
  )(
    implicit
    FindOneRegistration: FindOne[JsObject]
  ): Future[JsObject] = {
    FindOneRegistration(rr.registrationNumber).map {
      case None => Json.obj("id" -> rr.registrationNumber)
      case Some(user) => user
    }
  }
}
