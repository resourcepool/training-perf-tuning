package io.resourcepool.nextreview.gatling.process

import java.util.concurrent.atomic.AtomicInteger

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.forkjoin.ThreadLocalRandom

object AddTeam {

  val maxMembersPerTeam = 9
  
  val config = ConfigFactory.load
  
  val teamCounter = new java.util.concurrent.atomic.AtomicInteger(config.getInt("application.db.initialTeamCount")) // DB team count
  
  val feederAdd = csv("data/teams.csv").random
  val minWait = config.getInt("application.waitTime.addTeam.min")
  val maxWait = config.getInt("application.waitTime.addTeam.max")
  
  val add = exec {
    http("AddTeam: Browse add team page")
      .get("/add_team.html").check(status.is(200))
  }.exitHereIfFailed
    .pause(minWait, maxWait)
    .feed(feederAdd)
    .exec {
      http("AddTeam: Post new Team")
        .post("/add_team.html")
        .formParam("name", "${name}")
        .multivaluedFormParam("members", session => {
          val personCount = session("personCount").as[Int]
          // Max members per team: 9
          Seq.fill(ThreadLocalRandom.current.nextInt(maxMembersPerTeam))(1 + ThreadLocalRandom.current.nextInt(personCount)).distinct
        })
    }
    .exec {
      session => {
        session.set("teamCount", teamCounter.incrementAndGet)
      }
    }
}
