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

-- -----------------------------------------------------
-- Schema y2_clinical_9
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `y2_clinical_9` DEFAULT CHARACTER SET utf8 ;
USE `y2_clinical_9` ;

-- -----------------------------------------------------
-- Table `y2_clinical_9`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `y2_clinical_9`.`admin` (
  `admin_id` INT(11) NOT NULL auto_increment,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`admin_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `y2_clinical_9`.`options`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `y2_clinical_9`.`options` (
  `option_id` INT(11) NOT NULL auto_increment,
  `option_description` TEXT NULL DEFAULT NULL,
  `option_type` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`option_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `y2_clinical_9`.`questionnaire`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `y2_clinical_9`.`questionnaire` (
  `questionnaire_id` INT(11) NOT NULL auto_increment,
  `questionnaire_title` TEXT NULL DEFAULT NULL,
  `questionnaire_description` TEXT NULL DEFAULT NULL,
  `date_created` DATETIME NULL DEFAULT NULL,
  `admin_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`questionnaire_id`),
  INDEX `AdminID_idx` (`admin_id` ASC),
  CONSTRAINT `AdminID`
    FOREIGN KEY (`admin_id`)
    REFERENCES `y2_clinical_9`.`admin` (`admin_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `y2_clinical_9`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `y2_clinical_9`.`question` (
  `question_id` INT(11) NOT NULL auto_increment,
  `question_description` TEXT NULL DEFAULT NULL,
  `questionnaire_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  INDEX `QuestionnaireID_idx` (`questionnaire_id` ASC),
  CONSTRAINT `QuestionnaireID`
    FOREIGN KEY (`questionnaire_id`)
    REFERENCES `y2_clinical_9`.`questionnaire` (`questionnaire_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `y2_clinical_9`.`question_option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `y2_clinical_9`.`question_option` (
  `question_option_id` INT(11) NOT NULL auto_increment,
  `question_id` INT(11) NULL DEFAULT NULL,
  `option_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`question_option_id`),
  INDEX `QuestionID_idx` (`question_id` ASC),
  INDEX `OptionID_idx` (`option_id` ASC),
  CONSTRAINT `OptionID`
    FOREIGN KEY (`option_id`)
    REFERENCES `y2_clinical_9`.`options` (`option_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `QuestionID`
    FOREIGN KEY (`question_id`)
    REFERENCES `y2_clinical_9`.`question` (`question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
