package typeclass2.services

import model.RegisterRequest
import play.api.libs.json.Json
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import typeclass2.tc.FindOne
import typeclass2.model.AccountData

object AccountService {
  def register(
    rr: RegisterRequest
  )(
    implicit
    FindOneAccountData: FindOne[AccountData]
  ): Future[AccountData] = {
    FindOneAccountData(rr.registrationNumber).map {
      case None => AccountData(Json.obj("id" -> rr.registrationNumber))
      case Some(account) => account
    }
  }
}
