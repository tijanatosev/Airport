BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `Ticket` (
	`id_ticket`	INTEGER NOT NULL,
	`company`	TEXT NOT NULL,
	`id_plane`	INTEGER NOT NULL,
	PRIMARY KEY(`id_ticket`)
);
INSERT INTO `Ticket` VALUES (1,'LondonAirlines',1);
INSERT INTO `Ticket` VALUES (2,'LondonAirlines',1);
INSERT INTO `Ticket` VALUES (3,'LondonAirlines',1);
INSERT INTO `Ticket` VALUES (4,'LondonAirlines',1);
INSERT INTO `Ticket` VALUES (5,'LondonAirlines',2);
INSERT INTO `Ticket` VALUES (6,'LondonAirlines',2);
INSERT INTO `Ticket` VALUES (7,'ParisAirlines',5);
INSERT INTO `Ticket` VALUES (8,'ParisAirlines',5);
INSERT INTO `Ticket` VALUES (9,'RomeAirlines',4);
INSERT INTO `Ticket` VALUES (10,'RomeAirlines',3);
CREATE TABLE IF NOT EXISTS `Passenger` (
	`id_passenger`	INTEGER NOT NULL,
	`name`	TEXT NOT NULL,
	`luggage`	REAL NOT NULL,
	`seat`	INTEGER NOT NULL,
	`id_ticket`	INTEGER NOT NULL,
	`id_plane`	INTEGER NOT NULL,
	FOREIGN KEY(`id_ticket`) REFERENCES `Ticket`(`id_ticket`) ON DELETE CASCADE,
	PRIMARY KEY(`id_passenger`),
	FOREIGN KEY(`id_plane`) REFERENCES `Airplane`(`id_plane`) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS `Flight` (
	`id_flight`	INTEGER NOT NULL,
	`fromCity`	TEXT NOT NULL,
	`toCity`	TEXT NOT NULL,
	`timeExp`	TEXT NOT NULL,
	`pDay`	INTEGER NOT NULL,
	`pMonth`	INTEGER NOT NULL,
	`pYear`	INTEGER NOT NULL,
	`ind`	INTEGER NOT NULL,
	`status`	INTEGER NOT NULL,
	`gate`	INTEGER NOT NULL,
	`id_airport`	INTEGER NOT NULL,
	PRIMARY KEY(`id_flight`)
);
INSERT INTO `Flight` VALUES (1,'London','Frankfurt','13:30',28,7,2019,0,0,12,6);
INSERT INTO `Flight` VALUES (2,'Paris','Belgrade','13:40',28,7,2019,1,4,8,3);
INSERT INTO `Flight` VALUES (3,'Rome','Barselona','09:30',28,7,2019,0,2,23,4);
INSERT INTO `Flight` VALUES (4,'Rome','Belgrade','18:00',28,7,2019,0,2,14,4);
INSERT INTO `Flight` VALUES (5,'London','Frankfurt','15:35',28,7,2019,0,4,8,6);
CREATE TABLE IF NOT EXISTS `Airport` (
	`id_airport`	INTEGER NOT NULL,
	`numOfGates`	INTEGER NOT NULL,
	`name`	TEXT NOT NULL,
	`city`	TEXT NOT NULL,
	PRIMARY KEY(`id_airport`)
);
INSERT INTO `Airport` VALUES (1,60,'Frankfurt','Frankfurt');
INSERT INTO `Airport` VALUES (2,30,'Paris','Paris');
INSERT INTO `Airport` VALUES (3,15,'Belgrade','Belgrade');
INSERT INTO `Airport` VALUES (4,45,'Rome','Rome');
INSERT INTO `Airport` VALUES (5,40,'Barselona','Barselona');
INSERT INTO `Airport` VALUES (6,38,'London','London');
CREATE TABLE IF NOT EXISTS `Airplane` (
	`id_plane`	INTEGER NOT NULL,
	`numOfSeats`	INTEGER NOT NULL,
	`company`	TEXT NOT NULL,
	`id_airport`	INTEGER NOT NULL,
	`id_flight`	INTEGER NOT NULL,
	PRIMARY KEY(`id_plane`),
	FOREIGN KEY(`id_flight`) REFERENCES `Flight`(`id_flight`) ON DELETE CASCADE,
	FOREIGN KEY(`id_airport`) REFERENCES `Airport`(`id_airport`) ON DELETE CASCADE
);
INSERT INTO `Airplane` VALUES (1,100,'LondonAirlines',6,1);
INSERT INTO `Airplane` VALUES (2,100,'LondonAirlines',6,5);
INSERT INTO `Airplane` VALUES (3,80,'RomeAirlines',4,3);
INSERT INTO `Airplane` VALUES (4,120,'RomeAirlines',4,4);
INSERT INTO `Airplane` VALUES (5,140,'ParisAirlines',3,2);
COMMIT;
