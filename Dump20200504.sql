CREATE DATABASE  IF NOT EXISTS `private_school` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `private_school`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: private_school
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `assignment_course`
--

DROP TABLE IF EXISTS `assignment_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignment_course` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ASM_ID` int NOT NULL,
  `COURSE_ID` int NOT NULL,
  `SUB_DATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ASM_ID` (`ASM_ID`,`COURSE_ID`),
  KEY `FK_ASSIGNMENT_COURSE_COURSES` (`COURSE_ID`),
  CONSTRAINT `FK_ASSIGNMENT_COURSE_ASSIGNMENTS` FOREIGN KEY (`ASM_ID`) REFERENCES `assignments` (`ASM_ID`),
  CONSTRAINT `FK_ASSIGNMENT_COURSE_COURSES` FOREIGN KEY (`COURSE_ID`) REFERENCES `courses` (`COURSE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignment_course`
--

LOCK TABLES `assignment_course` WRITE;
/*!40000 ALTER TABLE `assignment_course` DISABLE KEYS */;
INSERT INTO `assignment_course` VALUES (1,1,1,'2020-02-17 00:00:00'),(2,2,2,'2020-02-17 00:00:00'),(3,3,3,'2020-02-17 00:00:00'),(4,4,4,'2020-02-17 00:00:00');
/*!40000 ALTER TABLE `assignment_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignments`
--

DROP TABLE IF EXISTS `assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignments` (
  `ASM_ID` int NOT NULL AUTO_INCREMENT,
  `TITLEE` varchar(20) NOT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  `ORAL_MARK` decimal(5,2) NOT NULL DEFAULT '0.00',
  `TOTAL_MARK` decimal(5,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`ASM_ID`),
  UNIQUE KEY `TITLEE` (`TITLEE`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignments`
--

LOCK TABLES `assignments` WRITE;
/*!40000 ALTER TABLE `assignments` DISABLE KEYS */;
INSERT INTO `assignments` VALUES (1,'PROJECT BRIEF PART A','CB10,PART',20.00,80.00),(2,'PROJECT BRIEF PART B','CB10,FULL',20.00,80.00),(3,'PROJECT BRIEF PART C','CB10,PART',20.00,80.00),(4,'PROJECT BRIEF PART D','CB10,FULL',20.00,80.00),(5,'fdfdfd','fdfdfd',20.00,80.00);
/*!40000 ALTER TABLE `assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `COURSE_ID` int NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(20) NOT NULL,
  `STREAM` varchar(20) NOT NULL,
  `TYPE` varchar(20) NOT NULL,
  `START_DATE` date NOT NULL DEFAULT '0000-00-00',
  `END_DATE` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`COURSE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'JAVA','CB10','PART TIME','2020-02-17','2020-05-16'),(2,'JAVASCRIPT','CB10','FULL TIME','2020-02-17','2020-05-20'),(3,'C#','CB10','PART TIME','2020-02-17','2020-05-16'),(4,'HTML','CB10','FULL TIME','2020-02-17','2020-05-20');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_assignment`
--

DROP TABLE IF EXISTS `student_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_assignment` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `STU_ID` int NOT NULL,
  `ASM_ID` int NOT NULL,
  `ORAL_MARK` int NOT NULL DEFAULT '0',
  `TOTAL_MARK` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `STU_ID` (`STU_ID`,`ASM_ID`),
  KEY `FK_STUDENT_ASSIGNMENT_ASSIGNMENTS` (`ASM_ID`),
  CONSTRAINT `FK_STUDENT_ASSIGNMENT_ASSIGNMENTS` FOREIGN KEY (`ASM_ID`) REFERENCES `assignments` (`ASM_ID`),
  CONSTRAINT `FK_STUDENT_ASSIGNMENT_STUDENTS` FOREIGN KEY (`STU_ID`) REFERENCES `students` (`STU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_assignment`
--

LOCK TABLES `student_assignment` WRITE;
/*!40000 ALTER TABLE `student_assignment` DISABLE KEYS */;
INSERT INTO `student_assignment` VALUES (1,1,1,20,80),(2,1,2,20,80),(3,2,2,20,80),(4,2,3,20,80),(5,3,3,20,80),(6,3,4,20,80),(7,4,4,20,80),(8,5,1,20,80),(9,6,2,20,80),(10,7,3,20,80),(11,8,4,20,80),(12,9,1,20,80),(13,10,2,20,80),(14,11,3,20,80),(15,11,4,20,80),(16,12,4,20,80),(17,13,1,20,80),(18,14,2,20,80),(19,15,3,20,80),(20,16,4,20,80),(21,17,1,20,80),(22,18,2,20,80),(23,19,3,20,80),(24,20,4,20,80),(25,20,3,20,80),(26,21,1,20,80);
/*!40000 ALTER TABLE `student_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course`
--

DROP TABLE IF EXISTS `student_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_course` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `STU_ID` int NOT NULL,
  `COURSE_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_STUDENT_COURSE_STUDENTS` (`STU_ID`),
  KEY `FK_STUDENT_COURSE_COURSES` (`COURSE_ID`),
  CONSTRAINT `FK_STUDENT_COURSE_COURSES` FOREIGN KEY (`COURSE_ID`) REFERENCES `courses` (`COURSE_ID`),
  CONSTRAINT `FK_STUDENT_COURSE_STUDENTS` FOREIGN KEY (`STU_ID`) REFERENCES `students` (`STU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course`
--

LOCK TABLES `student_course` WRITE;
/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;
INSERT INTO `student_course` VALUES (1,1,1),(2,1,2),(3,2,1),(4,2,3),(5,3,1),(6,4,1),(7,4,1),(8,5,1),(9,6,2),(10,7,2),(11,8,2),(12,9,2),(13,10,2),(14,11,3),(15,12,3),(16,13,3),(17,14,3),(18,15,3),(19,16,4),(20,17,4),(21,18,4),(22,19,4),(23,20,4),(24,21,4);
/*!40000 ALTER TABLE `student_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `STU_ID` int NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(100) NOT NULL,
  `LAST_NAME` varchar(150) NOT NULL,
  `DATE_OF_BIRTH` date NOT NULL,
  `TUITION_FEES` decimal(6,0) DEFAULT NULL,
  PRIMARY KEY (`STU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'ΑΝΔΡΕΑΣ','ΜΕΛΑΔΙΑΝΟΣ','1993-09-04',2500),(2,'ΠΟΛΥΚΑΡΠΟΣ','ΜΕΛΑΔΙΑΝΟΣ','1989-04-04',2500),(3,'ΓΕΩΡΓΙΑ','ΜΠΟΥΛΟΥΜΠΑΣΗ','1993-12-19',2500),(4,'ΟΡΕΣΤΗΣ','ΒΡΕΤΤΟΣ','1993-09-04',2500),(5,'ΣΟΦΙΑ','ΦΑΚΑ','1995-03-07',2500),(6,'ΚΑΤΕΡΙΝΑ','ΝΕΡΑΤΖΑΚΗ','1993-10-14',2500),(7,'ΑΛΕΞΗΣ','ΚΗΠΟΥΡΟΣ','1990-03-08',2500),(8,'ΑΛΕΞΑΝΔΡΟΣ','ΠΑΠΑΔΟΠΟΥΛΟΣ','1992-08-04',2500),(9,'ΡΑΦΑΗΛ','ΖΙΟΥΤΗΣ','1993-07-13',2500),(10,'ΠΑΥΛΟΣ','ΛΙΑΤΣΗΣ','1992-05-04',2500),(11,'ΓΙΑΝΝΗΣ','ΧΑΣΑΠΗΣ','1993-07-24',2500),(12,'ΘΑΝΑΣΗΣ','ΜΠΟΥΚΟΓΙΑΝΝΗΣ','1992-06-04',2500),(13,'ΔΗΜΗΤΡΗΣ','ΜΙΜΙΔΗΣ','1993-10-26',2500),(14,'ΜΙΧΑΛΗΣ','ΑΡΝΑΟΥΤ','1992-05-06',2500),(15,'ΠΑΝΑΓΙΩΤΗΣ','ΜΑΡΑΘΙΑΝΟΣ','1993-11-04',2500),(16,'ΣΑΒΒΑΣ','ΞΑΝΘΟΠΟΥΛΟΣ','1993-09-17',2500),(17,'ΣΤΕΦΑΝΟΣ','ΞΥΛΟΥΔΗΣ','1993-09-04',2500),(18,'ΡΑΝΙΑ','ΜΠΟΥΛΟΥΜΠΑΣΗ','1996-04-04',2500),(19,'ΣΟΦΙΑ','ΓΟΥΝΕΛΑ','1993-09-04',2500),(20,'ΔΗΜΗΤΡΑ','ΜΑΛΙΑΡΟΥ','1993-09-04',2500),(21,'ΘΑΝΟΣ','ΑΝΤΩΝΙΟΥ','1993-03-18',2500),(22,'orestis','vrettos','2000-01-02',2500),(23,'orestis','vrettos','1993-05-18',2500),(24,'orestis','vrettos','1993-05-28',2500),(25,'�������','�������','1993-05-28',2500);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainer_course`
--

DROP TABLE IF EXISTS `trainer_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainer_course` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `TR_ID` int NOT NULL,
  `COURSE_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `TR_ID` (`TR_ID`,`COURSE_ID`),
  KEY `FK_TRAINER_COURSE_COURSES` (`COURSE_ID`),
  CONSTRAINT `FK_TRAINER_COURSE_COURSES` FOREIGN KEY (`COURSE_ID`) REFERENCES `courses` (`COURSE_ID`),
  CONSTRAINT `FK_TRAINER_COURSE_TRAINERS` FOREIGN KEY (`TR_ID`) REFERENCES `trainers` (`TR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer_course`
--

LOCK TABLES `trainer_course` WRITE;
/*!40000 ALTER TABLE `trainer_course` DISABLE KEYS */;
INSERT INTO `trainer_course` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,1);
/*!40000 ALTER TABLE `trainer_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainers`
--

DROP TABLE IF EXISTS `trainers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainers` (
  `TR_ID` int NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(100) NOT NULL,
  `LAST_NAME` varchar(150) NOT NULL,
  `SUBJECT` varchar(50) NOT NULL,
  PRIMARY KEY (`TR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainers`
--

LOCK TABLES `trainers` WRITE;
/*!40000 ALTER TABLE `trainers` DISABLE KEYS */;
INSERT INTO `trainers` VALUES (1,'ΑΡΓΥΡΗΣ','ΠΑΓΙΔΑΣ','MYSQL'),(2,'ΓΙΩΡΓΟΣ','ΠΑΣΠΑΡΑΚΗΣ','JAVA'),(3,'ΓΙΩΡΓΟΣ','ΗΡΑΚΛΕΙΔΗΣ','JAVA'),(4,'ΝΙΚΟΣ','ΚΑΡΑΠΑΣ','JAVA'),(5,'ΑΝΑΣΤΑΣΙΟΣ','ΛΕΛΑΚΗΣ','JAVA');
/*!40000 ALTER TABLE `trainers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-04 16:12:52
