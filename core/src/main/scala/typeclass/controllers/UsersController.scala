package typeclass.controllers

import model.RegisterRequest
import play.api.libs.json.JsObject
import scala.concurrent.Future
import typeclass.repositories.{ AccountRepository, UserRepository }
import typeclass.services.UserService
import scala.concurrent.ExecutionContext.Implicits.global

class UsersController(implicit userRepository: UserRepository) {
  def registation(request: RegisterRequest): Future[JsObject] = {
    UserService.register(request)
  }
}
