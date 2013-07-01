-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.55-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema pyca
--

CREATE DATABASE IF NOT EXISTS pyca;
USE pyca;

--
-- Definition of table `district`
--

DROP TABLE IF EXISTS `district`;
CREATE TABLE `district` (
  `districtID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `districtName` varchar(45) NOT NULL,
  PRIMARY KEY (`districtID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `district`
--

/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` (`districtID`,`districtName`) VALUES 
 (1,'Adecor'),
 (2,'Bandera'),
 (3,'Bugac'),
 (4,'Cogon'),
 (5,'Dadatan'),
 (6,'Guadalupe'),
 (7,'Poblacion'),
 (8,'San Isidro'),
 (9,'Sion'),
 (10,'Sta. Cruz'),
 (11,'Tad-tad'),
 (12,'Tagbaobo');
/*!40000 ALTER TABLE `district` ENABLE KEYS */;


--
-- Definition of table `idcolor`
--

DROP TABLE IF EXISTS `idcolor`;
CREATE TABLE `idcolor` (
  `colorID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `colorName` varchar(45) NOT NULL,
  `yearID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`colorID`),
  KEY `FK_idcolor_1` (`yearID`),
  CONSTRAINT `FK_idcolor_1` FOREIGN KEY (`yearID`) REFERENCES `year` (`yearID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `idcolor`
--

/*!40000 ALTER TABLE `idcolor` DISABLE KEYS */;
INSERT INTO `idcolor` (`colorID`,`colorName`,`yearID`) VALUES 
 (1,'Yellow',1),
 (2,'White',1),
 (3,'Cyber Pink',1),
 (4,'Cyber Yellow',1),
 (5,'Green',1),
 (6,'Blue',1),
 (7,'Orange',1),
 (8,'Violet',1),
 (9,'Peach',1),
 (10,'Pink',1),
 (11,'Lagoon',1),
 (12,'Cyber Red',1);
/*!40000 ALTER TABLE `idcolor` ENABLE KEYS */;


--
-- Definition of table `participant`
--

DROP TABLE IF EXISTS `participant`;
CREATE TABLE `participant` (
  `participantID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `middleName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `nickName` varchar(45) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  `typeID` int(10) unsigned NOT NULL,
  `districtID` int(10) unsigned NOT NULL,
  `teamID` int(10) unsigned DEFAULT NULL,
  `yearID` int(10) unsigned NOT NULL,
  `colorID` int(10) unsigned DEFAULT NULL,
  `gkk` varchar(150) DEFAULT NULL,
  `parentalConsent` tinyint(2) unsigned DEFAULT NULL,
  `registrationFee` tinyint(2) unsigned DEFAULT NULL,
  PRIMARY KEY (`participantID`),
  KEY `FK_participant_1` (`districtID`),
  KEY `FK_participant_2` (`teamID`),
  KEY `FK_participant_3` (`typeID`),
  KEY `FK_participant_4` (`yearID`),
  KEY `FK_participant_5` (`colorID`),
  CONSTRAINT `FK_participant_1` FOREIGN KEY (`districtID`) REFERENCES `district` (`districtID`) ON UPDATE CASCADE,
  CONSTRAINT `FK_participant_2` FOREIGN KEY (`teamID`) REFERENCES `team` (`teamID`) ON UPDATE CASCADE,
  CONSTRAINT `FK_participant_3` FOREIGN KEY (`typeID`) REFERENCES `type` (`typeID`) ON UPDATE CASCADE,
  CONSTRAINT `FK_participant_4` FOREIGN KEY (`yearID`) REFERENCES `year` (`yearID`) ON UPDATE CASCADE,
  CONSTRAINT `FK_participant_5` FOREIGN KEY (`colorID`) REFERENCES `idcolor` (`colorID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=292 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `participant`
--

/*!40000 ALTER TABLE `participant` DISABLE KEYS */;
INSERT INTO `participant` (`participantID`,`firstName`,`middleName`,`lastName`,`nickName`,`age`,`typeID`,`districtID`,`teamID`,`yearID`,`colorID`,`gkk`,`parentalConsent`,`registrationFee`) VALUES 
 (23,'Jake Laureen','Jake Laureen','Lucanas','Jake',14,1,2,5,1,5,'Bandera',1,0),
 (24,'Junjie','Autida','Autida','Junjie',19,1,1,5,1,5,'San Roque (Ilib) Chapel',0,0),
 (25,'Fritzie Marie','Fritzie Marie','Ranola','Fritzie',10,1,2,6,1,11,'Bandera',1,0),
 (26,'Jojie','Autida','Autida','Jojie',14,1,1,7,1,7,'San Roque (Ilib) Chapel',0,0),
 (27,'Girly','Girly','Otero','Girly',26,1,2,5,1,5,'Bandera',1,0),
 (28,'Georgia','Georgia','Legaspi','Georgia',14,1,2,4,1,4,'Bandera',1,0),
 (29,'Mary Joy','Mary Joy','Otero','Mary Joy',15,1,2,3,1,12,'Bandera',1,0),
 (30,'Shawie','Shawie','Robin','Shawie',13,1,2,2,1,3,'Bandera',1,0),
 (31,'Diodeza','Diodeza','Gualdajara','Diodeza',10,1,2,6,1,11,'Bandera',1,0),
 (32,'Julvis Rhey','Julvis Rhey','Cortez','Julvis',18,1,2,1,1,6,'Bandera',1,0),
 (33,'Jessa','Jessa','Gubalane','Jessa',13,1,2,12,1,1,'Bandera',1,0),
 (34,'Kimberly','Autida','Autida','Kimberly',13,1,1,3,1,12,'San Roque (Ilib) Chapel',0,0),
 (35,'Charisama','Charisma','Malita','Charisma',10,1,2,11,1,2,'Bandera',1,0),
 (36,'Gee Anne','Gee Anne','Barbarma','Gee Anne',13,1,2,7,1,7,'Bandera',1,0),
 (37,'Coy','Coy','Malabalo','Coy2x',15,1,2,8,1,9,'Bandera',1,0),
 (38,'March Mae','A','Cervantes','March',15,1,1,2,1,3,'San Roque (Ilib) Chapel',0,0),
 (39,'Tumala','Tumala','Mark Janiel','18',18,1,2,1,1,6,'Bandera',1,0),
 (40,'Diana Rose','Sale','Sale','Diana',16,1,1,3,1,12,'San Roque (Ilib) Chapel',0,0),
 (41,'Zyrra','M','Donguila','Zyrra',14,1,1,4,1,4,'San Roque - Hagnaya',0,0),
 (42,'Honey','M','Urbano','Honey',15,1,1,5,1,5,'San Roque Hagnaya',0,0),
 (43,'Jessica','M.','Autida','Jessica',17,1,1,6,1,11,'San Roque Hagnaya',0,0),
 (44,'Charles Dave','Salazar','Salazar','Charles',16,1,1,7,1,7,'San Vicente Ferrer',0,0),
 (45,'Lovely','M','Lipusan','Lovely',16,1,3,8,1,9,'San Miguel',0,0),
 (46,'Maglasang','Jezzlar','Jezzlar','Jezzlar',13,1,2,12,1,1,'Bandera',1,0),
 (47,'Hanizel','D','Lumapoc','Hanizel',19,1,2,11,1,2,'Bandera',1,0),
 (48,'Ramdie','M. ','Ostria','Ramdie',13,1,1,10,1,8,'San Vicente Ferrer',0,0),
 (49,'Richard','R.','Rocacuba','Richard',18,1,2,10,1,8,'Bandera',1,0),
 (50,'Charlito','M','Cepe','Charlito',18,1,1,11,1,2,'San Vicente Ferrer',0,0),
 (51,'Antonio','A','Espinosa','Antonio',18,1,2,9,1,10,'Bandera',1,0),
 (52,'Precious Pearl','M','Oracion','Precious',14,1,3,1,1,6,'San Miguel',0,0),
 (53,'Rian','D','Dela Cerna','Ri-an',17,1,2,10,1,8,'Bandera',1,0),
 (54,'Rotciv Octel','M','Naol','Rotciv',16,1,1,4,1,4,'San Vicente Ferrer',0,0),
 (55,'Gellan','G','Cuevas','Gellan',17,1,2,9,1,10,'Bandera',1,0),
 (56,'Karen','K','Gualdajara','Karen',15,1,2,4,1,4,'Bandera',1,0),
 (57,'Gerald Kaye','M','Cepe','Gerald',17,1,1,12,1,1,'San Vicente Ferrer',0,0),
 (58,'Gabriel','G','Dalumpenes','Gabriel',20,1,2,8,1,9,'Bandera',1,0),
 (59,'Jenia','S','Marabilis','Jenia',16,1,9,4,1,4,'San Fransisco De Asisis',1,1),
 (60,'Jembird','Senok','Senok','Jembird',14,1,9,7,1,7,'Berhen sa Fatima',1,1),
 (61,'Pia Mariz','Rodina','Rodina','Pia',13,1,3,9,1,10,'San Miguel',1,1),
 (62,'Jennifer','C','Lamberte','Jennifer',15,1,9,12,1,1,'Berhen sa Fatima',1,1),
 (63,'Tresa Mae','Y','Donaire','Tresa',15,1,9,1,1,6,'Berhen sa Fatima',1,1),
 (64,'Ritchie','M','Del Rosario','Ritchie',13,1,3,2,1,3,'San Miguel',1,1),
 (65,'Rackie','C','Castaritas','Rackie',14,1,9,2,1,3,'Berhen sa Fatima',1,1),
 (66,'Jovel','M','Lim','Jovil',14,1,3,12,1,1,'San Miguel',0,0),
 (67,'Darline','P','Lamberte','Darlene',21,1,9,3,1,12,'Berhen sa Fatima',1,1),
 (68,'Rexr','Rabaja','Rabaja','Gong',15,1,1,2,1,3,'San Miguel',0,0),
 (69,'Daryll','M','Gutierrez','Daryll',13,1,1,1,1,6,'San Vicente Ferrer',0,0),
 (70,'Charles Kenneath','C','Cabana','Charles',17,1,9,4,1,4,'Berhen sa Fatima',1,1),
 (71,'Alihodin','A','Abdullah','Alihodin',16,1,3,1,1,6,'San Miguel',1,1),
 (72,'Benedict','D','Lloveras','Benedict',13,1,9,5,1,5,'Imacculate Conception (Sion)',1,1),
 (73,'Joseph','M','Ostria','Joseph',15,1,1,11,1,2,'San Vicente Ferrer',0,0),
 (74,'Reymart','P','Saman','Raymart',15,1,3,10,1,8,'San Miguel',0,0),
 (75,'Angelica','L','Lozada','Angelica',16,1,9,6,1,11,'Immaculate Conception (Sion)',1,1),
 (76,'Gretel','M','Camile','Gang',16,1,3,9,1,10,'San Vicente Ferrrer',0,0),
 (77,'Junielyn','J','Gudin','Junielyn',16,1,9,5,1,5,'San Isidro Labrador',1,1),
 (78,'Rey Ann','M','Ipang','John Rey',17,1,1,3,1,12,'San Vicente Ferrer',0,0),
 (79,'Melody','M','Oracion','Melody',15,1,3,8,1,9,'San Miguel',0,0),
 (80,'Junille Joy','J','Gudin','Junille',14,1,9,11,1,2,'San Isidro Labrador II',1,1),
 (81,'Vanessa','M','Dyanaque','Vanessa',19,1,3,6,1,11,'San Vicente Ferrer',0,0),
 (82,'Shaira Mae','M','Cubal','Shaira',16,1,9,10,1,8,'San Isidro Labrador II',1,1),
 (83,'Ryan Delmar','R','Gudin','Ryan',15,1,9,9,1,10,'San Isidro Labrador II',1,1),
 (84,'Ricky Bry','B','Resma','Ricky',17,1,9,8,1,9,'San Isidro Labrador II',1,1),
 (85,'Michelle Ann','V','Lamberte','Michelle',15,1,9,7,1,7,'San Isidro Labrador',1,1),
 (86,'Michelle Ann','V','Lloveras','Michelle',14,1,9,6,1,11,'Berhen sa Fatima',1,1),
 (87,'Jean','M','Rica','Jean',21,1,12,8,1,9,'San Jose',1,1),
 (88,'Remelyn','M','Reloba','Remelyn',19,1,10,9,1,10,'San Jose',1,1),
 (89,'Ryan','M','Anthony','Ryan',18,1,10,7,1,7,'San Jose',1,1),
 (90,'Jhon Rey','M','Antigo','Jhon',17,1,10,10,1,8,'San Vicente Ferrer',1,1),
 (91,'Mariquit','M','Asedilla','Mari',17,1,10,11,1,2,'Berhen sa Kasilak',1,1),
 (92,'Airish','M','Bulasa','Ai',13,1,10,12,1,1,'Mother of Perpetual Help',1,1),
 (93,'Jhon Mark','M','Bulasa','JM',15,1,10,1,1,6,'Mother of Perpetual Help',1,1),
 (94,'Junmar','M','Masas','Benj',17,1,10,10,1,8,'Sto. Nino',1,1),
 (95,'Benjie','M','Hemito','Lito',22,1,8,3,1,12,'San Vicente Ferrer',1,1),
 (96,'Reynell','M','Oliveros','Jess',23,1,8,4,1,4,'San Vicente Ferrer',1,1),
 (97,'Rodel','M','Catubag','Rodz',10,1,10,6,1,11,'San Antonio de Padua',0,1),
 (98,'Eufemio','M','Calunyia','Euf',17,1,10,5,1,5,'San Jose',1,1),
 (99,'Lailah','M','Evardone','Laila',18,1,10,7,1,7,'San Antonio de Padua',0,1),
 (100,'Nino','M','Forones','Ninz',21,1,10,8,1,9,'San Vicente Ferrer',1,1),
 (101,'Peter','M','Hoyohoy','Petz',15,1,10,11,1,2,'Berhen sa Kasilak',1,1),
 (102,'Juvelyn','M','Malucara','Juvey',17,1,10,9,1,10,'Santa Cruz',1,1),
 (103,'Mariam','M','Mendoza','Maiam',15,1,10,10,1,8,'San Antonio de Padua',0,1),
 (104,'Gerald','M','Miane','Erald',14,1,10,11,1,2,'San Atonio de Padua',1,1),
 (105,'Junmar','M','Maningo','Jun Jun',25,1,10,12,1,1,'Sto. Nino',1,1),
 (106,'Charlie','M','Narciso','Charlz',17,1,10,1,1,6,'Sto. Nino',1,1),
 (107,'Junmar','M','Odo','Mar Mar',19,1,10,3,1,12,'Mother of Perpetual Help',1,1),
 (108,'Mario','M','Odo','Marz',14,1,10,4,1,4,'Mother of Perpetual Help',1,1),
 (109,'Jayvee','M','Maglasang','Jayvee',20,1,6,2,1,3,'San Vicente Ferrer',1,1),
 (110,'Benjie','C','Santos','Benj',10,1,6,5,1,5,'San Antonio de Padua',0,1),
 (111,'Arnie','M','Perbandos','Arnz',16,1,10,1,1,6,'Berhen sa Kasilak',1,1),
 (112,'Janine','M','Regatona','Janine',16,1,10,7,1,7,'Berhen sa Kasilak',1,1),
 (113,'Kenneth','M','Salazar','Ken Ken',10,1,10,8,1,9,'Santa Cruz',0,1),
 (114,'Norie Fe','M','Saldana','Norie',16,1,10,9,1,10,'San Antonio de Padua',1,1),
 (115,'Reymar','M','Silagan','Rey',14,1,10,6,1,11,'San Antonio de Padua',1,1),
 (116,'Rey','M','Bandibas','Rey',17,1,6,12,1,1,'Sto. Nino',1,1),
 (117,'Marimar','M','Ubas','Marimar',18,1,6,2,1,3,'Mother of Perpetual Help',1,1),
 (118,'Renato','M','Tortor Jr','Renants',18,1,10,2,1,3,'Santa Cruz',1,1),
 (119,'Marvie','M','Vitor','Marvz',15,1,10,3,1,12,'Santa Cruz',1,1),
 (120,'Jayre','M','Mantinez','Mareal',21,1,8,4,1,4,'Mother of Perpetual Help',1,1),
 (121,'Midael','M','Gaco','Stancio',17,1,8,5,1,5,'San Vicente Ferrer',1,1),
 (122,'Robert Jun','M','Mula','RJ',16,1,10,6,1,11,'Berhen sa Kasilak',1,1),
 (123,'Marte','Lumagod','Lumagod','Ting',17,1,3,8,1,9,'Santisima Trinidad',1,1),
 (124,'Shena','F','Lumagod','Shen',16,1,3,7,1,7,'Santisima Trinidad',1,1),
 (125,'Mary Joy','Fermin','Fermin','Joy',14,1,3,5,1,5,'Santisima Trinidad',1,1),
 (127,'Shaira','F','Timcang','Shai',15,1,3,2,1,3,'Santisima Trinidad',1,1),
 (128,'Jenebeth Flor','S','Pelayo','Betty',16,1,3,3,1,12,'San Miguel',1,0),
 (129,'Mari Joy','M','Wenceslao','Mar',14,1,3,1,1,6,'Santisima Trinidad',0,0),
 (130,'Cristy Ann','M','Timcang','Ann',15,1,3,4,1,4,'Santisima Trinidad',1,1),
 (131,'Welton','B','Barahama','Poy',18,1,3,2,1,3,'Santisima Trinidad',1,0),
 (132,'Mely Jane','M','Rufino','Mely',17,1,3,6,1,11,'San Miguel',1,1),
 (133,'Romelyn','M','Taman','Romelyn',23,1,3,10,1,8,'San Miguel',0,0),
 (134,'Joyce','M','Codizar','Joyce',15,1,3,9,1,10,'Santa Cruz',1,1),
 (135,'Cathlyn','M','Codizar','Cathy',16,1,3,12,1,1,'Santa Cruz',1,1),
 (136,'Charlene','M','Cadelina','Cha',15,1,3,11,1,2,'Santa Cruz',1,0),
 (137,'Angelyn','M','Manumpay','Angel',15,1,3,11,1,2,'Santisima Trinidad',1,1),
 (138,'Gilmalyn','M','Manumpay','Gil',13,1,3,3,1,12,'Santisima Trinidad',1,1),
 (139,'Rhea Mae','M','Manumpay','Ekay',19,1,3,4,1,4,'Santisima Trinidad',1,1),
 (140,'Dave','M','Dagoc','Dave',15,1,3,5,1,5,'Santisima Trinidad',1,1),
 (141,'Christopher','M','Antonio','Chris',16,1,3,10,1,8,'Santisima Trinidad',1,1),
 (142,'Jeson','M','Mepico','Son',16,1,3,6,1,11,'Santisima Trinidad',1,0),
 (143,'Irah Mae','M','Richa','Ira',15,1,3,7,1,7,'Santa Cruz',1,0),
 (144,'Iyah Kaydel','M','Richa','Iyah',14,1,3,8,1,9,'Santa Cruz',1,0),
 (145,'Louie Jay','M','Cabulanan','Dodong',15,1,3,9,1,10,'Santa Cruz',0,0),
 (146,'Jessa','M','Labrador','Jessa',16,1,12,12,1,1,'San Vicente Ferrer',1,1),
 (147,'Aldren','M','Milano','Dren',21,1,12,11,1,2,'San Vicente Ferrer',1,1),
 (148,'Gaye Mark','M','Gallando','Mark',16,1,12,10,1,8,'San Vicente Ferrer',1,1),
 (149,'Jayson','M','Jose','Jay',16,1,12,9,1,10,'San Vicente Ferrer',1,1),
 (150,'Charmaine','M','Rica','Charm',17,1,12,8,1,9,'San Vicente Ferrer',1,1),
 (151,'Danny','M','Antonio','Dann',18,1,12,7,1,7,'San Vicente Ferrer',1,1),
 (152,'Cristian','M','Budas','Cris',18,1,12,2,1,3,'San Vicente Ferrer',1,1),
 (153,'Irish','I','Jose','Irish',20,1,12,3,1,12,'San Vicente Ferrer',1,1),
 (154,'Jessa','M','Capul','Essa',15,1,12,8,1,9,'Sto Nino',1,1),
 (155,'Ivy','M','Viernes','Ivy',13,1,12,7,1,7,'Sto Nino',1,1),
 (156,'Jea Mae','M','Capul','Jea',13,1,12,6,1,11,'Sto Nino',1,1),
 (157,'Regine Diopet','M','Taldante','Gine',15,1,12,5,1,5,'Sto Nino',1,1),
 (158,'Irene','M','Tongcayadan','Rene',16,1,12,4,1,4,'Sagrada Famila',1,1),
 (159,'Shane','M','Claros','Shane',14,1,12,3,1,12,'Sagrada Famila',1,1),
 (160,'Medeth','M','Sonsona','Med',14,1,12,2,1,3,'Sagrada Famila',1,1),
 (161,'Shane','Iglesia','Iglesia','Shan',14,1,12,1,1,6,'Sagrada Famila',1,0),
 (162,'Clarince','Estrara','Estrara','Rince',23,1,12,12,1,1,'Sagrada Famila',1,0),
 (163,'Aljer','M','Gubalani','Alj',23,1,12,11,1,2,'Sagrada Famila',1,0),
 (164,'Antonio','M','Alaba Jr','Anton',23,1,12,10,1,8,'Sagrada Famila',1,0),
 (165,'Asmen','M','Austria','Asme',13,1,12,9,1,10,'Sto. Nino',0,0),
 (166,'Sheena Mae','M','Tanhusay','Sheen',18,1,12,9,1,10,'Inahan sa Kanunayng Panabang',1,1),
 (167,'Donna Lara','M','Supsupan','Lara',16,1,12,8,1,9,'Inahan sa Kanunayng Panabang',1,1),
 (168,'Ryan Jay','Jose','Jose','Ryan',17,1,12,7,1,7,'Inahan sa Kanunayng Panabang',1,1),
 (169,'RubyLito','M','Luchaves','Rubyl',15,1,12,6,1,11,'Inahan sa Kanunayng Panabang',1,1),
 (170,'Rodel John','M','Cole','Odel',16,1,12,5,1,5,'Inahan sa Kanunayng Panabang',1,1),
 (171,'Beverlyn','M','Luchavez','Beverlyn',17,1,12,4,1,4,'Inahan sa Kanunayng Panabang',1,1),
 (172,'Rhea Claire','Claire','Budas','Rhea',15,1,12,1,1,6,'Sto. Nino',1,1),
 (173,'Darlene','M','Nantes','Darl',14,1,7,4,1,4,'San Isidro Labrador',1,1),
 (174,'Jeric','M','Lazarte','Jeric',18,1,7,3,1,12,'San Miguel',1,1),
 (175,'Jouvil','M','Erandio','Jouvil',17,1,7,2,1,3,'San Miguel',1,1),
 (176,'Kathleen','Miguelles','Miguelles','Kathleen',15,1,7,1,1,6,'San Miguel',1,1),
 (177,'Gilbert','M','Reyes','Pao Pao',16,1,7,7,1,7,'San Miguel',1,1),
 (178,'John Mark','M','Gevila','JM',15,1,7,9,1,10,'San Miguel',1,1),
 (179,'Angelic','M','Alcantara','Gelique',15,1,7,10,1,8,'San Miguel',1,1),
 (180,'Ian','M','Respuesto','Ian',13,1,7,11,1,2,'San Miguel',1,1),
 (181,'Jericar','M','Reyes','Cloe',18,1,7,8,1,9,'San Vicente Ferrer',1,1),
 (182,'Angie','M','Lacson','Anny',17,1,7,7,1,7,'San Vicente Ferrer',1,1),
 (183,'Avelle Jay','M','Montilla','Avelle',13,1,12,6,1,11,'San Vicente Ferrer',1,1),
 (184,'Keth Wilson','M','Del Campo','Keith',15,1,7,5,1,5,'San Vicente Ferrer',1,1),
 (185,'Cherry Rose','M','Abas','Caissance',16,1,7,4,1,4,'San Vicente Ferrer',1,1),
 (186,'Dimple Eve','L','Malita','Gagay',17,1,12,3,1,12,'Sto Rosario',1,1),
 (187,'James Billy','M','Erandio','James',19,1,7,2,1,3,'San Miguel',1,1),
 (188,'Michelle Mae','Michelle','Lingayao','Jeric',16,1,12,1,1,6,'San Miguel',1,1),
 (189,'Lovely','M','Tongcal','Lhublee',17,1,7,5,1,5,'San Labrador',1,1),
 (190,'Bea Angele','M','Diohang','Bea',17,1,7,12,1,1,'San Labrador',1,1),
 (191,'Elyza Marriane','M','Palcaio','Elay',14,1,7,12,1,1,'San Miguel',1,1),
 (192,'Marco','M','Dela Cruz','Mico',17,1,7,8,1,9,'Sto Rosario',1,1),
 (193,'Jokarno','M','Asio','Jok Jok',21,1,7,6,1,11,'Sto Rosario',1,0),
 (194,'Angel Beb','M','Serondo','Angel',17,1,8,2,1,3,'Immaculada',1,1),
 (195,'Maricar','M','Legaspi','Maricar',17,1,8,1,1,6,'Berhin sa Kasilak',1,0),
 (196,'Bryan','M','Anober','Bryan',13,1,8,12,1,1,'Berhin sa Kasilak',1,0),
 (197,'Estefene','M','Bumagat','Steph',23,1,8,11,1,2,'Berhin sa Kasilak',1,0),
 (198,'Charlie','M','Remerata','Charlie',17,1,8,10,1,8,'Berhin sa Kasilak',1,0),
 (199,'Rolito','M','Pacquiao','Rotz',21,1,8,9,1,10,'Berhin sa Kasilak',1,0),
 (200,'Cherry','M','Pacquiao','Cherry',15,1,8,8,1,9,'Berhin sa Kasilak',1,0),
 (201,'Anna Marie','M','Gaco','Anna',13,1,8,7,1,7,'San Isidro Labrador',1,0),
 (202,'Mitch Mary','M','Tangcogo','Mitch',14,1,8,6,1,11,'San Isidro Labrador',1,0),
 (203,'Richard','M','Alferez','Rich',18,1,8,4,1,4,'San Isidro Labrador',1,0),
 (204,'Romeo','M','Seballa','Romeo',17,1,8,9,1,10,'Immaculada',1,0),
 (205,'Archie','M','Remoreras','Archie',22,1,8,10,1,8,'San Isidro Labrador',1,0),
 (206,'Christian','M','Sembrino','Christian',14,1,8,11,1,2,'San Isidro Labrador',1,0),
 (207,'Antonio','M','Negro Jr','Anton',21,1,8,12,1,1,'San Isidro Labrador',1,0),
 (208,'Samuel','M','Negro','Sam',19,1,8,5,1,5,'San Isidro Labrador',1,0),
 (209,'Kerk Johnson','M','Gujol','KJ',18,1,8,1,1,6,'San Isidro Labrador',1,0),
 (210,'Christopher','Gaco','Gaco','Chris',13,1,8,2,1,3,'San Isidro Labrador',1,0),
 (211,'Lorence','M','Marimon','Lorence',14,1,8,3,1,12,'Berhen sa Kasilak',1,0),
 (212,'Jenelyn','M','Egona','Jen',15,1,8,3,1,12,'Immaculada',1,0),
 (213,'Analyn','Asanero','Asanero','Analyn',19,1,9,10,1,12,'Berhen sa Fatima',1,1),
 (214,'Lorez','M','Tidra','Lorez',15,1,4,2,1,1,'Fatima',1,1),
 (215,'Chaterie','M','Babaduan','Chaterie',15,1,4,12,1,2,'Fatima',1,1),
 (216,'Maria Lu','Babatuan','Babatuan','Maria',15,1,4,1,1,3,'Fatima',1,1),
 (217,'Edlyn','P','Otida','Edlyn',14,1,4,7,1,4,'Fatima',1,1),
 (218,'Joseph','M','Bomedianco','Joseph',28,1,4,2,1,5,'Fatima',1,1),
 (219,'Wilbert','M','Comeria','Joseph',16,1,4,4,1,6,'Fatima',1,1),
 (220,'Astephany','M','Sumalinog','Astephany',15,1,4,1,1,7,'Fatima',1,1),
 (221,'Sarahgen','M','Inocilla','Sarah',15,1,4,6,1,8,'Sto Nino',1,1),
 (222,'Jestoni','M','Sumalinog','Jes',19,1,4,12,1,9,'Sto Nino',1,1),
 (223,'Roland','M','Sumalinog','Rol',15,1,4,11,1,10,'Sto Nino',1,1),
 (224,'Joseph','M','Sumalingo','Jo',15,1,4,10,1,11,'Sto Nino',1,1),
 (225,'Cheryl','M','Pastrombon','Cher',15,1,4,8,1,12,'Sto Nino',1,1),
 (226,'Rosejeah Mae','M','Dualan','Rose',15,1,4,5,1,1,'Sto Nino',1,1),
 (227,'Nicar','Toralba','Toralba','Micah',15,1,4,3,1,2,'Sto Nino',1,1),
 (228,'Jesriel','M','Canete','Jes',16,1,4,3,1,3,'Sto Nino',1,1),
 (229,'Armando','M','Alabastro','Armand',15,1,4,11,1,4,'Sto Jose',1,1),
 (230,'Lemuel','M','Pescones','Lemuel',18,1,4,9,1,5,'San Jose',1,1),
 (231,'Jimboy','Telempros','Telempros','Telempros',17,1,2,4,1,10,'Bandera',1,1),
 (232,'Ruby Jane','Dela Cernas','Dela Cernas','Ruby',21,1,2,5,1,11,'Bandera',1,1),
 (233,'Maria Rizza','Bereso','Bereso','Maria',14,1,2,6,1,12,'Bandera',1,1),
 (234,'Roselyn','M','Homogdon','Rose',16,1,2,12,1,1,'Bandera',1,1),
 (235,'Melen','M','Gerondo','Melen',15,1,2,7,1,2,'Bandera',1,1),
 (236,'Joel','Corbita','Corbita','Joel',14,1,3,8,1,11,'San Miguel',1,1),
 (237,'Yoldie','M','Lecriones','Yoldie',10,1,6,9,1,4,'Mother of Perpetual Help',1,1),
 (238,'Joeffrey','M','Perez','Joeffrey',10,1,6,10,1,5,'Mother of Perpetual Help',0,0),
 (239,'Roselyn','M','Ligaray','Rose',10,1,6,11,1,6,'Mother of Perpetual Help',0,0),
 (240,'Jellyfe','M','Mendez','Jellyfe',10,1,6,6,1,7,'Mother of Perpetual Help',0,0),
 (241,'Jendelyn','M','Maglasang','Jendelyn',10,1,6,7,1,8,'Mother of Perpetual Help',0,0),
 (242,'Giovanie','M','Tidalgo','Giovanie',10,1,6,8,1,9,'Mother of Perpetual Help',0,0),
 (243,'Yra','S','Garcia','Yra',10,1,6,9,1,10,'Mother of Perpetual Help',0,0),
 (244,'Kimberly','M','Bandibas','Kimberly',10,1,6,10,1,11,'Mother of Perpetual Help',0,0),
 (245,'Junrey','M','Clavelliass','Junrey',10,1,6,11,1,12,'Mother of Perpetual Help',0,0),
 (246,'Stephen John','M','Clavecillas','Stephen',10,1,6,12,1,1,'Mother of Perpetual Help',0,0),
 (247,'Jay','M','Bandibas','Jay',10,1,6,1,1,2,'Mother of Perpetual Help',0,0),
 (248,'Kimberly','M','Pabiran','Kim',10,1,6,2,1,3,'Mother of Perpetual Help',0,0),
 (249,'Gelyn','T','Adante','Gelyn',10,1,6,3,1,4,'Mother of Perpetual Help',0,0),
 (250,'Morillo','M','Ubas','Morillo',10,1,6,4,1,5,'Mother of Perpetual Help',0,0),
 (251,'Dexter','M','Elicano','Dexter',10,1,6,5,1,6,'Mother of Perpetual Help',0,0),
 (252,'Gil','M','Tidalgo','Gil',10,1,6,6,1,7,'Mother of Perpetual Help',0,0),
 (253,'Kenneth','Laquina','Laquina','Kenneth',18,1,5,1,1,1,'Nuestra Senora del Pilar',0,0),
 (254,'Stephanie','Aliwalas','Aliwalas','Steph',10,1,5,2,1,2,'Nuestra Senora del Pilar',0,0),
 (255,'Pamela','Tubigan','Tubigan','Pam',10,1,5,3,1,3,'Nuestra Senora del Pilar',0,0),
 (256,'Yzabelle','Mijares','Mijares','Yzabelle',10,1,5,4,1,4,'Nuestra Senora del Pilar',0,0),
 (257,'Marie','Alejandro','Alejandro','Marie',10,1,5,5,1,5,'Nuestra Senora del Pilar',0,0),
 (258,'Aljun','Getigan','Getigan','Aljun',10,1,5,6,1,6,'Nuestra Senora del Pilar',0,0),
 (259,'Jay Ann','Gatigan','Gatigan','Jay',10,1,5,7,1,7,'Nuestra Senora del Pilar',0,0),
 (260,'Jhon Lloyd','Getigan','Getigan','Jhon',10,1,5,8,1,8,'Nuestra Senora del Pilar',0,0),
 (261,'Janice','Zipagan','Zipagan','Janice',10,1,5,9,1,9,'Nuestra Senora del Pilar',0,0),
 (262,'Mary Jay','Zipagan','Zipagan','Mary',10,1,5,10,1,10,'Nuestra Senora del Pilar',0,0),
 (263,'Arnel','Takyawan','Takyawan','Arnel',10,1,5,11,1,11,'Nuestra Senora del Pilar',0,0),
 (264,'Roberto','Zipagan','Zipagan','Robert',10,1,5,12,1,12,'Nuestra Senora del Pilar',0,0),
 (265,'Antonio','Arsen','Arsen','Anton',10,1,5,1,1,1,'Nuestra Senora del Pilar',0,0),
 (266,'Melanie Jean','Basalo','Basalo','Melanie',10,1,5,2,1,2,'Nuestra Senora del Pilar',0,0),
 (267,'Jhony','Parton','Parton','Jhony',10,1,5,3,1,3,'Nuestra Senora del Pilar',0,0),
 (268,'Tonie','Bambalan','Bambalan','Tonie',10,1,5,4,1,4,'Nuestra Senora del Pilar',0,0),
 (269,'Angelie','Maningao','Maningao','Angie',10,1,5,5,1,5,'Nuestra Senora del Pilar',0,0),
 (270,'Aiziel','M','Entor','Aiziel',10,1,11,1,1,1,'GKK Tad Tad',0,0),
 (271,'Alraniel','M','Erbito','Alraniel',10,1,11,2,1,2,'GKK Tad Tad',0,0),
 (272,'Alvin','M','Estrara','Alvin',10,1,11,3,1,3,'GKK Tad Tad',0,0),
 (273,'Aljay','M','Oros','Aljay',10,1,11,4,1,4,'GKK Tad Tad',0,0),
 (274,'Abegail','M','Plenos','Abegail',10,1,11,5,1,5,'GKK Tad Tad',0,0),
 (275,'Brylle','M','Ronsable','Brylle',10,1,11,6,1,6,'GKK Tad Tad',0,0),
 (276,'Generose','Bacoco','Bacoco','Generose',10,1,11,7,1,7,'GKK Tad Tad',0,0),
 (277,'Jovelyn','M','Masucat','Jovelyn',10,1,11,8,1,8,'GKK Tad Tad',0,0),
 (278,'Kristel','M','Quezada','Kristel',10,1,11,9,1,9,'GKK Tad Tad',0,0),
 (279,'Mark Lester','M','Quinanol','Mark',10,1,11,10,1,10,'GKK Tad Tad',0,0),
 (280,'Pee Jay','M','Quinanola','PJ',10,1,11,11,1,11,'GKK Tad Tad',0,0),
 (281,'Richard','M','Plenos','Richard',10,1,11,12,1,12,'GKK Tad Tad',0,0),
 (282,'Rovelyn','M','Paquibot','Rovelyn',10,1,11,1,1,1,'GKK Tad Tad',0,0),
 (283,'Charles','M','Pancho','Charles',10,1,11,2,1,2,'GKK Tad Tad',0,0),
 (284,'Shiela Mae','Quinanola','Quinanola','Shiela',10,1,11,3,1,3,'GKK Tad Tad',0,0),
 (285,'Lalang','M','Guitierrez','Lalang',10,1,11,4,1,4,'GKK Tad Tad',0,0),
 (286,'Shiela Mae','M','Oliveros','Shiela',10,1,11,5,1,5,'GKK Tad Tad',0,0),
 (287,'Rejun','M','Tamar','Rejun',10,1,11,6,1,6,'GKK Tad Tad',0,0),
 (288,'Jaymar','M','Ugdoracion','Jaymar',10,1,11,7,1,7,'GKK Tad Tad',0,0),
 (289,'Marie Amor','M','Ugdoracion','Marie',10,1,11,8,1,8,'GKK Tad Tad',0,0),
 (290,'Mariel','M','Barael','Mariel',10,1,11,9,1,9,'GKK Tad Tad',0,0),
 (291,'Dariel','M','Ronsable','Dariel',10,1,11,10,1,10,'GKK Tad Tad',0,0);
/*!40000 ALTER TABLE `participant` ENABLE KEYS */;


--
-- Definition of table `team`
--

DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `teamID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `teamName` varchar(45) NOT NULL,
  `yearID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`teamID`),
  KEY `FK_team_1` (`yearID`),
  CONSTRAINT `FK_team_1` FOREIGN KEY (`yearID`) REFERENCES `year` (`yearID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `team`
--

/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` (`teamID`,`teamName`,`yearID`) VALUES 
 (1,'Colossians',1),
 (2,'Ephesians',1),
 (3,'First Corianthians',1),
 (4,'First Thesalonicans',1),
 (5,'First Timothy',1),
 (6,'Galatians',1),
 (7,'Philemons',1),
 (8,'Philippians',1),
 (9,'Second Corinthians',1),
 (10,'Second Thesalonicans',1),
 (11,'Second Timothy',1),
 (12,'Titus',1);
/*!40000 ALTER TABLE `team` ENABLE KEYS */;


--
-- Definition of table `type`
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `typeID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `typeName` varchar(45) NOT NULL,
  PRIMARY KEY (`typeID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type`
--

/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` (`typeID`,`typeName`) VALUES 
 (1,'Participant'),
 (2,'Resource Personnel'),
 (3,'GKK Leader');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;


--
-- Definition of table `year`
--

DROP TABLE IF EXISTS `year`;
CREATE TABLE `year` (
  `yearID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `year` int(10) unsigned NOT NULL,
  `status` tinyint(3) unsigned NOT NULL,
  `dateFrom` datetime NOT NULL,
  `dateTo` datetime NOT NULL,
  PRIMARY KEY (`yearID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `year`
--

/*!40000 ALTER TABLE `year` DISABLE KEYS */;
INSERT INTO `year` (`yearID`,`year`,`status`,`dateFrom`,`dateTo`) VALUES 
 (1,2011,1,'2011-05-12 00:00:00','2011-05-15 00:00:00');
/*!40000 ALTER TABLE `year` ENABLE KEYS */;


--
-- Definition of procedure `addParticipant`
--

DROP PROCEDURE IF EXISTS `addParticipant`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addParticipant`(first_name VARCHAR(45), middle_name VARCHAR(45),
  last_name VARCHAR(45), nick_name VARCHAR(45), par_age INTEGER, type_id INTEGER, district_id INTEGER, year_id INTEGER,
  gkk_field VARCHAR(100), parental_consent TINYINT(3), registration_fee TINYINT(3))
BEGIN
  DECLARE team_id INTEGER;
  DECLARE next_team_id INTEGER;
  DECLARE team_name VARCHAR(45);
  DECLARE min_color_id INTEGER;
  DECLARE min_team_id INTEGER;
  DECLARE color_id INTEGER;
  DECLARE next_color_id INTEGER;
  DECLARE participant_id INTEGER;
  DECLARE color_name VARCHAR(45);
  DECLARE par_type_id INTEGER;

  SELECT typeID INTO par_type_id FROM type WHERE typeName LIKE 'Participant';
  SELECT MIN(teamID)   INTO  min_team_id FROM team WHERE yearID = year_id;
  SELECT MIN(colorID)  INTO  min_color_id FROM IDcolor WHERE yearID = year_id;
  SELECT MAX(participantID)   INTO  participant_id FROM participant WHERE yearID = year_id AND districtID = district_id;
  SELECT teamID INTO team_id FROM participant WHERE participantID = participant_id;
  SELECT colorID INTO color_id FROM participant WHERE participantID = participant_id;
  SELECT MIN(teamID)   INTO next_team_id FROM team WHERE yearID = year_id AND teamID > team_id;
  SELECT MIN(colorID)  INTO next_color_id  FROM IDcolor WHERE yearID = year_id AND colorID > color_id;

  IF next_team_id IS NULL THEN
    SET next_team_id = min_team_id;
  END IF;

  IF next_color_id IS NULL THEN
    SET next_color_id = min_color_id;
  END IF;


  IF par_type_id = type_id THEN
    INSERT INTO participant(firstName,middleName,lastName,nickName,age,districtID,typeID,yearID,teamID,colorID,gkk,registrationFee,parentalConsent)
    VALUES(first_name,middle_name,last_name,nick_name,par_age,district_id,type_id,year_id,next_team_id,next_color_id,gkk_field,registration_fee,parental_consent);
  ELSE
    INSERT INTO participant(firstName,middleName,lastName,nickName,age,districtID,typeID,yearID,gkk,registrationFee,parentalConsent)
    VALUES(first_name,middle_name,last_name,nick_name,par_age,district_id,type_id,year_id,gkk_field,registration_fee,parental_consent);
  END IF;



  SELECT teamName INTO team_name FROM team WHERE teamID = next_team_id;
  SELECT colorName INTO color_name FROM IDColor WHERE colorID = next_color_id;

  SELECT participantID, next_team_id, team_name,next_color_id,color_name FROM participant WHERE firstName = first_name AND lastName = last_name;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `editParticipant`
--

DROP PROCEDURE IF EXISTS `editParticipant`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `editParticipant`(first_name VARCHAR(45), middle_name VARCHAR(45),
  last_name VARCHAR(45), nick_name VARCHAR(45), par_age INTEGER, type_id INTEGER, district_id INTEGER, year_id INTEGER,
  gkk_field VARCHAR(100), parental_consent TINYINT(3), registration_fee TINYINT(3))
BEGIN
  DECLARE team_id INTEGER;
  DECLARE next_team_id INTEGER;
  DECLARE team_name VARCHAR(45);
  DECLARE min_color_id INTEGER;
  DECLARE min_team_id INTEGER;
  DECLARE color_id INTEGER;
  DECLARE next_color_id INTEGER;
  DECLARE participant_id INTEGER;
  DECLARE color_name VARCHAR(45);
  DECLARE par_type_id INTEGER;

  SELECT typeID INTO par_type_id FROM type WHERE typeName LIKE 'Participant';
  SELECT MIN(teamID)   INTO  min_team_id FROM team WHERE yearID = year_id;
  SELECT MIN(colorID)  INTO  min_color_id FROM IDcolor WHERE yearID = year_id;
  SELECT MAX(participantID)   INTO  participant_id FROM participant WHERE yearID = year_id AND districtID = district_id;
  SELECT teamID INTO team_id FROM participant WHERE participantID = participant_id;
  SELECT colorID INTO color_id FROM participant WHERE participantID = participant_id;
  SELECT MIN(teamID)   INTO next_team_id FROM team WHERE yearID = year_id AND teamID > team_id;
  SELECT MIN(colorID)  INTO next_color_id  FROM IDcolor WHERE yearID = year_id AND colorID > color_id;

  IF next_team_id IS NULL THEN
    SET next_team_id = min_team_id;
  END IF;

  IF next_color_id IS NULL THEN
    SET next_color_id = min_color_id;
  END IF;


  IF par_type_id = type_id THEN
    UPDATE participant SET firstName = first_name, middleName = middle_name ,lastName = last_name,nickName = nick_name, age = age_field,
    districtID = district_id,typeID = type_id,yearID = year_id, teamID = next_team_id, colorID = next_color_id,
    gkk = gkk_field, registrationFee = registration_fee , parentalConsent = parent_consent;
  ELSE
    UPDATE participant SET firstName = first_name, middleName = middle_name ,lastName = last_name,nickName = nick_name, age = age_field,
    districtID = district_id,typeID = type_id,yearID = year_id,
    gkk = gkk_field, registrationFee = registration_fee , parentalConsent = parent_consent;
  END IF;


  SELECT teamName INTO team_name FROM team WHERE teamID = next_team_id;
  SELECT colorName INTO color_name FROM IDColor WHERE colorID = next_color_id;

  SELECT participantID, next_team_id, team_name,next_color_id,color_name FROM participant WHERE firstName = first_name AND lastName = last_name;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
