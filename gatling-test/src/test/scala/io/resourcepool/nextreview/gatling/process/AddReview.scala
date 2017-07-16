package io.resourcepool.nextreview.gatling.process

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.forkjoin.ThreadLocalRandom

object AddReview {
  val config = ConfigFactory.load

  val feederAdd = csv("data/reviews.csv").random

  val minWait = config.getInt("application.waitTime.addReview.min")
  val maxWait = config.getInt("application.waitTime.addReview.max")
  
  val add = exec {
    http("AddReview: Browse add review page")
      .get("/add_review.html").check(status.is(200))
  }.exitHereIfFailed
    .pause(minWait, maxWait)
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
