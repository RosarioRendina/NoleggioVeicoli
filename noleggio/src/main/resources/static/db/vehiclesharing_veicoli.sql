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
-- Table structure for table `veicoli`
--

DROP TABLE IF EXISTS `veicoli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veicoli` (
  `veicolo_id` int NOT NULL AUTO_INCREMENT,
  `categoria` enum('AUTO','SCOOTER','MOTO','FURGONE','MONOPATTINO','BICICLETTA','CAMMELLO') NOT NULL,
  `anno` int DEFAULT NULL,
  `marca` varchar(50) NOT NULL,
  `modello` varchar(50) DEFAULT NULL,
  `colore` varchar(20) DEFAULT NULL,
  `cilindrata` int DEFAULT NULL,
  `alimentazione` enum('ELETTRICA','BENZINA','DIESEL','GPL','IBRIDA') DEFAULT NULL,
  `indirizzo` varchar(100) NOT NULL,
  `coordinate` varchar(100) DEFAULT NULL,
  `disponibilita` tinyint(1) NOT NULL,
  `img_veicolo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`veicolo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veicoli`
--

LOCK TABLES `veicoli` WRITE;
/*!40000 ALTER TABLE `veicoli` DISABLE KEYS */;
INSERT INTO `veicoli` VALUES (1,'AUTO',2020,'Toyota','Corolla','Blu',1800,'IBRIDA','Via Roma 1, Milano','45.464211, 9.191383',1,'https://unsplash.com/auto1'),(2,'SCOOTER',2019,'Piaggio','Liberty','Bianco',125,'BENZINA','Via Dante 5, Napoli','40.851775, 14.268124',1,'https://unsplash.com/scooter1'),(3,'MOTO',2021,'Honda','CB500F','Rosso',500,'BENZINA','Via Garibaldi 20, Roma','41.902782, 12.496366',1,'https://unsplash.com/moto1'),(4,'FURGONE',2018,'Ford','Transit','Grigio',2200,'DIESEL','Via Verdi 10, Torino','45.070339, 7.686864',0,'https://unsplash.com/furgone1'),(5,'MONOPATTINO',2023,'Xiaomi','Pro 2','Nero',NULL,'ELETTRICA','Via Vittorio Veneto 7, Firenze','43.769560, 11.255814',1,'https://unsplash.com/monopattino1'),(6,'BICICLETTA',2022,'Decathlon','Rockrider','Verde',NULL,NULL,'Corso Buenos Aires 30, Milano','45.478561, 9.207501',1,'https://unsplash.com/bici1'),(7,'AUTO',2021,'Volkswagen','Golf','Argento',1600,'DIESEL','Via Manzoni 15, Bologna','44.494887, 11.342616',1,'https://unsplash.com/auto2'),(8,'MOTO',2020,'Yamaha','MT-07','Blu',689,'BENZINA','Via Duomo 3, Napoli','40.851775, 14.268124',0,'https://unsplash.com/moto2'),(9,'CAMMELLO',NULL,'Sahara','Desert Racer','Marrone',NULL,NULL,'Via della Sabbia 1, Palermo','38.115688, 13.361267',1,'https://unsplash.com/cammello1'),(10,'FURGONE',2022,'Mercedes','Sprinter','Bianco',2000,'DIESEL','Via San Marco 50, Venezia','45.434046, 12.338860',0,'https://unsplash.com/furgone2');
/*!40000 ALTER TABLE `veicoli` ENABLE KEYS */;
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
