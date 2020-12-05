-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: librarydb
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `returninfor`
--

DROP TABLE IF EXISTS `returninfor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `returninfor` (
  `id` varchar(7) NOT NULL,
  `idMC` varchar(7) NOT NULL,
  `Object` varchar(5) NOT NULL,
  `ObjectName` varchar(45) NOT NULL,
  `Book` int NOT NULL,
  `BorrowDate` varchar(15) NOT NULL,
  `ReturnDate` varchar(15) NOT NULL,
  `StolenBook` int DEFAULT NULL,
  `TornBook` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_returninfor_membercard_idx` (`idMC`),
  CONSTRAINT `fk_returninfor_membercard` FOREIGN KEY (`idMC`) REFERENCES `membercard` (`idMemberCard`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `returninfor`
--

LOCK TABLES `returninfor` WRITE;
/*!40000 ALTER TABLE `returninfor` DISABLE KEYS */;
INSERT INTO `returninfor` VALUES ('10ff9','1','GV','tran tan thanh',2,'08/12/2020','03/12/2020',2,2),('123','1','GV','Thanh',1,'20/11/2020','11/6/2020',3,2),('123456','2','SV','Tan Thanh',2,'20/10/2020','22/11/2020',1,2),('456','2','SV','Trang',2,'29/11/2020','30/11/2020',4,2),('79ab2','1','SV','tan thanh',2,'15/12/2020','03/12/2020',2,2),('8b58c','1','GV','tran tan thanh',2,'08/12/2020','03/12/2020',2,2),('f7856','1','GV','Tuyet Vi',2,'18/12/2020','03/12/2020',2,2);
/*!40000 ALTER TABLE `returninfor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-04 22:31:34
