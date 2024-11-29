-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: localhost    Database: bdmarvel
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `personajehistoria`
--

DROP TABLE IF EXISTS `personajehistoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personajehistoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nomhistoria` varchar(45) DEFAULT NULL,
  `idpersonaje` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajehistoria`
--

LOCK TABLES `personajehistoria` WRITE;
/*!40000 ALTER TABLE `personajehistoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `personajehistoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personajes`
--

DROP TABLE IF EXISTS `personajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personajes` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajes`
--

LOCK TABLES `personajes` WRITE;
/*!40000 ALTER TABLE `personajes` DISABLE KEYS */;
INSERT INTO `personajes` VALUES (1009144,'A.I.M.'),(1009146,'Abomination (Emil Blonsky)'),(1009148,'Absorbing Man'),(1009149,'Abyss'),(1009150,'Agent Zero'),(1010354,'Adam Warlock'),(1010699,'Aaron Stack'),(1010846,'Aegis (Trey Rollins)'),(1010903,'Abyss (Age of Apocalypse)'),(1011031,'Agent X (Nijo)'),(1011136,'Air-Walker (Gabriel Lan)'),(1011175,'Aginar'),(1011198,'Agents of Atlas'),(1011266,'Adam Destine'),(1011297,'Agent Brand'),(1011334,'3-D Man'),(1012717,'Agatha Harkness'),(1016823,'Abomination (Ultimate)'),(1017100,'A-Bomb (HAS)'),(1017851,'Aero (Aero)');
/*!40000 ALTER TABLE `personajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personajeserie`
--

DROP TABLE IF EXISTS `personajeserie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personajeserie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombreserie` varchar(45) DEFAULT NULL,
  `idpersonaje` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajeserie`
--

LOCK TABLES `personajeserie` WRITE;
/*!40000 ALTER TABLE `personajeserie` DISABLE KEYS */;
/*!40000 ALTER TABLE `personajeserie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trackinuser`
--

DROP TABLE IF EXISTS `trackinuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trackinuser` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` varchar(45) DEFAULT NULL COMMENT 'Usuario que hizo la peticion',
  `urlpeticion` varchar(45) DEFAULT NULL COMMENT 'Url que hizo la peticion',
  `tipobuqueda` int DEFAULT NULL COMMENT 'Tipo de búsqueda 0=Busqueda General 1= Búsqueda de historieta',
  `fechapeticion` date DEFAULT NULL COMMENT 'Fecha que realizo la peticion',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trackinuser`
--

LOCK TABLES `trackinuser` WRITE;
/*!40000 ALTER TABLE `trackinuser` DISABLE KEYS */;
INSERT INTO `trackinuser` VALUES (1,'admin','/obtenerpersonajes',0,'2023-09-21'),(2,'admin','/personajeserie?idpersonaje=1011334',0,'2023-09-21'),(3,'admin','/personajehistorietas?id=1011334',1,'2023-09-21');
/*!40000 ALTER TABLE `trackinuser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-21 10:48:34
