CREATE USER 'karma'@'localhost' IDENTIFIED BY 'karma';

CREATE DATABASE gema;

GRANT ALL PRIVILEGES ON * . * TO 'karma'@'localhost';
FLUSH PRIVILEGES;

USE gema;