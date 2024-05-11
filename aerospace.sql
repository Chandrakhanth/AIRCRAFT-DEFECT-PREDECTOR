-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.45-community - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for aerospace
CREATE DATABASE IF NOT EXISTS `aerospace` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `aerospace`;

-- Dumping structure for table aerospace.crash_test
CREATE TABLE IF NOT EXISTS `crash_test` (
  `Machine_Id` varchar(50) DEFAULT NULL,
  `Machine_Name` varchar(50) DEFAULT NULL,
  `ff` varchar(50) DEFAULT NULL,
  `cooling_tem` varchar(50) DEFAULT NULL,
  `Fault` varchar(200) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `Cause` varchar(200) DEFAULT NULL,
  `Solution` varchar(200) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL,
  `Action` varchar(50) DEFAULT NULL,
  `Pressure` varchar(50) DEFAULT NULL,
  `Flow_rate` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table aerospace.fuselage_assembly
CREATE TABLE IF NOT EXISTS `fuselage_assembly` (
  `Machine_id` varchar(50) DEFAULT NULL,
  `Machine_Name` varchar(50) DEFAULT NULL,
  `Fault` varchar(500) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL,
  `Action` varchar(50) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `Cause` varchar(500) DEFAULT NULL,
  `Solution` varchar(500) DEFAULT NULL,
  `BONDING_TYPE` varchar(500) DEFAULT NULL,
  `BONDING_PRESSURE` varchar(50) DEFAULT NULL,
  `C_T` varchar(50) DEFAULT NULL,
  `Noise_exposure` varchar(50) DEFAULT NULL,
  `Vibration_exposure` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table aerospace.landinggear_assembly
CREATE TABLE IF NOT EXISTS `landinggear_assembly` (
  `Machine_id` varchar(50) DEFAULT NULL,
  `Machine_name` varchar(50) DEFAULT NULL,
  `Fault` varchar(500) DEFAULT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `Temp` varchar(50) DEFAULT NULL,
  `RF` varchar(50) DEFAULT NULL,
  `Oil_Level` varchar(50) DEFAULT NULL,
  `Cause` varchar(500) DEFAULT NULL,
  `Action` varchar(500) DEFAULT NULL,
  `Solution` varchar(500) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL,
  `Pressure` varchar(50) DEFAULT NULL,
  `Flow_rate` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table aerospace.pro_cfm56
CREATE TABLE IF NOT EXISTS `pro_cfm56` (
  `mac_name` varchar(50) DEFAULT NULL,
  `mac_id` varchar(50) DEFAULT NULL,
  `mac_Ex` varchar(50) DEFAULT NULL,
  `Fault` varchar(200) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `oil_consumption` varchar(50) DEFAULT NULL,
  `vibration_blade` varchar(50) DEFAULT NULL,
  `pressure` varchar(50) DEFAULT NULL,
  `speed_blade` varchar(50) DEFAULT NULL,
  `temperature` varchar(50) DEFAULT NULL,
  `stress` varchar(50) DEFAULT NULL,
  `creep_rate` varchar(50) DEFAULT NULL,
  `others` varchar(50) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL,
  `action` varchar(200) DEFAULT NULL,
  `bv1` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table aerospace.pro_hydroforming
CREATE TABLE IF NOT EXISTS `pro_hydroforming` (
  `mac_id` varchar(50) DEFAULT NULL,
  `Mac_Name` varchar(50) DEFAULT NULL,
  `Oil_Level` varchar(50) DEFAULT NULL,
  `Oil_Temperature` varchar(50) DEFAULT NULL,
  `Pressure` varchar(50) DEFAULT NULL,
  `Hydraulic_Line` varchar(50) DEFAULT NULL,
  `Press_Frame` varchar(500) DEFAULT NULL,
  `Clean` varchar(50) DEFAULT NULL,
  `Action` varchar(50) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL,
  `hc_Flowrate` varchar(50) DEFAULT NULL,
  `hc_Force` varchar(50) DEFAULT NULL,
  `ex` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table aerospace.users
CREATE TABLE IF NOT EXISTS `users` (
  `name` varchar(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `cpassword` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table aerospace.windtunnels_test
CREATE TABLE IF NOT EXISTS `windtunnels_test` (
  `Machine_Id` varchar(50) DEFAULT NULL,
  `Machine_Name` varchar(50) DEFAULT NULL,
  `lc` varchar(50) DEFAULT NULL,
  `temperature` varchar(50) DEFAULT NULL,
  `Fault` varchar(50) DEFAULT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `Cause` varchar(500) DEFAULT NULL,
  `Action` varchar(50) DEFAULT NULL,
  `Solution` varchar(500) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL,
  `Wind_speed` varchar(500) DEFAULT NULL,
  `Air_temperature` varchar(500) DEFAULT NULL,
  `Altitude` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
