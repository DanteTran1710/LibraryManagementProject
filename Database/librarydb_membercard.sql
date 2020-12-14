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
-- Table structure for table `membercard`
--

DROP TABLE IF EXISTS `membercard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `membercard` (
  `UserName` varchar(20) NOT NULL,
  `PassWord` varchar(7) NOT NULL,
  `MemberName` varchar(45) NOT NULL,
  `DOB` varchar(15) NOT NULL,
  `Object` varchar(20) NOT NULL,
  `StateCard` varchar(10) NOT NULL,
  `Gmail` varchar(50) NOT NULL,
  `Sex` varchar(10) NOT NULL,
  `PhoneNumber` varchar(11) NOT NULL,
  `Major` varchar(50) NOT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membercard`
--

LOCK TABLES `membercard` WRITE;
/*!40000 ALTER TABLE `membercard` DISABLE KEYS */;
INSERT INTO `membercard` VALUES ('dhthanh','55hh2','Duong Huu Thanh','17/01/1985','Giảng Viên','Enable','dhthanh@ou.edu.vn','Nam','0124569873','Công Nghệ Thông Tin'),('duyen.h','90d5a','Duyen Ha','08/12/2000','Sinh Viên','Enable','duyen@ou.edu.vn','Nữ','0123546987','Đào Tạo Đặc Biệt'),('hthinh','34dde','Hong Thinh','08/09/2000','Admin','Enable','thinh@ou.edu.vn','Nam','0145236987','Công Nghệ Thông Tin'),('tan.th','886a3','Tan Thanh','15/12/200','Admin','Enable','tanth@ou.edu.vn','Nam','0123456789','Công Nghệ Thông Tin'),('tlam.tr','59afa','Truc Lam','02/12/2000','Sinh Viên','Disable','tlam@ou.edu.vn','Nữ','0213654789','Công Nghệ Thông Tin');
/*!40000 ALTER TABLE `membercard` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-14 22:16:00
