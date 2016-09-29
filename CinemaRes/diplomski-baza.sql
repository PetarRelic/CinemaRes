SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `cinemares` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `cinemares` ;

-- -----------------------------------------------------
-- Table `cinemares`.`bioskop`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cinemares`.`bioskop` (
  `idBioskop` INT(11) NOT NULL AUTO_INCREMENT ,
  `naziv` VARCHAR(45) NOT NULL ,
  `adresa` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idBioskop`) ,
  UNIQUE INDEX `idBioskop_UNIQUE` (`idBioskop` ASC) ,
  UNIQUE INDEX `naziv_UNIQUE` (`naziv` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemares`.`film`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cinemares`.`film` (
  `idFilm` INT(11) NOT NULL AUTO_INCREMENT ,
  `naziv` VARCHAR(45) NOT NULL ,
  `zanr` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idFilm`) ,
  UNIQUE INDEX `idFilm_UNIQUE` (`idFilm` ASC) ,
  UNIQUE INDEX `naziv_UNIQUE` (`naziv` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemares`.`korisnik`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cinemares`.`korisnik` (
  `idKorisnik` INT(11) NOT NULL AUTO_INCREMENT ,
  `korisnicko_ime` VARCHAR(45) NOT NULL ,
  `lozinka` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idKorisnik`) ,
  UNIQUE INDEX `idKorisnik_UNIQUE` (`idKorisnik` ASC) ,
  UNIQUE INDEX `korisnicko_ime_UNIQUE` (`korisnicko_ime` ASC) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemares`.`sala`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cinemares`.`sala` (
  `idSala` INT(11) NOT NULL AUTO_INCREMENT ,
  `br_sedista` INT(11) NOT NULL ,
  `br_sale` INT(11) NOT NULL ,
  `fk_Bioskop` INT(11) NOT NULL ,
  PRIMARY KEY (`idSala`) ,
  UNIQUE INDEX `idSala_UNIQUE` (`idSala` ASC) ,
  INDEX `fk_sala_bioskop1_idx` (`fk_Bioskop` ASC) ,
  CONSTRAINT `fk_sala_bioskop1`
    FOREIGN KEY (`fk_Bioskop` )
    REFERENCES `cinemares`.`bioskop` (`idBioskop` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemares`.`projekcija`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cinemares`.`projekcija` (
  `idProjekcija` INT(11) NOT NULL AUTO_INCREMENT ,
  `termin_projekcije` DATETIME NOT NULL ,
  `fk_Film` INT(11) NOT NULL ,
  `fk_Sala` INT(11) NOT NULL ,
  PRIMARY KEY (`idProjekcija`) ,
  UNIQUE INDEX `idProjekcija_UNIQUE` (`idProjekcija` ASC) ,
  INDEX `fk_projekcija_film1_idx` (`fk_Film` ASC) ,
  INDEX `fk_projekcija_sala1_idx` (`fk_Sala` ASC) ,
  CONSTRAINT `fk_projekcija_film1`
    FOREIGN KEY (`fk_Film` )
    REFERENCES `cinemares`.`film` (`idFilm` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_projekcija_sala1`
    FOREIGN KEY (`fk_Sala` )
    REFERENCES `cinemares`.`sala` (`idSala` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinemares`.`karta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cinemares`.`karta` (
  `idKarta` INT(11) NOT NULL AUTO_INCREMENT ,
  `cena` VARCHAR(45) NOT NULL ,
  `fk_Korisnik` INT(11) NOT NULL ,
  `fk_Projekcija` INT(11) NOT NULL ,
  PRIMARY KEY (`idKarta`) ,
  UNIQUE INDEX `idkarta_UNIQUE` (`idKarta` ASC) ,
  INDEX `fk_karta_korisnik1_idx` (`fk_Korisnik` ASC) ,
  INDEX `fk_karta_projekcija1_idx` (`fk_Projekcija` ASC) ,
  CONSTRAINT `fk_karta_korisnik1`
    FOREIGN KEY (`fk_Korisnik` )
    REFERENCES `cinemares`.`korisnik` (`idKorisnik` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_karta_projekcija1`
    FOREIGN KEY (`fk_Projekcija` )
    REFERENCES `cinemares`.`projekcija` (`idProjekcija` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `cinemares` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
