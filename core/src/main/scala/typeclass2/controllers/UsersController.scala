package typeclass2.controllers

import model.RegisterRequest
import scala.concurrent.Future
import typeclass2.model.{ AccountData, UserData }
import typeclass2.repositories.{ AccountRepository, UserRepository }
import typeclass2.services.{ AccountService, UserService }

class UsersController(
    implicit
    userRepository: UserRepository,
    accountRepository: AccountRepository
) {
  def registation(request: RegisterRequest): Future[UserData] = {
    UserService.register(request)
  }

  def registationAccount(request: RegisterRequest): Future[AccountData] = {
    AccountService.register(request)
  }
}
