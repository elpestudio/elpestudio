-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.30 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando estructura para tabla tutorship.cronogramacurso
CREATE TABLE IF NOT EXISTS `cronogramacurso` (
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

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla tutorship.detallecursopersona
CREATE TABLE IF NOT EXISTS `detallecursopersona` (
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

-- La exportación de datos fue deseleccionada.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
