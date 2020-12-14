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
-- Table structure for table `borrowinfor`
--

DROP TABLE IF EXISTS `borrowinfor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrowinfor` (
  `id` varchar(7) NOT NULL,
  `ObjectName` varchar(45) NOT NULL,
  `PhoneNumber` varchar(11) NOT NULL,
  `Object` varchar(15) NOT NULL,
  `Book` int NOT NULL,
  `BorrowDate` varchar(15) NOT NULL,
  `ReturnDate` varchar(15) NOT NULL,
  `idBs` varchar(70) NOT NULL,
  `UserName` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_borrowinfor_membercard_idx` (`UserName`),
  CONSTRAINT `fk_borrowInfor_membercard` FOREIGN KEY (`UserName`) REFERENCES `membercard` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrowinfor`
--

LOCK TABLES `borrowinfor` WRITE;
/*!40000 ALTER TABLE `borrowinfor` DISABLE KEYS */;
INSERT INTO `borrowinfor` VALUES ('0bf85','tan','0123654789','Sinh Viên',1,'15/12/2020','14/12/2020','456','tan.th'),('0d8e3','Tan','0123654789','Sinh Viên',1,'23/12/2020','24/12/2020','123','tan.th'),('c71bf','Tan','0123654789','Sinh Viên',1,'29/12/2020','14/12/2020','123','tan.th'),('f8f42','tan','0123654789','Sinh Viên',1,'29/12/2020','14/12/2020','123','tan.th');
/*!40000 ALTER TABLE `borrowinfor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-14 21:59:47
