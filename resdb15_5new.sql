-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: resdb
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `billId` int NOT NULL AUTO_INCREMENT,
  `customerId` int NOT NULL,
  `empId` int NOT NULL,
  `serviceId` int NOT NULL,
  `eventId` int NOT NULL,
  `hallId` int NOT NULL,
  `datePay` date DEFAULT NULL,
  `bookDetailId` int DEFAULT NULL,
  PRIMARY KEY (`billId`),
  KEY `customerId_bill_idx` (`customerId`),
  KEY `empId_bill_idx` (`empId`),
  KEY `serviceId_bill_idx` (`serviceId`),
  KEY `eventId_bill_idx` (`eventId`),
  KEY `hallId_bill_idx` (`hallId`),
  CONSTRAINT `customerId_bill` FOREIGN KEY (`customerId`) REFERENCES `customers` (`customerId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `empId_bill` FOREIGN KEY (`empId`) REFERENCES `employees` (`empId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `eventId_bill` FOREIGN KEY (`eventId`) REFERENCES `events` (`eventId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hallId_bill` FOREIGN KEY (`hallId`) REFERENCES `halls` (`hallId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `serviceId_bill` FOREIGN KEY (`serviceId`) REFERENCES `services` (`serviceId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (60,17,1,18,2,4,'2021-05-19',25),(61,10,28,2,3,4,'2021-05-20',29),(62,10,29,1,1,1,'2021-05-27',30),(63,10,27,19,2,2,'2021-05-21',28);
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_detail`
--

DROP TABLE IF EXISTS `book_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customerId` int NOT NULL,
  `serviceId` int NOT NULL,
  `eventId` int NOT NULL,
  `hallId` int NOT NULL,
  `dateUse` date DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `numberGuest` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId_customers_idx` (`customerId`),
  KEY `serviceId_services_idx` (`serviceId`),
  KEY `eventId_events_idx` (`eventId`),
  KEY `hallId_halls_idx` (`hallId`),
  CONSTRAINT `customerId_customers_book` FOREIGN KEY (`customerId`) REFERENCES `customers` (`customerId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `eventId_events_book` FOREIGN KEY (`eventId`) REFERENCES `events` (`eventId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hallId_halls` FOREIGN KEY (`hallId`) REFERENCES `halls` (`hallId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `serviceId_services_book` FOREIGN KEY (`serviceId`) REFERENCES `services` (`serviceId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_detail`
--

LOCK TABLES `book_detail` WRITE;
/*!40000 ALTER TABLE `book_detail` DISABLE KEYS */;
INSERT INTO `book_detail` VALUES (1,7,1,1,1,'2021-04-30','Test lan 1',110),(12,9,1,1,1,'2021-04-30','Test thanh toan',20),(26,7,2,2,3,'2021-05-15','Test',12),(27,9,2,2,4,'2021-05-16','Test',12);
/*!40000 ALTER TABLE `book_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customerId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`customerId`),
  KEY `fk_customers_user1_idx` (`user_id`),
  CONSTRAINT `fk_customers_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (7,'Pan','12345678','USA',9),(9,'A','0356789998','TPHCM',12),(10,'Nguyen Van C','034589544','TPHCM',13),(14,'Amee','035667865','Phu Yen',16),(15,'Hoai','123456789','Tay Ninh',17),(16,'Hue','12345678','Tay Ninh',8),(17,'JHope','123456','Korean',18),(18,'RapMon','123456789','USA',19),(19,'Test','0349189198','USA',8);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `empId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mail` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birth` date NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`empId`),
  KEY `fk_employees_user1_idx` (`user_id`),
  CONSTRAINT `fk_employees_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Ngoc Hue','ngochue@gmail.com','Tay Ninh','1999-09-27',8),(5,'Helen','helen@gmail.com','USA','1999-01-02',8),(27,'Nguyen B','b@gmail.com','TPHCM','1996-06-15',8),(28,'Huynh Anh','huynhanh@gmail.com','TPHCM','1995-10-15',8),(29,'Tran Thi Thao','thao@gmail.com','Ha Noi','1988-05-09',8);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `events` (
  `eventId` int NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`eventId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,'Su Kien 1',1000),(2,'Su Kien 2',2000),(3,'Su kien 3',300);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `feedbackId` int NOT NULL AUTO_INCREMENT,
  `customerId` int NOT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`feedbackId`),
  KEY `customerId_idx` (`customerId`),
  CONSTRAINT `customerId_feed` FOREIGN KEY (`customerId`) REFERENCES `customers` (`customerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (24,10,'Nha hang phuc vu tot','2021-05-15'),(32,9,'hiiiiiiiiii','2021-05-15'),(33,14,'Nhan vien phuc vu nhiet tinh chu dao','2021-05-15'),(34,15,'Test','2021-05-15'),(35,16,'Tui vua la nhan vien vua la khach hang','2021-05-15');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `halls`
--

DROP TABLE IF EXISTS `halls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `halls` (
  `hallId` int NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `seat` int DEFAULT NULL,
  PRIMARY KEY (`hallId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `halls`
--

LOCK TABLES `halls` WRITE;
/*!40000 ALTER TABLE `halls` DISABLE KEYS */;
INSERT INTO `halls` VALUES (1,'Sanh 1',110),(2,'Sanh 2',120),(3,'Sanh 3',130),(4,'Sanh 4',140);
/*!40000 ALTER TABLE `halls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services` (
  `serviceId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `unit_price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`serviceId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'Dịch vụ 1',2000),(2,'Dịch vụ 2',3000),(18,'Dich Vu 3',3000),(19,'Dich vu 4',4000);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `role_user` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (8,'hue','$2a$10$isv4B5HVi5yzVv8YrDb/Nu7daXlX6nF9XA59cNk7lpwlacwiko/2.','ROLE_ADMIN'),(9,'hao','$2a$10$Wfgna8K2k/fmwRQooDiaAOF03ketXF.ZT7qaWnfKbIfDFsCb5E1nq','ROLE_USER'),(10,'helen','$2a$10$ZJibGgeellblN6DXDEDhH.RR9znc9UTYkENwC4LwHYMiKng83gMCC','ROLE_USER'),(12,'nnd','$2a$10$mjI2CVGFYFb2UkkssBiLa.l1H9HmNDMfP1YsyBMhre0Js09QvoMxC','ROLE_USER'),(13,'didi','$2a$10$aKNbShueeMJvE0ljIsV6N.zC3Axjv4MKOvpPQMoLKHp5mkGu7XefS','ROLE_USER'),(15,'diem123456','$2a$10$j2.k515buHqYwhi2VC.uWemzn0ehn5WWA5dU7LT8xQw3SDrv/ghDG','ROLE_USER'),(16,'amee','$2a$10$JjWdI2IVw4cuOZRshmQGIO6I.JpQjuBdU57YzaHOeDhHHWd1uY1Iy','ROLE_USER'),(17,'Lisa','$2a$10$G4dz92vJ3/j5g1pnbZPMV.Tsj/mrvUJJjvg3RGP/mIwiEQxCoW55G','ROLE_USER'),(18,'JHope','$2a$10$wbI8ttWs48j1cTPxgtFvGutuNk7XwAZ59Sy8b7fRSaEmSJSpx2k26','ROLE_USER'),(19,'RM','$2a$10$1REVmHm/HfT6fVvwtZV6G.1fWjwcuR8LbvPk1E323Ni6BIr8BNwXa','ROLE_USER'),(20,'Jin','$2a$10$2.ZeF.QJh0UjPzhUGqHYYe/dtBH1XoFdYqNDwesuZOlNI8139TJIS','ROLE_USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-15 10:18:24
