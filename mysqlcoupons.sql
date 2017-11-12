-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: coupon
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `compId` bigint(20) NOT NULL AUTO_INCREMENT,
  `compName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`compId`),
  UNIQUE KEY `ID_UNIQUE` (`compId`),
  UNIQUE KEY `compName_UNIQUE` (`compName`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'Michael Kors','123123','michaelkors@gmail.com'),(2,'Next','123456','next@gmail.com'),(3,'Maybelline','123456','maybelline@gmail.com'),(4,'Xtra','123456','xtra@gmail.com'),(5,'Guess','123456','guess@gmail.com');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_coupon`
--

DROP TABLE IF EXISTS `company_coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_coupon` (
  `compId` bigint(20) NOT NULL,
  `couponId` bigint(20) NOT NULL,
  PRIMARY KEY (`compId`,`couponId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_coupon`
--

LOCK TABLES `company_coupon` WRITE;
/*!40000 ALTER TABLE `company_coupon` DISABLE KEYS */;
INSERT INTO `company_coupon` VALUES (2,0),(2,1),(2,2),(2,3);
/*!40000 ALTER TABLE `company_coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon` (
  `couponId` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `type` varchar(256) DEFAULT NULL,
  `message` varchar(256) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`couponId`),
  UNIQUE KEY `ID_UNIQUE` (`couponId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon`
--

LOCK TABLES `coupon` WRITE;
/*!40000 ALTER TABLE `coupon` DISABLE KEYS */;
INSERT INTO `coupon` VALUES (1,'EXTRA 15% Off Surprise Sale','2017-07-12','2018-03-04',9,'CLOTHING',NULL,10,NULL),(2,'EXTRA 35% Off Sale','2017-07-12','2018-03-04',10,'CLOTHING',NULL,10,NULL),(3,'50% Off Sale','2017-07-12','2018-03-04',10,'CLOTHING',NULL,10,NULL),(4,'60% Off Sale','2017-07-12','2018-03-04',10,'CLOTHING',NULL,90,NULL);
/*!40000 ALTER TABLE `coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `custId` bigint(20) NOT NULL AUTO_INCREMENT,
  `custName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`custId`),
  UNIQUE KEY `custId_UNIQUE` (`custId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Idan','123123'),(2,'Tal','123123'),(3,'Alon','123123');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_coupon`
--

DROP TABLE IF EXISTS `customer_coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_coupon` (
  `custId` bigint(20) NOT NULL,
  `couponId` bigint(20) NOT NULL,
  PRIMARY KEY (`custId`,`couponId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_coupon`
--

LOCK TABLES `customer_coupon` WRITE;
/*!40000 ALTER TABLE `customer_coupon` DISABLE KEYS */;
INSERT INTO `customer_coupon` VALUES (1,1),(1,2),(1,3);
/*!40000 ALTER TABLE `customer_coupon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-12 21:57:43
