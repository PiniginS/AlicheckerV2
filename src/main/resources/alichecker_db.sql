-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: alichecker_db
-- ------------------------------------------------------
-- Server version	5.7.17-0ubuntu0.16.04.1

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
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) unsigned NOT NULL,
  `item_price` decimal(10,2) unsigned NOT NULL,
  `timestamp` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,32696401358,100.00,'2017-03-21 05:06:02'),(2,32696401358,100.00,'2017-03-21 05:06:32'),(3,32591851690,100.00,'2017-03-21 05:16:28'),(4,32696401358,100.00,'2017-03-21 05:16:33'),(5,32707305638,100.00,'2017-03-21 05:16:56'),(6,32591851690,100.00,'2017-03-21 06:02:06'),(7,32765347893,100.00,'2017-03-21 06:02:59'),(8,32765347893,100.00,'2017-03-21 06:05:53'),(9,32765347893,9090.30,'2017-03-21 06:13:45'),(10,32765347893,9090.30,'2017-03-21 06:14:24'),(11,32707305638,215.47,'2017-03-21 06:14:29'),(12,32591851690,134.60,'2017-03-21 06:14:37'),(13,32696401358,655.26,'2017-03-21 06:14:41'),(14,32696401358,655.26,'2017-03-21 06:24:29'),(15,32591851690,134.60,'2017-03-21 06:24:41'),(16,32591851690,134.60,'2017-03-21 06:25:29'),(17,32591851690,134.60,'2017-03-21 06:27:11'),(18,32591851690,134.60,'2017-03-21 06:28:06'),(19,32696401358,655.26,'2017-03-21 06:28:37'),(20,32765347893,9090.30,'2017-03-21 06:29:45'),(21,32591851690,134.60,'2017-03-21 06:30:06'),(22,32696401358,655.26,'2017-03-21 06:40:30'),(23,32696401358,655.26,'2017-03-21 06:52:59'),(24,32707305638,272.73,'2017-03-21 06:59:43'),(25,32707305638,220.78,'2017-03-21 07:00:13'),(26,32696401358,622.79,'2017-03-21 07:03:06'),(27,32696401358,622.79,'2017-03-21 07:04:06'),(28,32696401358,622.79,'2017-03-21 07:04:37'),(29,32707305638,220.78,'2017-03-21 10:09:22'),(30,32591851690,126.33,'2017-03-21 10:09:46'),(31,32776664614,74.98,'2017-03-21 10:21:52'),(32,1000003468110,6471.90,'2017-03-21 10:22:59');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) unsigned NOT NULL,
  `count` bigint(20) unsigned NOT NULL,
  `timestamp` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`,`shop_id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES (63,1760127,927,'2017-03-21 06:25:51'),(64,1760127,927,'2017-03-21 06:27:18'),(65,1760127,927,'2017-03-21 06:29:08'),(66,1760127,927,'2017-03-21 06:56:16'),(67,2297029,681,'2017-03-21 07:03:47'),(68,2297029,681,'2017-03-21 07:04:42'),(69,1760127,927,'2017-03-21 10:11:53'),(70,1760127,927,'2017-03-21 10:13:14'),(71,2167067,114,'2017-03-21 10:19:03');
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-22  9:50:01
