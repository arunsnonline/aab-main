-- MySQL dump 10.13  Distrib 5.1.45, for Win64 (unknown)
--
-- Host: localhost    Database: adsboards
-- ------------------------------------------------------
-- Server version	5.1.45-community

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
-- Table structure for table `tblAccount`
--

DROP TABLE IF EXISTS `tblAccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblAccount` (
  `accountId` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountName` varchar(255) NOT NULL,
  `address` varchar(150) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `websiteUrl` varchar(100) DEFAULT NULL,
  `contactPerson` varchar(150) DEFAULT NULL,
  `contactPersonMobile` varchar(20) DEFAULT NULL,
  `organizationId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`accountId`),
  KEY `fk_account_organization` (`organizationId`),
  CONSTRAINT `fk_account_organization` FOREIGN KEY (`organizationId`) REFERENCES `tblorganization` (`organizationId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblAccount`
--

LOCK TABLES `tblAccount` WRITE;
/*!40000 ALTER TABLE `tblAccount` DISABLE KEYS */;
INSERT INTO `tblAccount` VALUES (1,'asdflk','kljsdf','kjsad@kljd.com','98797809','32023984593','www.ds.com','asdfsadf','78787878',6),(2,'Boards','niodfndsiof','jhkjdshg@abc.com','5546456','1321323','abc.com','Jose','98709870987',11);
/*!40000 ALTER TABLE `tblAccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblAdboard`
--

DROP TABLE IF EXISTS `tblAdboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblAdboard` (
  `adboardId` bigint(20) NOT NULL AUTO_INCREMENT,
  `contractDays` int(11) DEFAULT NULL,
  `contractStartDate` datetime DEFAULT NULL,
  `locLat` float DEFAULT NULL,
  `locLong` float DEFAULT NULL,
  `detailedLocation` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `accountId` bigint(20) DEFAULT NULL,
  `cityId` bigint(20) NOT NULL,
  `boardTypeId` bigint(20) NOT NULL,
  `uom` varchar(10) DEFAULT NULL,
  `length` int(11) DEFAULT '0',
  `breadth` int(11) DEFAULT '0',
  PRIMARY KEY (`adboardId`),
  KEY `fk_adboard_account` (`accountId`),
  KEY `fk_adboard_city` (`cityId`),
  KEY `fk_adboard_boardtype` (`boardTypeId`),
  CONSTRAINT `fk_adboard_account` FOREIGN KEY (`accountId`) REFERENCES `tblaccount` (`accountId`),
  CONSTRAINT `fk_adboard_boardtype` FOREIGN KEY (`boardTypeId`) REFERENCES `tblboardtype` (`boardTypeId`),
  CONSTRAINT `fk_adboard_city` FOREIGN KEY (`cityId`) REFERENCES `tblcity` (`cityId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblAdboard`
--

LOCK TABLES `tblAdboard` WRITE;
/*!40000 ALTER TABLE `tblAdboard` DISABLE KEYS */;
INSERT INTO `tblAdboard` VALUES (1,60,'2013-02-06 00:00:00',0,0,'Near Forum Mall','80 Ft Road',2,1,1,'FT',30,40);
/*!40000 ALTER TABLE `tblAdboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblAdboardEnquiryHistory`
--

DROP TABLE IF EXISTS `tblAdboardEnquiryHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblAdboardEnquiryHistory` (
  `adboardEnqHistoryId` bigint(20) NOT NULL AUTO_INCREMENT,
  `adboardId` bigint(20) NOT NULL,
  PRIMARY KEY (`adboardEnqHistoryId`),
  KEY `fk_adenq_adboard` (`adboardId`),
  CONSTRAINT `fk_adenq_adboard` FOREIGN KEY (`adboardId`) REFERENCES `tbladboard` (`adboardId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblAdboardEnquiryHistory`
--

LOCK TABLES `tblAdboardEnquiryHistory` WRITE;
/*!40000 ALTER TABLE `tblAdboardEnquiryHistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblAdboardEnquiryHistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblAppUser`
--

DROP TABLE IF EXISTS `tblAppUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblAppUser` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountEnabled` bit(1) NOT NULL,
  `accountExpired` bit(1) NOT NULL,
  `accountLocked` bit(1) NOT NULL,
  `address` varchar(150) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `credentialsExpired` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `passwordHint` varchar(255) DEFAULT NULL,
  `postalCode` varchar(15) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `version` int(11) NOT NULL,
  `website` varchar(255) DEFAULT NULL,
  `accountId` bigint(20) DEFAULT NULL,
  `organizationId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `fk_appuser_organization` (`organizationId`),
  KEY `fk_appuser_account` (`accountId`),
  CONSTRAINT `fk_appuser_account` FOREIGN KEY (`accountId`) REFERENCES `tblaccount` (`accountId`),
  CONSTRAINT `fk_appuser_organization` FOREIGN KEY (`organizationId`) REFERENCES `tblorganization` (`organizationId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblAppUser`
--

LOCK TABLES `tblAppUser` WRITE;
/*!40000 ALTER TABLE `tblAppUser` DISABLE KEYS */;
INSERT INTO `tblAppUser` VALUES (1,'\0','\0','\0',NULL,NULL,NULL,'\0',NULL,NULL,NULL,'21232f297a57a5a743894a0e4a801fc3',NULL,NULL,NULL,'admin',1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tblAppUser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblBoardType`
--

DROP TABLE IF EXISTS `tblBoardType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblBoardType` (
  `boardTypeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`boardTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblBoardType`
--

LOCK TABLES `tblBoardType` WRITE;
/*!40000 ALTER TABLE `tblBoardType` DISABLE KEYS */;
INSERT INTO `tblBoardType` VALUES (1,'Pole Kiosk');
/*!40000 ALTER TABLE `tblBoardType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblCity`
--

DROP TABLE IF EXISTS `tblCity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblCity` (
  `cityId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cityName` varchar(255) DEFAULT NULL,
  `stateId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cityId`),
  KEY `fk_city_state` (`stateId`),
  CONSTRAINT `fk_city_state` FOREIGN KEY (`stateId`) REFERENCES `tblstate` (`stateId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblCity`
--

LOCK TABLES `tblCity` WRITE;
/*!40000 ALTER TABLE `tblCity` DISABLE KEYS */;
INSERT INTO `tblCity` VALUES (1,'Bangalore',1);
/*!40000 ALTER TABLE `tblCity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblCountry`
--

DROP TABLE IF EXISTS `tblCountry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblCountry` (
  `countryId` bigint(20) NOT NULL AUTO_INCREMENT,
  `countryCode` varchar(255) DEFAULT NULL,
  `countryName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`countryId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblCountry`
--

LOCK TABLES `tblCountry` WRITE;
/*!40000 ALTER TABLE `tblCountry` DISABLE KEYS */;
INSERT INTO `tblCountry` VALUES (1,NULL,'INDIA'),(2,NULL,'AUSTRALIA');
/*!40000 ALTER TABLE `tblCountry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblOrganization`
--

DROP TABLE IF EXISTS `tblOrganization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblOrganization` (
  `organizationId` bigint(20) NOT NULL AUTO_INCREMENT,
  `organizationName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`organizationId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblOrganization`
--

LOCK TABLES `tblOrganization` WRITE;
/*!40000 ALTER TABLE `tblOrganization` DISABLE KEYS */;
INSERT INTO `tblOrganization` VALUES (1,'some organzz'),(2,'Rainbow boy'),(3,'Fun Com'),(4,'black'),(5,'orange'),(6,'green'),(7,'bring'),(8,'left'),(9,'boom'),(10,'flank'),(11,'jboards'),(12,'jboards');
/*!40000 ALTER TABLE `tblOrganization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblRole`
--

DROP TABLE IF EXISTS `tblRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblRole` (
  `roleId` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(64) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `permissions` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblRole`
--

LOCK TABLES `tblRole` WRITE;
/*!40000 ALTER TABLE `tblRole` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblRole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblState`
--

DROP TABLE IF EXISTS `tblState`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblState` (
  `stateId` bigint(20) NOT NULL AUTO_INCREMENT,
  `stateName` varchar(255) DEFAULT NULL,
  `countryId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`stateId`),
  KEY `fk_state_country` (`countryId`),
  CONSTRAINT `fk_state_country` FOREIGN KEY (`countryId`) REFERENCES `tblcountry` (`countryId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblState`
--

LOCK TABLES `tblState` WRITE;
/*!40000 ALTER TABLE `tblState` DISABLE KEYS */;
INSERT INTO `tblState` VALUES (1,'Karnataka',1);
/*!40000 ALTER TABLE `tblState` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblUserRole`
--

DROP TABLE IF EXISTS `tblUserRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblUserRole` (
  `userId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  KEY `fk_userrole_role` (`roleId`),
  KEY `fk_userrole_user` (`userId`),
  CONSTRAINT `fk_userrole_role` FOREIGN KEY (`roleId`) REFERENCES `tblrole` (`roleId`),
  CONSTRAINT `fk_userrole_user` FOREIGN KEY (`userId`) REFERENCES `tblappuser` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblUserRole`
--

LOCK TABLES `tblUserRole` WRITE;
/*!40000 ALTER TABLE `tblUserRole` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblUserRole` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-03-23  0:38:34
