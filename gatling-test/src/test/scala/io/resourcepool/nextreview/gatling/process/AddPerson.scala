package io.resourcepool.nextreview.gatling.process

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object AddPerson {
  
  val config = ConfigFactory.load

  val personCounter = new java.util.concurrent.atomic.AtomicInteger(config.getInt("application.db.initialUserCount")) // DB user count
  val feederAdd = csv("data/persons.csv").random
  val minWait = config.getInt("application.waitTime.addPerson.min")
  val maxWait = config.getInt("application.waitTime.addPerson.max")
  val add = exec {
    http("AddPerson: Browse add person page")
      .get("/add_person.html").check(status.is(200))
  }.exitHereIfFailed
    .pause(minWait, maxWait)
    .feed(feederAdd)
    .exec {
      http("AddPerson: Post new Person")
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
