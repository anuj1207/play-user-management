package controllers

import akka.util.ByteString
import play.api.http.HttpEntity
import play.api.mvc._

/**
  * Created by knoldus on 1/3/17.
  */
class IntroductionController {

  def simpleResult: Action[AnyContent] = {
    Action{ implicit request =>
      val text = request.body.asText
      val json = request.body.asJson
      val xml = request.body.asXml
      val frmEncdUrl = request.body.asFormUrlEncoded
      Result(
        header = ResponseHeader(200, Map.empty),
        body = HttpEntity.Strict(ByteString("Simple Http Response for the request"+"::asTEXT: "+text+
          "::asJSON: "+json+"::asXML: "+xml+"::asFormUrlEncoded: "+frmEncdUrl),Some("plain/text"))
      ).withCookies(Cookie("Butterfly","pink"))
    }
  }

}
