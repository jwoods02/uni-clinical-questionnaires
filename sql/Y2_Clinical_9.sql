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
  `questionnaire_description` TEXT NOT NULL,
  `date_created` DATETIME NOT NULL,
  `admin_id` INT(11) NOT NULL,
  PRIMARY KEY (`questionnaire_id`),
  INDEX `AdminID_idx` (`admin_id` ASC),
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
  `questionnaire_id` INT(11) NOT NULL,
  PRIMARY KEY (`question_id`),
  INDEX `fk_question_questionnaire1_idx` (`questionnaire_id` ASC),
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
  `option_description` TEXT NULL DEFAULT NULL,
  `option_type` INT(11) NOT NULL,
  `option_order` INT(11) NULL,
  `question_id` INT(11) NOT NULL,
  PRIMARY KEY (`option_id`),
  INDEX `fk_options_question1_idx` (`question_id` ASC),
  CONSTRAINT `fk_options_question1`
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
