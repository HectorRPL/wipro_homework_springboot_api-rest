CREATE SCHEMA `wipro_homework_dev` ;

CREATE TABLE `wipro_homework_dev`.`employees` (
`id` INT NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(45) NOT NULL,
`last_name` VARCHAR(45) NOT NULL,
`email` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`)
);
