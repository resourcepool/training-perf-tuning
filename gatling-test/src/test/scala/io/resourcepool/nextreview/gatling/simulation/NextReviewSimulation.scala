package io.resourcepool.nextreview.gatling.simulation

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.resourcepool.nextreview.gatling.process._

import scala.concurrent.duration._

/**
  * Launch the simulation for NextReview webapp
  */
class NextReviewSimulation extends Simulation {
  
  before {
    println("Your app is going public... Wow! So many users!")
  }

  val config = ConfigFactory.load

  val httpConf = http
    .baseURL(config.getString("application.baseUrl")) // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val browseDashboardScenario = scenario("Browse").exec(BrowseDashboard.browse)

  val browseAddPersonTeamAndReviewScenario = scenario("BrowseAddPersonAndTeam").exec(BrowseAdminPanel.browse, AddPerson.add, AddTeam.add, AddReview.add)

  setUp(
    // 90 % of browse
    browseDashboardScenario.inject(rampUsers(config.getInt("application.nbUsers") * 9 / 10) over (config.getInt("application.rampTime") seconds)),
    // 10 % of admin who add stuff
    browseAddPersonTeamAndReviewScenario.inject(rampUsers(config.getInt("application.nbUsers") / 10) over (config.getInt("application.rampTime") seconds))
  ).protocols(httpConf)
    .assertions(
      global.failedRequests.count.is(0),
      global.responseTime.percentile3.lte(800), //check that 95% of the response time is under 800ms
      global.responseTime.percentile4.lte(1200) // check that 99% of the response time is under 1200ms
    )
  after {
    println("The simulation is finished, check the html file for more informations about the results.")
  }
}
