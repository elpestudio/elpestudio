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