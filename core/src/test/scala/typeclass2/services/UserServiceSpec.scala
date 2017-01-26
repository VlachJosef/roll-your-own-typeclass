package typeclass2.services

import model.RegisterRequest
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import play.api.libs.json.Json
import scala.concurrent.Future
import typeclass2.model.UserData
import typeclass2.tc.FindOne

object FindOneTC {
  def apply(userData: Option[UserData])(assert: String => Assertion) = new FindOne[UserData] {
    def apply(selector: String): Future[Option[UserData]] = {
      assert(selector)
      Future.successful(userData)
    }
  }
}

class UserServiceSpec extends FlatSpec with Matchers with ScalaFutures {

  "UserService" should "return existing registration" in {
    val userData = UserData(Json.obj("abc" -> "789"))
    implicit val findOneUserData = FindOneTC(Some(userData)) { selector =>
      selector should be("123")
    }

    val res = UserService.register(RegisterRequest("123"))

    res.futureValue.value should be(Json.obj("abc" -> "789"))
  }

  it should "return new registration" in {
    implicit val findOneUserData = FindOneTC(None) { selector =>
      selector should be("123456")
    }

    val res = UserService.register(RegisterRequest("123456"))

    res.futureValue.value should be(Json.obj("id" -> "123456"))
  }
}
