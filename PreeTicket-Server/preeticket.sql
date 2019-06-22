-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `activity` (
  `id_activity` int(11) NOT NULL AUTO_INCREMENT,
  `id_organizer` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `place` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time_signup` varchar(255) DEFAULT NULL,
  `time_start` varchar(255) DEFAULT NULL,
  `capacity` int(11) NOT NULL,
  `detail` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `seat_selectable` int(4) NOT NULL,
  `seat_row` int(11) DEFAULT NULL,
  `seat_col` int(11) DEFAULT NULL,
  `seat_map` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_activity`) USING BTREE,
  KEY `activity-O_idx` (`id_organizer`) USING BTREE,
  CONSTRAINT `act-Org` FOREIGN KEY (`id_organizer`) REFERENCES `user_organizer` (`id_organizer`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1001,2001,1,'演唱会','天佑会堂','2019-06-07 01:01:01','2019-06-15 02:02:02',100,'no detail',1,5,5,'0000000000000000000000000');
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `notice` (
  `id_notice` int(11) NOT NULL AUTO_INCREMENT,
  `id_act` int(11) NOT NULL,
  `time_publish` varchar(255) DEFAULT NULL,
  `detail` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id_notice`) USING BTREE,
  KEY `notice-Act_idx` (`id_act`) USING BTREE,
  CONSTRAINT `notict-Act` FOREIGN KEY (`id_act`) REFERENCES `activity` (`id_activity`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=10007 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (10001,1001,'2019-06-15 10:15:00','no detail');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ticket` (
  `id_activity` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `seat` int(11) NOT NULL,
  PRIMARY KEY (`id_activity`,`id_user`,`seat`) USING BTREE,
  KEY `tickets-userN_idx` (`id_user`) USING BTREE,
  CONSTRAINT `ticket-Act` FOREIGN KEY (`id_activity`) REFERENCES `activity` (`id_activity`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ticket-Own` FOREIGN KEY (`id_user`) REFERENCES `user_normal` (`id_normal`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1001,1001,37);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_normal`
--

DROP TABLE IF EXISTS `user_normal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_normal` (
  `id_normal` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `avator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gender` int(10) DEFAULT NULL,
  `tel_num` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_normal`,`username`) USING BTREE,
  KEY `id_normal` (`id_normal`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_normal`
--

LOCK TABLES `user_normal` WRITE;
/*!40000 ALTER TABLE `user_normal` DISABLE KEYS */;
INSERT INTO `user_normal` VALUES (1001,'user1','111','Normal1','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3443176063,4021563566&fm=27&gp=0.jpg',1,'111111','1@11.com'),(1002,'user2','222','Normal2','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3512142610,2378185322&fm=27&gp=0.jpg',0,'111111','2@qq.com'),(1004,'user3','333','Normal3',NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `user_normal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_organizer`
--

DROP TABLE IF EXISTS `user_organizer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_organizer` (
  `id_organizer` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `organize` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel_num` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_organizer`,`username`) USING BTREE,
  KEY `id_organizer` (`id_organizer`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2002 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_organizer`
--

LOCK TABLES `user_organizer` WRITE;
/*!40000 ALTER TABLE `user_organizer` DISABLE KEYS */;
INSERT INTO `user_organizer` VALUES (2001,'Org1','111','学生会','111111','1@qq.com','Intro');
/*!40000 ALTER TABLE `user_organizer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-23  0:50:34
