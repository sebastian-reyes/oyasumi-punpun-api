/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE TABLE IF NOT EXISTS `chapters` (
  `id_chapter` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `id_volume` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_chapter`),
  KEY `FKb0sh2sjtrm2owu6n2dwkcuhgp` (`id_volume`),
  CONSTRAINT `FKb0sh2sjtrm2owu6n2dwkcuhgp` FOREIGN KEY (`id_volume`) REFERENCES `volumes` (`id_volume`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `chapters` DISABLE KEYS */;
INSERT INTO `chapters` (`id_chapter`, `name`, `id_volume`) VALUES
	(1, 'Chapter 1', 1),
	(2, 'Chapter 2', 1),
	(3, 'Chapter 3', 1),
	(4, 'Chapter 4', 1),
	(5, 'Chapter 5', 1),
	(6, 'Chapter 6', 1),
	(7, 'Chapter 7', 1),
	(8, 'Chapter 8', 1),
	(9, 'Chapter 9', 1),
	(10, 'Chapter 10', 1),
	(11, 'Chapter 11', 1),
	(12, 'Chapter 12', 1),
	(13, 'Chapter 13', 2),
	(14, 'Chapter 14', 2),
	(15, 'Chapter 15', 2),
	(16, 'Chapter 16', 2),
	(17, 'Chapter 17', 2),
	(18, 'Chapter 18', 2),
	(19, 'Chapter 19', 2),
	(20, 'Chapter 20', 2),
	(21, 'Chapter 21', 2),
	(22, 'Chapter 22', 2),
	(23, 'Chapter 23', 2),
	(34, 'Chapter 34', 3),
	(46, 'Chapter 46', 4),
	(56, 'Chapter 56', 5);
/*!40000 ALTER TABLE `chapters` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `chapters_characters` (
  `id_chapter` int(11) NOT NULL,
  `id_character` int(11) NOT NULL,
  UNIQUE KEY `UKptlf17f0oxb63ij583xdldyyn` (`id_chapter`,`id_character`),
  KEY `FK9jbxk1egyhpql7rqlflp85k8h` (`id_character`),
  CONSTRAINT `FK9jbxk1egyhpql7rqlflp85k8h` FOREIGN KEY (`id_character`) REFERENCES `characters` (`id_character`),
  CONSTRAINT `FKerg62bdp92scesybyi2bi3pd0` FOREIGN KEY (`id_chapter`) REFERENCES `chapters` (`id_chapter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `chapters_characters` DISABLE KEYS */;
INSERT INTO `chapters_characters` (`id_chapter`, `id_character`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 5),
	(1, 7),
	(1, 10),
	(1, 11),
	(1, 12),
	(2, 1),
	(2, 2),
	(2, 5),
	(2, 6),
	(2, 8),
	(2, 11),
	(2, 12),
	(3, 1),
	(3, 2),
	(3, 5),
	(3, 7),
	(3, 11);
/*!40000 ALTER TABLE `chapters_characters` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `characters` (
  `id_character` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(85) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `species` varchar(20) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_character`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `characters` DISABLE KEYS */;
INSERT INTO `characters` (`id_character`, `name`, `gender`, `species`, `status`, `image`) VALUES
	(1, 'Onodena Punpun', 'Male', 'Human', 'Alive', 'onodera_punpun.webp'),
	(2, 'Aiko Tanaka', 'Female', 'Human', 'Dead', 'aiko_tanaka.webp'),
	(3, 'Mama Punpun', 'Female', 'Human', 'Alive', NULL),
	(4, 'Papa Punpun', 'Male', 'Human', 'Alive', NULL),
	(5, 'Onodera Yuichi', 'Male', 'Human', 'Alive', NULL),
	(6, 'Seki Masumi', 'Male', 'Human', 'Alive', NULL),
	(7, 'God', 'Male', 'Entity', '-', NULL),
	(8, 'Shimizu Kou', 'Male', 'Human', 'Alive', NULL),
	(9, 'Yaguchi Takao', 'Male', 'Human', 'Alive', NULL),
	(10, 'Miyo Ohta', 'Female', 'Human', 'Alive', NULL),
	(11, 'Harumi Shuntarou', 'Male', 'Human', 'Alive', NULL),
	(12, 'Komatsu', 'Male', 'Human', 'Alive', NULL);
/*!40000 ALTER TABLE `characters` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `volumes` (
  `id_volume` int(11) NOT NULL AUTO_INCREMENT,
  `description` text DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_volume`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `volumes` DISABLE KEYS */;
INSERT INTO `volumes` (`id_volume`, `description`, `name`) VALUES
	(1, NULL, 'Volume 1'),
	(2, NULL, 'Volume 2'),
	(3, NULL, 'Volume 3'),
	(4, NULL, 'Volume 4'),
	(5, NULL, 'Volume 5'),
	(6, NULL, 'Volume 6'),
	(7, NULL, 'Volume 7'),
	(8, NULL, 'Volume 8'),
	(9, NULL, 'Volume 9'),
	(10, NULL, 'Volume 10'),
	(11, NULL, 'Volume 11'),
	(12, NULL, 'Volume 12'),
	(13, NULL, 'Volume 13');
/*!40000 ALTER TABLE `volumes` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
