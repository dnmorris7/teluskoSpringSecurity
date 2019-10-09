CREATE DATABASE `teluskosecapp`;

USE `teluskosecapp`;

DROP TABLE IF EXISTS teluskoSecApp.users;
CREATE TABLE users(
user_id int(4) PRIMARY KEY,
 user_name varchar(50) NOT NULL,
 user_pwd varchar(50) NOT NULL
 );
