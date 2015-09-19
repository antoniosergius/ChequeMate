SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `chequemate` DEFAULT CHARACTER SET latin1 ;
USE `chequemate` ;

-- -----------------------------------------------------
-- Table `chequemate`.`cliente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chequemate`.`cliente` (
  `idCliente` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(75) NOT NULL ,
  `logradouro` VARCHAR(50) NULL DEFAULT NULL ,
  `bairro` VARCHAR(20) NULL DEFAULT NULL ,
  `cidade` VARCHAR(20) NULL DEFAULT 'Divinópolis' ,
  `estado` CHAR(2) NULL DEFAULT 'MG' ,
  `cep` CHAR(8) NULL DEFAULT NULL ,
  `telResidencial` VARCHAR(25) NULL DEFAULT NULL ,
  `telComercial` VARCHAR(25) NULL DEFAULT NULL ,
  `telCelular` VARCHAR(25) NULL DEFAULT NULL ,
  `cadastro` VARCHAR(14) NULL DEFAULT NULL ,
  `observacao` VARCHAR(300) NULL DEFAULT NULL ,
  `email` VARCHAR(40) NULL DEFAULT NULL ,
  `dataNascimento` DATE NULL DEFAULT NULL ,
  `taxa` DECIMAL(10,2) UNSIGNED NULL DEFAULT '5.00' ,
  PRIMARY KEY (`idCliente`) )
ENGINE = InnoDB
AUTO_INCREMENT = 237
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `chequemate`.`cheque`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chequemate`.`cheque` (
  `idCheque` BIGINT(19) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `fkCliente` INT(10) UNSIGNED NOT NULL ,
  `numero` INT(6) NOT NULL ,
  `banco` INT(3) NULL DEFAULT NULL ,
  `agencia` INT(4) NULL DEFAULT NULL ,
  `valor` DECIMAL(15,2) NOT NULL ,
  `valorLiquido` DECIMAL(15,2) NULL DEFAULT NULL ,
  `dataEntrada` DATETIME NOT NULL ,
  `dataBoa` DATE NOT NULL ,
  `dataCalculo` DATE NULL DEFAULT NULL ,
  `emitente` VARCHAR(75) NOT NULL ,
  `cadastro` VARCHAR(14) NULL DEFAULT NULL ,
  `taxa` DECIMAL(10,2) UNSIGNED NOT NULL DEFAULT '5.00' ,
  `obs` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idCheque`) ,
  INDEX `valorIndex` (`valor` ASC) ,
  INDEX `fk_cheque_cliente1_idx` (`fkCliente` ASC) ,
  INDEX `emitenteIndex` (`emitente` ASC) ,
  CONSTRAINT `fk_cheque_cliente1`
    FOREIGN KEY (`fkCliente` )
    REFERENCES `chequemate`.`cliente` (`idCliente` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 20104
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `chequemate`.`emitente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chequemate`.`emitente` (
  `idEmitente` BIGINT(19) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(75) NOT NULL ,
  `cadastro` VARCHAR(14) NOT NULL ,
  `dataPrimeiro` DATE NULL DEFAULT NULL ,
  `dataUltimo` DATE NULL DEFAULT NULL ,
  `maiorValor` DECIMAL(10,0) NOT NULL DEFAULT '0' ,
  `numCheques` INT(11) NOT NULL DEFAULT '1' ,
  PRIMARY KEY (`idEmitente`) )
ENGINE = InnoDB
AUTO_INCREMENT = 5435
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `chequemate`.`feriado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chequemate`.`feriado` (
  `idFeriado` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `dia` TINYINT(3) UNSIGNED NOT NULL ,
  `mes` TINYINT(3) UNSIGNED NOT NULL ,
  `ano` SMALLINT(5) UNSIGNED NULL DEFAULT NULL ,
  `descricao` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idFeriado`) )
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `chequemate`.`parametros`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chequemate`.`parametros` (
  `idParametros` INT(1) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `deletaAutomatico` TINYINT(1) NOT NULL DEFAULT '1' ,
  `diasParaDeletar` INT(10) UNSIGNED NOT NULL DEFAULT '10' ,
  `minimoDiasDesconto` INT(10) UNSIGNED NOT NULL DEFAULT '15' ,
  PRIMARY KEY (`idParametros`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;

USE `chequemate` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
