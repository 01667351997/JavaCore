CREATE DATABASE  IF NOT EXISTS `csdl-ai` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `csdl-ai`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: csdl-ai
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `fdatamain`
--

DROP TABLE IF EXISTS `fdatamain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fdatamain` (
  `iddatamain` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `idtruong` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `idhocphi` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `idhocbong` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `idnganh` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `idkhoi` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `diemchuan` float NOT NULL,
  PRIMARY KEY (`iddatamain`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fdatamain`
--

LOCK TABLES `fdatamain` WRITE;
/*!40000 ALTER TABLE `fdatamain` DISABLE KEYS */;
INSERT INTO `fdatamain` VALUES ('A01','C1','R4B','R5C','R1A','R2A',28.25),('A02','C1','R4B','R5C','R1B','R2C',23),('A03','C1','R4B','R5C','R1C','R2A',26.25),('A04','C1','R4B','R5C','R1D','R2A',27.25),('A05','C1','R4B','R5C','R1E','R2A',25.75),('A06','C1','R4B','R5C','R1F','R2A',27),('A07','C1','R4B','R5C','R1G','R2B',24.5),('A08','C2','R4B','R5B','R1A','R2A',23.25),('A09','C2','R4B','R5B','R1B','R2C',21),('A10','C2','R4B','R5B','R1D','R2A',22),('A11','C2','R4B','R5B','R1E','R2A',16),('A12','C2','R4B','R5B','R1G','R2B',16),('A13','C3','R4A','R5B','R1A','R2A',23),('A14','C3','R4A','R5B','R1B','R2A',19.5),('A15','C3','R4A','R5B','R1C','R2A',21.25),('A16','C3','R4A','R5B','R1D','R2A',23),('A17','C3','R4A','R5B','R1E','R2A',18.75),('A18','C3','R4A','R5B','R1F','R2A',19.5),('A19','C3','R4A','R5B','R1G','R2B',17.75),('A20','C4','R4C','R5A','R1A','R2A',23),('A21','C4','R4C','R5A','R1B','R2C',18.25),('A22','C4','R4C','R5A','R1C','R2A',22.25),('A23','C4','R4C','R5A','R1D','R2A',24),('A24','C4','R4C','R5A','R1E','R2A',22.25),('A25','C4','R4C','R5A','R1F','R2A',24),('A26','C4','R4C','R5A','R1G','R2B',22),('A27','C5','R4D','R5A','R1A','R2A',20),('A28','C5','R4D','R5A','R1B','R2C',18),('A29','C5','R4D','R5A','R1C','R2A',17.5),('A30','C5','R4D','R5A','R1D','R2A',17),('A31','C5','R4D','R5A','R1E','R2A',16),('A32','C5','R4D','R5A','R1F','R2A',17),('A33','C5','R4D','R5A','R1G','R2B',16),('A34','C6','R4C','R5A','R1A','R2A',19.25),('A35','C6','R4C','R5A','R1B','R2C',17.5),('A36','C6','R4C','R5A','R1C','R2A',18.75),('A37','C6','R4C','R5A','R1D','R2A',18.75),('A38','C6','R4C','R5A','R1E','R2A',18),('A39','C6','R4C','R5A','R1F','R2A',17),('A40','C7','R4A','R5A','R1A','R2A',16.5),('A41','C7','R4A','R5A','R1B','R2C',16),('A42','C7','R4A','R5A','R1C','R2A',17.99),('A43','C7','R4A','R5A','R1D','R2A',18),('A44','C7','R4A','R5A','R1E','R2A',15.5),('A45','C7','R4A','R5A','R1F','R2A',18),('A46','C7','R4A','R5A','R1G','R2B',15.5);
/*!40000 ALTER TABLE `fdatamain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocbong`
--

DROP TABLE IF EXISTS `hocbong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hocbong` (
  `idhocbong` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `muc` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idhocbong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocbong`
--

LOCK TABLES `hocbong` WRITE;
/*!40000 ALTER TABLE `hocbong` DISABLE KEYS */;
INSERT INTO `hocbong` VALUES ('R5A','dễ'),('R5B','trung bình'),('R5C','khó');
/*!40000 ALTER TABLE `hocbong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocphi`
--

DROP TABLE IF EXISTS `hocphi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hocphi` (
  `idhocphi` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `muc` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idhocphi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocphi`
--

LOCK TABLES `hocphi` WRITE;
/*!40000 ALTER TABLE `hocphi` DISABLE KEYS */;
INSERT INTO `hocphi` VALUES ('R4A','10 triệu-  13 triệu'),('R4B','13 triệu - 15 triệu'),('R4C','15 triệu - 17 triệu'),('R4D','17 triệu - 20 triệu');
/*!40000 ALTER TABLE `hocphi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoithi`
--

DROP TABLE IF EXISTS `khoithi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `khoithi` (
  `idkhoithi` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tenkhoi` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idkhoithi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoithi`
--

LOCK TABLES `khoithi` WRITE;
/*!40000 ALTER TABLE `khoithi` DISABLE KEYS */;
INSERT INTO `khoithi` VALUES ('R2A','A'),('R2B','A1'),('R2C','D');
/*!40000 ALTER TABLE `khoithi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nganhhoc`
--

DROP TABLE IF EXISTS `nganhhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nganhhoc` (
  `idNganhhoc` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `tennganh` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idNganhhoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nganhhoc`
--

LOCK TABLES `nganhhoc` WRITE;
/*!40000 ALTER TABLE `nganhhoc` DISABLE KEYS */;
INSERT INTO `nganhhoc` VALUES ('R1A','CNTT'),('R1B','Quản trị kinh doanh'),('R1C','Kỹ thuật điện tử'),('R1D','Tự đông hoá'),('R1E','Cơ khí'),('R1F','Cơ điện tử'),('R1G','Ngoại ngữ');
/*!40000 ALTER TABLE `nganhhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `truongdh`
--

DROP TABLE IF EXISTS `truongdh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `truongdh` (
  `idTruongDH` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `TenTruong` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idTruongDH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `truongdh`
--

LOCK TABLES `truongdh` WRITE;
/*!40000 ALTER TABLE `truongdh` DISABLE KEYS */;
INSERT INTO `truongdh` VALUES ('C1','Đại học Bách khoa Hà Nội'),('C2','Đại học Xây Dựng'),('C3','Đại học giao thông vận tải'),('C4','Đại học công nghiệp '),('C5','Đại học FPT'),('C6','Đại học kỹ thuật công nghiệp'),('C7','Đại học Mỏ');
/*!40000 ALTER TABLE `truongdh` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-02 17:28:09
