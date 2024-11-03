-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
-- Host: 127.0.0.1    Database: supplytracker
-- Server version5.7.24
--
-- Table structure for table registration
DROP TABLE IF EXISTS registration;
CREATE TABLE registration (
user_name varchar(16) NOT NULL,
email varchar(255) DEFAULT NULL,
password varchar(32) NOT NULL,
create_time timestamp NULL DEFAULT CURRENT_TIMESTAMP,
id bigint(45) NOT NULL AUTO_INCREMENT,
first_name varchar(45) DEFAULT NULL,
last_name varchar(45) DEFAULT NULL,
phone varchar(45) DEFAULT NULL,
PRIMARY KEY (id)) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
--
-- Dumping data for table registration
LOCK TABLES registration WRITE;
INSERT INTO registration VALUES ('jrinehart12345','jrinehart1@my.gcu.edu','Passwordisalwayspassword','2024-11-01 22:47:57',1,'Justin','Rinehart','5204402425');
--
-- Table structure for table product
DROP TABLE IF EXISTS product;
CREATE TABLE product (
name varchar(50) NOT NULL,
price double NOT NULL,
description varchar(5000) NOT NULL,
id int NOT NULL AUTO_INCREMENT,
qty int NOT NULL,
vendor varchar(50) NOT NULL,
category varchar(50) NOT NULL,
reorder_point int NOT NULL,
reorder_amt int NOT NULL,
cost double NOT NULL,
PRIMARY KEY (id)) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
--
-- Dumping data for table product
LOCK TABLES product WRITE;
INSERT INTO product VALUES ('example product name', 12.34, 'example product description', 1, 30, 'example vendor', 'example category', 10, 50, 10.99);

