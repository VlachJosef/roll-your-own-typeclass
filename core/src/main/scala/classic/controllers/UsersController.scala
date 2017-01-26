package classic.controllers

import model.RegisterRequest
import classic.repositories.UserRepository
import classic.services.UserService
import play.api.libs.json.JsObject
import scala.concurrent.Future

class UsersController(userService: UserService) {
  def registation(request: RegisterRequest): Future[JsObject] = {
    userService.register(request)
  }
}
