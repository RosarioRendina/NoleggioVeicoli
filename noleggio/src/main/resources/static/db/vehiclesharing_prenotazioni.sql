-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: vehiclesharing
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `prenotazioni`
--

DROP TABLE IF EXISTS `prenotazioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazioni` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `utente_id` int NOT NULL,
  `veicolo_id` int NOT NULL,
  `inizio_prenotazione` date DEFAULT NULL,
  `stato_prenotazione` enum('ATTIVA','TERMINATA','ANNULLATA') NOT NULL DEFAULT 'ATTIVA',
  `fine_prenotazione` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_prenotazioni_utente` (`utente_id`),
  KEY `fk_prenotazioni_veicoli` (`veicolo_id`),
  CONSTRAINT `fk_prenotazioni_utente` FOREIGN KEY (`utente_id`) REFERENCES `utente` (`utente_id`),
  CONSTRAINT `fk_prenotazioni_veicoli` FOREIGN KEY (`veicolo_id`) REFERENCES `veicoli` (`veicolo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazioni`
--

LOCK TABLES `prenotazioni` WRITE;
/*!40000 ALTER TABLE `prenotazioni` DISABLE KEYS */;
INSERT INTO `prenotazioni` VALUES (1,1,1,'2025-01-01','ATTIVA',NULL),(2,2,2,'2024-12-30','TERMINATA','2025-01-01'),(3,1,3,'2025-01-02','ATTIVA',NULL),(4,2,4,'2024-12-25','ANNULLATA',NULL),(5,1,5,'2024-12-28','TERMINATA','2024-12-29'),(6,2,6,'2025-01-01','ATTIVA',NULL),(7,1,7,'2024-12-31','ANNULLATA',NULL),(8,2,8,'2024-12-29','TERMINATA','2024-12-30'),(9,1,9,'2025-01-01','ATTIVA',NULL),(10,2,10,'2024-12-31','TERMINATA','2025-01-01');
/*!40000 ALTER TABLE `prenotazioni` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-07 10:55:20
