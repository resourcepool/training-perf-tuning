package io.resourcepool.nextreview.gatling.process

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object AddPerson {
  
  val config = ConfigFactory.load

  val personCounter = new java.util.concurrent.atomic.AtomicInteger(config.getInt("application.db.initialUserCount")) // DB user count
  val feederAdd = csv("data/persons.csv").random

  val add = exec {
    http("Add: Add Person Page")
      .get("/add_person.html").check(status.is(200))
  }.exitHereIfFailed
    .pause(5, 15)
    .feed(feederAdd)
    .exec {
      http("Add: Add post")
        .post("/add_person.html")
        .formParam("firstName", "${firstName}")
        .formParam("lastName", "${lastName}")
        .formParam("email", "${email}")
    }.exitHereIfFailed
    .exec {
      session => {
        session.set("personCount", personCounter.incrementAndGet)
      }
    }
}
