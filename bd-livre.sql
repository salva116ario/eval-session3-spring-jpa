-- MySQL dump 10.16  Distrib 10.1.37-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: bd-livre
-- ------------------------------------------------------
-- Server version	10.1.37-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorie` (
  `ca_id` int(11) NOT NULL,
  `ca_intitule` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  PRIMARY KEY (`ca_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` VALUES (1,'Arts'),(2,'Bande dessinée'),(3,'Cuisine, gastronomie, vins'),(4,'Dictionnaires, méthodes de langue'),(5,'Comptabilité, économie, droit'),(12,'Littérature');
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livre`
--

DROP TABLE IF EXISTS `livre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livre` (
  `li_id` int(11) NOT NULL,
  `li_titre` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `li_auteur` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `li_couverture` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `li_editeur` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `li_isbn` bigint(20) DEFAULT NULL,
  `li_prix` double DEFAULT NULL,
  `li_stock` int(11) DEFAULT NULL,
  `categorie` int(11) DEFAULT NULL,
  PRIMARY KEY (`li_id`),
  KEY `FKdovufn5jal0ylqs7859sqp90k` (`categorie`),
  CONSTRAINT `FKdovufn5jal0ylqs7859sqp90k` FOREIGN KEY (`categorie`) REFERENCES `categorie` (`ca_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livre`
--

LOCK TABLES `livre` WRITE;
/*!40000 ALTER TABLE `livre` DISABLE KEYS */;
INSERT INTO `livre` VALUES (1,'Le Incidences (L\'amour est un crime parfait) Nicolas','Philippe Djian','https://www.telerama.fr/sites/tr_master/files/styles/media_640_auto/public/philippe-djian-incidences%2CM33361_1.jpg?itok=0Qvvj6fj','Editions Gallimard',9782072443671,17.9,1,12),(2,'Le soleil des Scorta','Laurent Gaudé','https://images-na.ssl-images-amazon.com/images/I/71fIOTk%2B1XL.jpg','Actes Sud',9782742751419,3.5,2,12),(3,'Victoire 1918: Les 100 Derniers Jours','Tim Cook','https://www.museedelaguerre.ca/boutique/wp-content/uploads/2018/10/CWM-100Days-Cover-FR-72DPI-1800P.jpg','La Collection Catalogue-Souvenir',9780660252551,0.9,230,1),(4,'L\'avenir en commun','Jean-Luc Mélenchon','https://images-na.ssl-images-amazon.com/images/I/41XthpaU5QL._SX315_BO1,204,203,200_.jpg','Seuil',9782021317510,3,600,3),(5,'Vengeances','Philippe Djian','https://www.babelio.com/couv/CVT_Vengeances_6257.pjpeg','Editions Gallimard',9782070134793,12,0,12),(6,'Bienvenue au club','Jonathan Coe','http://www.gallimard.fr/var/storage/images/product/5fb/product_9782070762156_195x320.jpg','Folio',9782070317233,5.9,1,12);
/*!40000 ALTER TABLE `livre` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-13  9:55:35
