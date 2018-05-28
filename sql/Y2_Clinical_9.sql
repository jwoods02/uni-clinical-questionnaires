-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema y2_clinical_9
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `y2_clinical_9` ;

-- -----------------------------------------------------
-- Schema y2_clinical_9
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `y2_clinical_9` DEFAULT CHARACTER SET utf8 ;
USE `y2_clinical_9` ;

-- -----------------------------------------------------
-- Table `y2_clinical_9`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `y2_clinical_9`.`admin` (
  `admin_id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`admin_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `y2_clinical_9`.`questionnaire`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `y2_clinical_9`.`questionnaire` (
  `questionnaire_id` INT(11) NOT NULL AUTO_INCREMENT,
  `questionnaire_title` TEXT NOT NULL,
  `questionnaire_description` TEXT NULL,
  `date_created` DATETIME NULL,
  `admin_id` INT(11) NULL,
  PRIMARY KEY (`questionnaire_id`),
  CONSTRAINT `AdminID`
    FOREIGN KEY (`admin_id`)
    REFERENCES `y2_clinical_9`.`admin` (`admin_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `y2_clinical_9`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `y2_clinical_9`.`question` (
  `question_id` INT(11) NOT NULL AUTO_INCREMENT,
  `question_description` TEXT NOT NULL,
  `question_type` INT(11) NOT NULL,
  `questionnaire_id` INT(11) NULL,
  PRIMARY KEY (`question_id`),
  CONSTRAINT `fk_question_questionnaire1`
    FOREIGN KEY (`questionnaire_id`)
    REFERENCES `y2_clinical_9`.`questionnaire` (`questionnaire_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `y2_clinical_9`.`options`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `y2_clinical_9`.`options` (
  `option_id` INT(11) NOT NULL AUTO_INCREMENT,
  `option_description` TEXT NOT NULL,
  `option_order` INT(11) NOT NULL,
  `question_id` INT(11) NOT NULL,
  PRIMARY KEY (`option_id`),
    FOREIGN KEY (`question_id`)
    REFERENCES `y2_clinical_9`.`question` (`question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO y2_clinical_9.admin VALUES(1,'R', 'Chand','rchand','pass');
INSERT INTO y2_clinical_9.admin VALUES(2,'L', 'Vuilleumier','lv','pass');
INSERT INTO y2_clinical_9.admin VALUES(3,'James', 'Woods','j_woods','pass');
INSERT INTO y2_clinical_9.admin VALUES(4,'T', 'Sabir','tSabir','pass');
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (1, 'facilisi cras non velit nec', 'dapibus augue vel accumsan tellus', '2017-12-23 03:11:29', 1);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (2, 'duis bibendum', 'nibh ligula nec sem duis aliquam convallis nunc', '2015-01-22 16:50:51', 2);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (3, 'vitae nisl', 'semper interdum mauris ullamcorper purus sit amet nulla quisque arcu', '2015-07-08 19:32:01', 3);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (4, 'vulputate luctus cum sociis natoque penatibus et magnis dis parturient', 'pretium iaculis justo in hac', '2017-11-22 15:12:42', 2);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (5, 'consequat lectus in', 'in magna bibendum imperdiet nullam orci pede venenatis', '2015-01-23 13:23:00', 1);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (6, 'tincidunt eu felis fusce posuere felis sed lacus morbi sem', 'pede ullamcorper augue a suscipit nulla elit ac nulla', '2017-08-22 22:12:02', 3);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (7, 'scelerisque quam', 'sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis', '2015-01-22 05:04:14', 2);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (8, 'ac est lacinia nisi venenatis tristique fusce congue diam', 'id mauris vulputate elementum', '2016-09-09 23:58:02', 1);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (9, 'convallis tortor risus dapibus augue vel', 'augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa', '2016-07-27 16:50:33', 4);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (10, 'erat tortor sollicitudin mi sit amet lobortis sapien', 'integer aliquet massa id lobortis convallis tortor risus dapibus augue', '2015-05-25 09:19:58', 2);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (11, 'ligula sit amet eleifend pede libero', 'posuere felis sed lacus morbi sem mauris', '2016-12-19 00:40:41', 3);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (12, 'velit nec nisi vulputate', 'augue a suscipit nulla elit ac nulla sed', '2017-07-24 17:30:39', 3);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (13, 'lectus pellentesque at nulla suspendisse potenti cras in', 'ante ipsum primis in', '2016-05-19 23:46:33', 2);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (14, 'vulputate elementum nullam varius nulla facilisi', 'potenti in eleifend quam a odio', '2017-06-03 11:34:54', 2);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (15, 'eget semper rutrum nulla nunc purus', 'tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu', '2017-06-24 19:33:05', 2);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (16, 'consectetuer eget rutrum at lorem', 'a nibh in quis justo maecenas', '2015-10-21 20:56:07', 1);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (17, 'elementum nullam varius', 'faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec', '2017-10-10 21:54:00', 1);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (18, 'congue eget semper rutrum nulla nunc', 'vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere', '2016-01-24 05:25:04', 1);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (19, 'faucibus orci luctus et ultrices', 'donec dapibus duis at velit eu est congue elementum in', '2017-12-23 09:58:44', 4);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (20, 'cras in purus eu magna vulputate luctus cum', 'est congue elementum in hac habitasse platea dictumst morbi vestibulum', '2016-04-05 23:31:44', 2);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (21, 'mattis nibh ligula nec', 'dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum', '2015-09-01 08:22:01', 1);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (22, 'vulputate justo', 'ipsum praesent blandit lacinia erat vestibulum', '2016-07-14 06:11:47', 3);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (23, 'nibh', 'lectus suspendisse potenti in eleifend quam a odio in hac', '2016-07-01 11:18:54', 3);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (24, 'proin interdum', 'augue luctus tincidunt nulla mollis molestie lorem', '2015-09-10 09:27:51', 4);
insert into y2_clinical_9.questionnaire (questionnaire_id, questionnaire_title, questionnaire_description, date_created, admin_id) values (25, 'non interdum in ante vestibulum ante ipsum primis in faucibus', 'amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu', '2015-12-21 19:20:16', 3);

INSERT INTO y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) VALUES (1,'Enter your first name', 2, 1);
INSERT INTO y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) VALUES (2,'Enter your last name', 2, 1);
INSERT INTO y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) VALUES (3,'What is your gender?', 1, 1);
INSERT INTO y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) VALUES (4,'How can we contact you?', 4, 1);
INSERT INTO y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) VALUES (5,'Enter first name', 2, 2);
INSERT INTO y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) VALUES (6,'Enter surname', 2, 2);
INSERT INTO y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) VALUES (7,'What is the nature of your relationship?', 1, 2);
INSERT INTO y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) VALUES (8,'How can we contact your next of kin?', 4, 2);
INSERT INTO y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) VALUES (9,'Enter your annual income', 2, 3);
INSERT INTO y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) VALUES (10,'Do you have children?', 1, 3);
INSERT INTO y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) VALUES (11,'Please describe any other sources of income other than salary', 3, 3);
INSERT INTO y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) VALUES (12,'Enter your annual expenditures', 2, 3);
INSERT INTO y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) VALUES (13,'What are your living arrangements?', 1, 4);
INSERT INTO y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) VALUES (14,'How many people do you live with?', 2, 4);
INSERT INTO y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) VALUES (15,'Enter the address', 3, 4);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (16, 'lectus in quam fringilla', 3, 16);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (17, 'purus phasellus', 2, 24);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (18, 'lobortis', 1, 8);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (19, 'quis', 1, 16);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (20, 'eu est congue elementum in hac habitasse', 2, 23);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (21, 'lorem integer tincidunt ante vel ipsum praesent', 3, 18);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (22, 'nam tristique', 3, 22);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (23, 'porttitor lorem', 3, 7);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (24, 'quisque id justo sit', 2, 19);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (25, 'in porttitor pede justo eu massa', 1, 9);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (26, 'turpis elementum ligula vehicula', 2, 14);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (27, 'in ante vestibulum ante ipsum primis in faucibus orci', 2, 16);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (28, 'vivamus tortor duis mattis egestas metus aenean fermentum donec ut', 1, 16);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (29, 'orci mauris', 4, 6);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (30, 'nulla eget eros', 2, 3);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (31, 'fusce congue diam id', 3, 7);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (32, 'dui nec nisi', 4, 4);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (33, 'in blandit ultrices enim', 4, 12);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (34, 'vitae nisl', 1, 6);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (35, 'turpis eget elit sodales scelerisque mauris sit', 4, 19);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (36, 'nisi at nibh', 1, 13);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (37, 'ac diam cras pellentesque volutpat', 2, 20);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (38, 'dictumst', 4, 22);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (39, 'magna vestibulum aliquet', 3, 13);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (40, 'praesent blandit nam nulla integer pede justo', 1, 9);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (41, 'nulla ut erat id mauris vulputate elementum', 3, 3);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (42, 'sollicitudin ut suscipit a feugiat et eros vestibulum ac', 4, 24);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (43, 'vivamus vestibulum sagittis sapien cum sociis', 4, 14);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (44, 'a libero nam dui proin leo odio porttitor id', 4, 20);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (45, 'pede justo eu massa donec dapibus duis at velit', 2, 8);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (46, 'odio', 2, 2);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (47, 'non', 3, 14);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (48, 'dolor quis odio', 4, 23);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (49, 'morbi odio odio elementum eu', 4, 6);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (50, 'orci nullam molestie nibh in lectus', 2, 17);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (51, 'sit amet justo', 3, 20);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (52, 'quis justo maecenas rhoncus aliquam', 1, 2);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (53, 'imperdiet sapien urna pretium nisl ut volutpat sapien', 4, 22);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (54, 'ut suscipit a feugiat et eros vestibulum ac est', 3, 17);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (55, 'nulla', 1, 13);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (56, 'quam sapien varius ut', 2, 22);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (57, 'fusce congue diam id ornare imperdiet sapien urna', 4, 20);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (58, 'phasellus sit amet erat nulla tempus vivamus in felis', 3, 4);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (59, 'volutpat convallis morbi odio odio elementum eu interdum eu', 1, 1);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (60, 'mauris lacinia sapien quis libero nullam sit amet', 3, 10);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (61, 'et magnis', 3, 4);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (62, 'mi', 4, 22);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (63, 'eget orci vehicula condimentum curabitur in libero ut massa', 2, 21);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (64, 'non velit donec diam neque vestibulum eget vulputate', 3, 12);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (65, 'integer aliquet', 1, 17);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (66, 'eros elementum pellentesque quisque porta', 4, 21);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (67, 'id', 4, 1);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (68, 'nascetur ridiculus mus', 4, 12);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (69, 'ac nibh fusce lacus purus aliquet at feugiat non', 2, 13);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (70, 'id mauris vulputate elementum nullam varius nulla facilisi cras', 1, 12);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (71, 'cursus vestibulum proin eu mi nulla ac', 3, 7);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (72, 'potenti nullam porttitor lacus at turpis donec posuere metus', 3, 6);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (73, 'turpis sed ante vivamus', 1, 21);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (75, 'sapien varius ut', 2, 23);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (76, 'ultricies eu nibh quisque id justo sit amet', 4, 4);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (77, 'at vulputate', 4, 12);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (78, 'proin', 4, 6);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (79, 'vulputate nonummy maecenas tincidunt lacus at velit', 1, 4);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (80, 'eu est congue elementum', 1, 12);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (81, 'nulla nunc', 2, 9);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (82, 'mauris non ligula pellentesque ultrices', 2, 1);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (83, 'porttitor lacus at turpis donec posuere', 4, 4);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (84, 'vestibulum', 4, 10);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (85, 'feugiat non pretium quis lectus suspendisse potenti in eleifend', 2, 23);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (86, 'proin leo', 4, 22);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (87, 'augue vestibulum ante', 2, 3);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (88, 'volutpat convallis morbi odio odio elementum', 3, 12);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (89, 'cras non velit nec nisi vulputate nonummy maecenas tincidunt', 4, 12);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (90, 'non sodales sed', 2, 22);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (91, 'in blandit ultrices enim lorem', 4, 16);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (92, 'orci luctus', 1, 20);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (93, 'ultrices phasellus id sapien', 4, 9);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (94, 'felis ut at dolor quis odio', 4, 18);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (95, 'cubilia curae duis faucibus accumsan odio curabitur convallis duis', 3, 9);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (96, 'lectus in quam fringilla', 2, 18);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (97, 'lorem integer', 1, 23);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (98, 'rutrum at lorem integer tincidunt ante vel ipsum praesent blandit', 2, 3);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (99, 'vel nulla eget eros', 1, 10);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (100, 'donec ut mauris eget massa tempor convallis nulla', 2, 17);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (101, 'nulla elit', 2, 4);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (102, 'magnis dis parturient montes nascetur ridiculus mus etiam vel', 3, 4);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (103, 'quis', 1, 14);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (104, 'lacus morbi quis tortor id nulla ultrices aliquet', 4, 10);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (105, 'odio', 2, 5);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (106, 'pulvinar sed nisl nunc rhoncus', 2, 22);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (107, 'faucibus cursus urna ut tellus nulla ut erat id', 1, 15);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (108, 'sapien ut nunc vestibulum ante ipsum primis in faucibus', 2, 24);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (109, 'pede justo lacinia eget tincidunt eget tempus vel', 3, 3);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (110, 'quam pede lobortis ligula sit amet eleifend pede', 2, 7);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (111, 'cras pellentesque volutpat dui maecenas tristique', 1, 19);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (112, 'non ligula pellentesque ultrices phasellus', 3, 14);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (113, 'potenti nullam porttitor', 2, 15);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (114, 'amet cursus id turpis integer aliquet', 3, 18);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (115, 'nibh in lectus pellentesque at', 3, 21);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (116, 'in imperdiet', 4, 17);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (117, 'vulputate luctus cum sociis natoque penatibus et magnis dis', 2, 12);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (118, 'leo maecenas pulvinar', 2, 14);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (119, 'amet sem fusce consequat nulla nisl nunc nisl', 4, 19);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (120, 'ultrices posuere cubilia curae nulla dapibus dolor', 2, 9);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (121, 'vivamus in felis eu sapien cursus vestibulum proin eu mi', 3, 5);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (123, 'sit amet diam in magna bibendum imperdiet', 2, 10);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (124, 'suspendisse potenti in eleifend quam a odio in', 2, 5);
insert into y2_clinical_9.question (question_id, question_description, question_type, questionnaire_id) values (125, 'euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula', 2, 18);


INSERT INTO y2_clinical_9.options VALUES (1,'Male', 1, 3);
INSERT INTO y2_clinical_9.options VALUES (2,'Female', 2, 3);
INSERT INTO y2_clinical_9.options VALUES (3,'E-mail', 1, 4);
INSERT INTO y2_clinical_9.options VALUES (4,'Telephone', 2, 4);
INSERT INTO y2_clinical_9.options VALUES (5,'Post', 3, 4);
INSERT INTO y2_clinical_9.options VALUES (6,'Mother', 1, 7);
INSERT INTO y2_clinical_9.options VALUES (7,'Father', 2, 7);
INSERT INTO y2_clinical_9.options VALUES (8,'Spouse', 3, 7);
INSERT INTO y2_clinical_9.options VALUES (9,'Sibling', 4, 7);
INSERT INTO y2_clinical_9.options VALUES (10,'E-mail', 1, 8);
INSERT INTO y2_clinical_9.options VALUES (11,'Telephone', 2, 8);
INSERT INTO y2_clinical_9.options VALUES (12,'Post', 3, 8);
INSERT INTO y2_clinical_9.options VALUES (13,'Yes', 1, 10);
INSERT INTO y2_clinical_9.options VALUES (14,'No', 1, 10);
INSERT INTO y2_clinical_9.options VALUES (15,'Living with parents', 1, 13);
INSERT INTO y2_clinical_9.options VALUES (16,'Own a home', 2, 13);
INSERT INTO y2_clinical_9.options VALUES (17,'Renting', 3, 13);
INSERT INTO y2_clinical_9.options VALUES (18,'Living away from home (Student)', 4, 13);