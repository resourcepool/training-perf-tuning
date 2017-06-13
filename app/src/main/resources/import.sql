INSERT INTO `team` (`id`,`name`) VALUES (1,'Resourcepool Web');
INSERT INTO `team` (`id`,`name`) VALUES (2,'Resourcepool Core');
INSERT INTO `team` (`id`,`name`) VALUES (3,'Resourcepool DevOps');
INSERT INTO `team` (`id`,`name`) VALUES (4,'Deadlock Web');
INSERT INTO `team` (`id`,`name`) VALUES (5,'Deadlock API');
INSERT INTO `team` (`id`,`name`) VALUES (6,'Deadlock QA');
INSERT INTO `team` (`id`,`name`) VALUES (7,'FireFighters');
INSERT INTO `team` (`id`,`name`) VALUES (8,'Interns');

INSERT INTO `review` (`id`,`description`,`name`,`scheduled_date_time`,`team_id`) VALUES (1,'Global Architecture, patterns, technical choices','Architecture Review', CURDATE() + INTERVAL 1 DAY + INTERVAL 11 HOUR,2);
INSERT INTO `review` (`id`,`description`,`name`,`scheduled_date_time`,`team_id`) VALUES (2,'42nd retrospective of the project','Sprint Retrospective', DATE_ADD(DATE_ADD(DATE_ADD(CURDATE(), INTERVAL 2 DAY), INTERVAL 16 HOUR), INTERVAL 30 MINUTE),2);
INSERT INTO `review` (`id`,`description`,`name`,`scheduled_date_time`,`team_id`) VALUES (3,'4th code review of the training-program','Connection Pool, Transactions', DATE_ADD(DATE_ADD(DATE_ADD(CURDATE(), INTERVAL 3 DAY), INTERVAL 9 HOUR), INTERVAL 30 MINUTE),8);
INSERT INTO `review` (`id`,`description`,`name`,`scheduled_date_time`,`team_id`) VALUES (4,'5th code review of the training-program','ThreadLocal', DATE_ADD(DATE_ADD(DATE_ADD(CURDATE(), INTERVAL 5 DAY), INTERVAL 10 HOUR), INTERVAL 30 MINUTE),8);