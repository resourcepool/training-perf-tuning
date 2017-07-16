package io.resourcepool.nextreview.gatling.process

import java.util.concurrent.atomic.AtomicInteger

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.forkjoin.ThreadLocalRandom

object AddReview {
  val config = ConfigFactory.load

  val feederAdd = csv("data/reviews.csv").random

  val add = doIf(_ => ThreadLocalRandom.current.nextInt(10) < 1) {
    exec {
      http("Add: Add Review Page")
        .get("/add_review.html").check(status.is(200))
    }.exitHereIfFailed
      .pause(5, 15)
      .feed(feederAdd)
      .exec {
        http("Add: Post new Review")
          .post("/add_review.html")
          .formParam("name", "${name}")
          .formParam("description", "${description}")
          .formParam("scheduledDate", "${scheduledDate}")
          .formParam("scheduledTime", "${scheduledTime}")
          .formParam("teamId", session => {
            // Max members per team: 9
            val teamCount = session("teamCount").as[Int]
            1 + ThreadLocalRandom.current.nextInt(teamCount)
          })
      }.pause(1, 5)
  }

}
