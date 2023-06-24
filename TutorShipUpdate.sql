CREATE DATABASE  IF NOT EXISTS `tutorship` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tutorship`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tutorship
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `cronogramacurso`
--

DROP TABLE IF EXISTS `cronogramacurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cronogramacurso` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `curso_id` int unsigned NOT NULL,
  `docente_id` int unsigned NOT NULL,
  `tutor_id` int unsigned NOT NULL,
  `horaInicio` time NOT NULL,
  `horaFin` time NOT NULL,
  `fecha` date NOT NULL,
  `estado` enum('Activo','Pausa','Suspendido','Eliminado') DEFAULT 'Activo',
  PRIMARY KEY (`id`),
  KEY `fk_curso_cronograma_idx` (`curso_id`),
  KEY `fk_docente_cronograma_idx` (`docente_id`),
  KEY `fk_tutor_cronograma_idx` (`tutor_id`),
  CONSTRAINT `fk_curso_cronograma` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_docente_cronograma` FOREIGN KEY (`docente_id`) REFERENCES `personas` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_tutor_cronograma` FOREIGN KEY (`tutor_id`) REFERENCES `personas` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cronogramacurso`
--

LOCK TABLES `cronogramacurso` WRITE;
/*!40000 ALTER TABLE `cronogramacurso` DISABLE KEYS */;
/*!40000 ALTER TABLE `cronogramacurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(45) NOT NULL,
  `codigo` varchar(45) NOT NULL,
  `persona_id` int unsigned NOT NULL,
  `estado` enum('Activo','Inactivo','Eliminado') DEFAULT 'Activo',
  PRIMARY KEY (`id`),
  KEY `fk_persona_curso_idx` (`persona_id`),
  CONSTRAINT `fk_persona_curso` FOREIGN KEY (`persona_id`) REFERENCES `personas` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallecursopersona`
--

DROP TABLE IF EXISTS `detallecursopersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detallecursopersona` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `alumno_id` int unsigned NOT NULL,
  `cronograma_curso_id` int unsigned NOT NULL,
  `tutor_id` int unsigned NOT NULL,
  `fecha` datetime NOT NULL,
  `estado` enum('Suscrito','Suspendido','Desercion') DEFAULT 'Suscrito',
  PRIMARY KEY (`id`),
  KEY `fk_alumno_detalleCursoPersona_idx` (`alumno_id`),
  KEY `fk_cronograma_cursos_detalleCursoPersona_idx` (`cronograma_curso_id`),
  KEY `fk_tutor_detalleCursoPersona_idx` (`tutor_id`),
  CONSTRAINT `fk_alumno_detalleCursoPersona` FOREIGN KEY (`alumno_id`) REFERENCES `personas` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_cronograma_curso_detalleCursoPerona` FOREIGN KEY (`cronograma_curso_id`) REFERENCES `cronogramacurso` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_tutor_detalleCursoPersona` FOREIGN KEY (`tutor_id`) REFERENCES `personas` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallecursopersona`
--

LOCK TABLES `detallecursopersona` WRITE;
/*!40000 ALTER TABLE `detallecursopersona` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallecursopersona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institucion`
--

DROP TABLE IF EXISTS `institucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `institucion` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(250) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `celular` varchar(45) NOT NULL,
  `estado` enum('Activo','Inactivo','Eliminado') DEFAULT 'Activo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institucion`
--

LOCK TABLES `institucion` WRITE;
/*!40000 ALTER TABLE `institucion` DISABLE KEYS */;
/*!40000 ALTER TABLE `institucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notas`
--

DROP TABLE IF EXISTS `notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notas` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cronograma_curso_id` int unsigned NOT NULL,
  `alumno_id` int unsigned NOT NULL,
  `docente_tutor_id` int unsigned NOT NULL,
  `nota` double NOT NULL,
  `fecha` datetime NOT NULL,
  `estado` enum('Aprobado','Desaprobado') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cronograma_curso_notas_idx` (`cronograma_curso_id`),
  KEY `fk_alumno_nota_idx` (`alumno_id`),
  KEY `fk_docente_tutor_nota_idx` (`docente_tutor_id`),
  CONSTRAINT `fk_alumno_nota` FOREIGN KEY (`alumno_id`) REFERENCES `personas` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_cronograma_curso_notas` FOREIGN KEY (`cronograma_curso_id`) REFERENCES `cronogramacurso` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_docente_tutor_nota` FOREIGN KEY (`docente_tutor_id`) REFERENCES `personas` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notas`
--

LOCK TABLES `notas` WRITE;
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `tipopersona_id` int unsigned DEFAULT NULL,
  `nombresApellidos` varchar(120) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `estado` enum('Activo','Inactivo','Eliminado') DEFAULT 'Activo',
  `institucion_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_persona_tipopersona_idx` (`tipopersona_id`),
  KEY `fk_tipopersona_persona_idx` (`tipopersona_id`),
  KEY `fk_institucion_persona_idx` (`institucion_id`),
  CONSTRAINT `fk_institucion_persona` FOREIGN KEY (`institucion_id`) REFERENCES `institucion` (`id`),
  CONSTRAINT `fk_tipopersona_persona` FOREIGN KEY (`tipopersona_id`) REFERENCES `tipopersona` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,1,'ALDO QUISPE HUAMANTINCO','ALDO@GMAIL.COM','JAVA','ALFA','123','Activo',0),(2,3,'RONI SUMARI PALOMINO','SUMARI@GMAIL.COM','MODELADO','MAYUS','123','Activo',0);
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopersona`
--

DROP TABLE IF EXISTS `tipopersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipopersona` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  `estado` enum('Activo','Inactivo','Eliminado') NOT NULL DEFAULT 'Activo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopersona`
--

LOCK TABLES `tipopersona` WRITE;
/*!40000 ALTER TABLE `tipopersona` DISABLE KEYS */;
INSERT INTO `tipopersona` VALUES (1,'Alumno','Activo'),(2,'Docente','Activo'),(3,'Administrador','Activo');
/*!40000 ALTER TABLE `tipopersona` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-12 18:14:37
