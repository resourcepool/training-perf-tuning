Webapp stress-test with Gatling
=========================

##Table of contents

1. [Content](#content)
2. [Installation](#installation)
3. [Configuration](#configuration)
4. [Utilisation](#utilisation)
5. [Scenario Protocol](#scenario-protocol)
6. [Key Performance Indicators](#key-performance-indicators)
7. [Fixing Errors](#fixing-errors)
8. [Suggested Improvements](#suggested-improvements)
9. [Table of results](#table-of-results)

#Content

This stress-test with Gatling will simulate the activity of N users in the next-review app. It will allow you to evaluate the load profile of your application.

The simulation uses two scenarios:

 * The first scenario is a "View-Only" scenario. It behaves as if someone was just looking at the next-review dashboard. 90% of the users will execute this scenario.
 * The second scenario is a "Administrate" scenario. The user browses the admin panel, adds a person, one team, and one review. 10% of the users will execute this scenario.

#Installation
You can copy the content of this folder in your existing maven project, or use it as a single project.

#Configuration

The folder src/test/resources/data contains some csv feeders which are used in the test.
* The file persons.csv contains 100k values used to feed the creation of persons.
* The file teams.csv contains 100k values used to feed the creation of teams.
* The file reviews.csv contains 100k values used to feed the creation of reviews.

#Usage

Type the command **mvn gatling:execute** to launch the test. You can view the results of the test in your browser, or in the folder target/gatling/results/.
We highly encourage users to perform injection from **another machine**.

#Protocol

##Testing Protocol

Your app can sustain X users **if and only if** it passes the following testing protocol:

A java application needs some warmup so that the JVM can optimize the application (thanks to the Just-In-Time Compiler). 
In our case, we will consider the tests are relevant after **2 warmup runs with 500 users, with no DB reset**.

Even after those warmups runs, you can experience some differences between the tests.  
We will consider **2 statistic runs, each preceded with a DB reset** will be enough.  
The run with the worst performance will be used for the Key Performance Indicators.

##Key Performance Indicators
The scenario can be considered as performing and successful if all the following conditions are met:
* No request has failed.
* At least 95% of the requests response time (95th percentile) are under 800ms.
* At least 99% of the requests response time (99th percentile) are under 1200ms.

##Iteration Protocol

If the Testing protocol succeeds with X users, you can increase the number of users to a superior number Y by changing the nbUsers configuration in application.conf.

Run again the Testing protocol with the new Y value, until you reach the limits of your application.  
Congratulations, you have reached your bottleneck.