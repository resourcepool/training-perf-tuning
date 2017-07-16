CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `person_team` (
  `team_id` bigint(20) NOT NULL,
  `person_id` bigint(20) NOT NULL,
  KEY `FK4n0ts32m2ffsjoyp98isswvdx` (`person_id`),
  KEY `FK5nm4b09lhr8moaj39v27icmn5` (`team_id`),
  CONSTRAINT `FK4n0ts32m2ffsjoyp98isswvdx` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  CONSTRAINT `FK5nm4b09lhr8moaj39v27icmn5` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `review` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `scheduled_date_time` datetime DEFAULT NULL,
  `team_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4a245rd9e9a0gholo36rcau7a` (`team_id`),
  CONSTRAINT `FK4a245rd9e9a0gholo36rcau7a` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

