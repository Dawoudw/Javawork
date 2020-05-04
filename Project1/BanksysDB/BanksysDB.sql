-- --------------------------------------------------------
-- Host:                         banksysdb.c7w4umijvqtz.us-east-2.rds.amazonaws.com
-- Server version:               10.3.20-MariaDB-log - Source distribution
-- Server OS:                    Linux
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for banksysdb
DROP DATABASE IF EXISTS `banksysdb`;
CREATE DATABASE IF NOT EXISTS `banksysdb` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci */;
USE `banksysdb`;

-- Dumping structure for procedure banksysdb.spAddUser
DROP PROCEDURE IF EXISTS `spAddUser`;
DELIMITER //
CREATE DEFINER="admin"@"%" PROCEDURE "spAddUser"(fname VARCHAR , lname  VARCHAR , dob DATE , phone VARCHAR , email VARCHAR, isadmin BIT  )
AS
 BEGIN
 INSERT INTO tbl_user VALUES (0,fname , lname , dob ,phone ,email, isadmin);
 END//
DELIMITER ;

-- Dumping structure for procedure banksysdb.sp_GetUserIDbyEmail
DROP PROCEDURE IF EXISTS `sp_GetUserIDbyEmail`;
DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `sp_GetUserIDbyEmail`(OUT id  INT , email VARCHAR (100))
BEGIN
 SELECT ID INTO id FROM tbl_user WHERE Email=email ;
 END//
DELIMITER ;

-- Dumping structure for procedure banksysdb.sp_UserInsert
DROP PROCEDURE IF EXISTS `sp_UserInsert`;
DELIMITER //
CREATE DEFINER=`admin`@`%` PROCEDURE `sp_UserInsert`(fname VARCHAR(50) , lname  VARCHAR(50)  , dob DATE , phone VARCHAR (20),email VARCHAR(100), isadmin BIT  )
BEGIN
 INSERT INTO tbl_user (ID ,Fname ,Lname ,DOB ,Phone ,Email ,IsAdmin ) VALUES (0,fname , lname , dob ,phone , email, isadmin ); 
END//
DELIMITER ;

-- Dumping structure for table banksysdb.tbl_accountTransaction
DROP TABLE IF EXISTS `tbl_accountTransaction`;
CREATE TABLE IF NOT EXISTS `tbl_accountTransaction` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `accountId` int(11) DEFAULT NULL,
  `transTypeId` int(11) DEFAULT NULL,
  `transAmount` float DEFAULT 0,
  `amountBefore` float DEFAULT 0,
  `transDate` datetime DEFAULT curdate(),
  `comment` varchar(200) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_tbl_accountTransaction_tbl_userAccount` (`accountId`),
  CONSTRAINT `FK_tbl_accountTransaction_tbl_userAccount` FOREIGN KEY (`accountId`) REFERENCES `tbl_userAccount` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Dumping data for table banksysdb.tbl_accountTransaction: ~11 rows (approximately)
/*!40000 ALTER TABLE `tbl_accountTransaction` DISABLE KEYS */;
INSERT INTO `tbl_accountTransaction` (`ID`, `accountId`, `transTypeId`, `transAmount`, `amountBefore`, `transDate`, `comment`) VALUES
	(9, 10, 1, 230, 23, '2020-04-09 00:00:00', NULL),
	(10, 9, 1, 100, 1, '2020-04-09 00:00:00', NULL),
	(11, 9, 2, 51, 101, '2020-04-09 00:00:00', NULL),
	(12, 12, 1, 88, 32, '2020-04-09 00:00:00', NULL),
	(13, 11, 2, 50, 200, '2020-04-09 00:00:00', NULL),
	(14, 14, 2, 20, 23, '2020-04-09 00:00:00', NULL),
	(15, 15, 1, 30, 20, '2020-04-09 00:00:00', NULL),
	(16, 15, 1, 5000, 50, '2020-04-09 00:00:00', NULL),
	(17, 6, 1, 10000, 32, '2020-04-09 00:00:00', NULL),
	(18, 19, 2, 10, 10, '2020-04-09 00:00:00', NULL),
	(19, 19, 1, 20, 0, '2020-04-21 02:38:01', NULL);
/*!40000 ALTER TABLE `tbl_accountTransaction` ENABLE KEYS */;

-- Dumping structure for table banksysdb.tbl_accountType
DROP TABLE IF EXISTS `tbl_accountType`;
CREATE TABLE IF NOT EXISTS `tbl_accountType` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(100) COLLATE latin1_general_ci DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Dumping data for table banksysdb.tbl_accountType: ~2 rows (approximately)
/*!40000 ALTER TABLE `tbl_accountType` DISABLE KEYS */;
INSERT INTO `tbl_accountType` (`ID`, `typeName`) VALUES
	(1, 'Checking'),
	(2, 'Saving');
/*!40000 ALTER TABLE `tbl_accountType` ENABLE KEYS */;

-- Dumping structure for table banksysdb.tbl_department
DROP TABLE IF EXISTS `tbl_department`;
CREATE TABLE IF NOT EXISTS `tbl_department` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `location` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Dumping data for table banksysdb.tbl_department: ~5 rows (approximately)
/*!40000 ALTER TABLE `tbl_department` DISABLE KEYS */;
INSERT INTO `tbl_department` (`ID`, `name`, `location`) VALUES
	(1, 'Sales', 'HQ'),
	(2, 'IT', 'NY'),
	(3, 'Finance', 'HQ'),
	(4, 'HR', 'HQ'),
	(5, 'Training', 'NY');
/*!40000 ALTER TABLE `tbl_department` ENABLE KEYS */;

-- Dumping structure for table banksysdb.tbl_departmentEmployee
DROP TABLE IF EXISTS `tbl_departmentEmployee`;
CREATE TABLE IF NOT EXISTS `tbl_departmentEmployee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT 0,
  `depId` int(11) DEFAULT 0,
  `isManger` bit(1) DEFAULT b'0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Dumping data for table banksysdb.tbl_departmentEmployee: ~17 rows (approximately)
/*!40000 ALTER TABLE `tbl_departmentEmployee` DISABLE KEYS */;
INSERT INTO `tbl_departmentEmployee` (`ID`, `userId`, `depId`, `isManger`) VALUES
	(1, 1, 2, b'1'),
	(2, 2, 1, b'1'),
	(3, 3, 2, b'0'),
	(4, 4, 3, b'1'),
	(5, 5, 3, b'0'),
	(6, 6, 1, b'0'),
	(7, 7, 4, b'1'),
	(8, 8, 4, b'0'),
	(9, 9, 5, b'1'),
	(10, 10, 5, b'0'),
	(11, 11, 2, b'0'),
	(12, 12, 2, b'0'),
	(13, 13, 1, b'0'),
	(14, 14, 3, b'0'),
	(15, 15, 5, b'0'),
	(16, 16, 5, b'0'),
	(17, 17, 1, b'0');
/*!40000 ALTER TABLE `tbl_departmentEmployee` ENABLE KEYS */;

-- Dumping structure for table banksysdb.tbl_reimbursement
DROP TABLE IF EXISTS `tbl_reimbursement`;
CREATE TABLE IF NOT EXISTS `tbl_reimbursement` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `submitEmp` int(11) DEFAULT NULL,
  `approveEmp` int(11) DEFAULT NULL,
  `amount` float DEFAULT 0,
  `status` tinyint(4) DEFAULT 0 COMMENT '1=submitted\\r\\n2=apprvoed\\r\\n3=rejected',
  `postDate` datetime DEFAULT '0000-00-00 00:00:00',
  `reason` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `comment` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Dumping data for table banksysdb.tbl_reimbursement: ~2 rows (approximately)
/*!40000 ALTER TABLE `tbl_reimbursement` DISABLE KEYS */;
INSERT INTO `tbl_reimbursement` (`ID`, `submitEmp`, `approveEmp`, `amount`, `status`, `postDate`, `reason`, `comment`) VALUES
	(1, 2, 1, 300, 3, '2020-04-21 04:35:49', 'Test', 'Test'),
	(2, 2, 1, 100, 2, '2020-04-21 04:37:25', 'Test', 'Test');
/*!40000 ALTER TABLE `tbl_reimbursement` ENABLE KEYS */;

-- Dumping structure for table banksysdb.tbl_transactionType
DROP TABLE IF EXISTS `tbl_transactionType`;
CREATE TABLE IF NOT EXISTS `tbl_transactionType` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `transName` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `effect` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Dumping data for table banksysdb.tbl_transactionType: ~2 rows (approximately)
/*!40000 ALTER TABLE `tbl_transactionType` DISABLE KEYS */;
INSERT INTO `tbl_transactionType` (`ID`, `transName`, `effect`) VALUES
	(1, 'Deposit', b'1'),
	(2, 'Withdraw', b'0');
/*!40000 ALTER TABLE `tbl_transactionType` ENABLE KEYS */;

-- Dumping structure for table banksysdb.tbl_user
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE IF NOT EXISTS `tbl_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `fName` varchar(50) COLLATE latin1_general_ci DEFAULT '',
  `lName` varchar(50) COLLATE latin1_general_ci DEFAULT '',
  `dob` date DEFAULT NULL,
  `email` varchar(100) COLLATE latin1_general_ci DEFAULT '',
  `phone` varchar(20) COLLATE latin1_general_ci DEFAULT '',
  `isAdmin` bit(1) DEFAULT b'0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Dumping data for table banksysdb.tbl_user: ~16 rows (approximately)
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` (`ID`, `fName`, `lName`, `dob`, `email`, `phone`, `isAdmin`) VALUES
	(1, 'Wael', 'Dawoud', '1981-11-01', 'wsd_3@hotmail.com', '22222222', b'1'),
	(2, 'Adam', 'Joseph', '1988-12-01', 'adam@hotmail.com', '33333331', b'0'),
	(3, 'Avi', 'Ravi', '1994-12-02', 'av@gmail.com', '33333332', b'0'),
	(5, 'Jason', 'Brad', '1979-12-03', 'jb@hotmail.com', '33333333', b'0'),
	(6, 'Amr', 'Ali', '1997-12-04', 'amr@mrd.com', '33333334', b'0'),
	(7, 'Mohamed', 'Khan', '1998-12-05', 'mk@mrd.com', '33333335', b'0'),
	(8, 'Jessy', 'William', '2001-07-12', 'ere@mrd.com', '33333336', b'0'),
	(9, 'Marry', 'Joseph', '1992-09-13', 'w@mrd.com', '33333337', b'0'),
	(10, 'Eva', 'Mark', '1990-11-14', 'rr@mrd.com', '33333338', b'0'),
	(11, 'Saly', 'Tom', '1996-06-15', 'h@mrd.com', '33333339', b'0'),
	(12, 'Ahmed', 'Amhed', '2002-11-23', 'wsd@ddd.com', '33333310', b'0'),
	(13, 'Sara', 'Jerry', '1994-03-16', 'user@email.com', '33333311', b'0'),
	(14, 'Nouh', 'Salem', '1995-05-17', '@mrd.com', '33333312', b'0'),
	(15, 'Omar', 'Kamel', '1999-12-18', 'ww@ss.com', '33333313', b'0'),
	(16, 'David', 'Solman', '1993-10-19', 'omark@gg.com', '33333314', b'0'),
	(17, 'Sandy', 'Frank', '1989-03-01', 'sf@gg.com', '37777553', b'0');
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;

-- Dumping structure for table banksysdb.tbl_userAccount
DROP TABLE IF EXISTS `tbl_userAccount`;
CREATE TABLE IF NOT EXISTS `tbl_userAccount` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `accountNum` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `accountTypeId` int(11) NOT NULL,
  `createDate` date DEFAULT curdate(),
  `currentBalance` float DEFAULT 0,
  `isActive` bit(1) DEFAULT b'1',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Dumping data for table banksysdb.tbl_userAccount: ~20 rows (approximately)
/*!40000 ALTER TABLE `tbl_userAccount` DISABLE KEYS */;
INSERT INTO `tbl_userAccount` (`ID`, `userId`, `accountNum`, `accountTypeId`, `createDate`, `currentBalance`, `isActive`) VALUES
	(1, 1, '10005', 1, '2020-04-08', 400, b'1'),
	(2, 1, '10006', 2, '2020-04-08', 200, b'1'),
	(3, 2, '10007', 2, '2020-04-08', 1000, b'1'),
	(4, 2, '1001', 1, '2020-04-08', 0, b'1'),
	(5, 3, '1002', 1, '2020-04-08', 0, b'1'),
	(6, 16, '1003', 2, '2020-04-08', 10032, b'1'),
	(7, 4, '861', 1, '2020-04-08', 22222, b'1'),
	(8, 4, '971', 1, '2020-04-08', 300, b'1'),
	(9, 5, '378', 1, '2020-04-09', 50, b'1'),
	(10, 17, '730', 2, '2020-04-09', 253, b'1'),
	(11, 6, '359', 1, '2020-04-09', 150, b'1'),
	(12, 7, '637', 1, '2020-04-09', 120, b'1'),
	(13, 8, '246', 2, '2020-04-09', 100, b'0'),
	(14, 9, '262', 1, '2020-04-09', 3, b'1'),
	(15, 10, '2700', 2, '2020-04-09', 5050, b'1'),
	(16, 11, '2688', 1, '2020-04-09', 20, b'0'),
	(17, 12, '3068', 1, '2020-04-09', 30, b'0'),
	(18, 13, '4160', 1, '2020-04-09', 0, b'0'),
	(19, 14, '352', 2, '2020-04-09', 20, b'1'),
	(20, 15, '160', 1, '2020-04-09', 0, b'0');
/*!40000 ALTER TABLE `tbl_userAccount` ENABLE KEYS */;

-- Dumping structure for table banksysdb.tbl_userCredential
DROP TABLE IF EXISTS `tbl_userCredential`;
CREATE TABLE IF NOT EXISTS `tbl_userCredential` (
  `userID` int(11) DEFAULT NULL,
  `loginName` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `password` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `lastLogin` date DEFAULT curdate(),
  `isActive` bit(1) DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Dumping data for table banksysdb.tbl_userCredential: ~17 rows (approximately)
/*!40000 ALTER TABLE `tbl_userCredential` DISABLE KEYS */;
INSERT INTO `tbl_userCredential` (`userID`, `loginName`, `password`, `lastLogin`, `isActive`) VALUES
	(1, 'admin', '123', '2020-04-07', b'1'),
	(2, 'user1', '123', '2020-01-15', b'1'),
	(3, 'user2', '123', '2020-04-08', b'1'),
	(4, 'user3', '123', '2020-04-08', b'1'),
	(5, 'user4', '123', '2020-04-08', b'1'),
	(6, 'user5', '123', '2020-04-08', b'1'),
	(7, 'user6', '123', '2020-04-08', b'1'),
	(8, 'user7', '123', '2020-04-08', b'1'),
	(9, 'user8', '123', '2020-04-08', b'1'),
	(10, 'user9', '123', '2020-04-08', b'1'),
	(11, 'user10', '123', '2020-04-08', b'1'),
	(12, 'user11', '123', '2020-04-09', b'1'),
	(13, 'user12', '123', '2020-04-09', b'1'),
	(14, 'user13', '123', '2020-04-09', b'1'),
	(15, 'user14', '123', '2020-04-09', b'1'),
	(16, 'user15', '123', '2020-04-09', b'1'),
	(17, 'user16', '123', '2020-04-09', b'1');
/*!40000 ALTER TABLE `tbl_userCredential` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
