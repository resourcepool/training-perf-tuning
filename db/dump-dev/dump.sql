-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: nextreview
-- ------------------------------------------------------
-- Server version	5.7.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'loic@jawg.io','LoÃ¯c','Ortola'),(2,'bendover@resourcepool.io','Ben','Dover'),(3,'dixienormous@resourcepool.io','Dixie','Normous'),(4,'justinsider@resourcepool.io','Justin','Sider'),(5,'mikelitoris@resourcepool.io','Mike','Litoris'),(6,'adamsapple@resourcepool.io','Adam','Sapple'),(7,'albebak@resourcepool.io','All','Beback'),(8,'alextricity@resourcepool.io','Alex','Tricity'),(9,'alibye@resourcepool.io','Ali','Bye'),(10,'colinseek@resourcepool.io','Colin','Seek'),(11,'emmaroids@resourcepool.io','Emma','Roids'),(12,'eveolution@resourcepool.io','Eve','Olution'),(13,'flotinaway@resourcepool.io','Flo','Tinaway'),(14,'felixcited@resourcepool.io','Felix','Cited'),(15,'fredalivery@resourcepool.io','Freda','Livery'),(16,'frankanstine@resourcepool.io','Frank','Anstine'),(17,'harissonfire@resourcepool.io','Harisson','Fire'),(18,'leenover@resourcepool.io','Lee','Nover'),(19,'lisaneucar@resourcepool.io','Lisa','Neucar'),(20,'lizannia@resourcepool.io','Liz','Annia'),(21,'lounateek@resourcepool.io','Lou','Nateek'),(22,'loupole@resourcepool.io','Lou','Pole');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_team`
--

DROP TABLE IF EXISTS `person_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_team` (
  `team_id` bigint(20) NOT NULL,
  `person_id` bigint(20) NOT NULL,
  KEY `FK4n0ts32m2ffsjoyp98isswvdx` (`person_id`),
  KEY `FK5nm4b09lhr8moaj39v27icmn5` (`team_id`),
  CONSTRAINT `FK4n0ts32m2ffsjoyp98isswvdx` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  CONSTRAINT `FK5nm4b09lhr8moaj39v27icmn5` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_team`
--

LOCK TABLES `person_team` WRITE;
/*!40000 ALTER TABLE `person_team` DISABLE KEYS */;
INSERT INTO `person_team` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(8,2),(8,3),(8,4),(8,5),(8,6),(8,7),(8,8),(8,9),(8,10),(8,11),(8,12),(1,13),(2,13),(1,14),(2,14),(4,15),(6,15),(4,16),(5,16),(6,16),(1,17),(3,17),(5,18),(6,18),(1,19),(4,19),(1,20),(4,20),(3,21),(6,21),(5,22),(6,22);
/*!40000 ALTER TABLE `person_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `scheduled_date_time` datetime DEFAULT NULL,
  `team_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4a245rd9e9a0gholo36rcau7a` (`team_id`),
  CONSTRAINT `FK4a245rd9e9a0gholo36rcau7a` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'An long time ago, in a galaxy far, far away.','Star Review','2017-07-14 13:00:00',2),(2,'42nd retrospective of the project','Sprint Retrospective','2017-07-18 16:30:00',2),(3,'4th code review of the training-program','Connection Pool, Transactions','2017-07-19 09:30:00',8),(4,'5th code review of the training-program','ThreadLocal','2017-07-21 10:30:00',8),(5,'Global Architecture, patterns, technical choices','Architecture Review','2017-07-17 11:00:00',2);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'Resourcepool Web'),(2,'Resourcepool Core'),(3,'Resourcepool DevOps'),(4,'Deadlock Web'),(5,'Deadlock API'),(6,'Deadlock QA'),(7,'FireFighters'),(8,'Interns');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-16 14:45:29
