package io.resourcepool.nextreview.gatling.process

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object BrowseDashboard {
  
  val config = ConfigFactory.load

  val random = new util.Random
  
  val feederResultCount = Iterator.continually(Map("count" -> (random.nextInt(27) + 3)))
  
  val browse = feed(feederResultCount)
      .exec {
        http("Browse: Browse dashboard")
          .get("/dashboard")
          .queryParam("count", "${count}")
          .resources(
            http("CSS bootstrap")
            .get("/css/bootstrap.min.css"),
            http("CSS style")
              .get("/css/style.css"),
            http("CSS font awesome")
              .get("/css/font-awesome.min.css"),
            http("JS bootstrap")
              .get("/js/bootstrap.min.js"),
            http("JS jquery")
              .get("/js/jquery-3.1.1.min.js"),
            http("JS script")
              .get("/js/script.js"),
            http("Img Logo")
              .get("/img/logo.png"),
            http("Font")
              .get("/fonts/fontawesome-webfont.woff2?v=4.7.0"),
            http("Favicon")
              .get("/favicon.ico")
          )
          .check(status.is(200))
          
      }
    .pause(5)
}
