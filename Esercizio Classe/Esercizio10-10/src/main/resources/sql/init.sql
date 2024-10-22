CREATE DATABASE db_Esercizio10_10;

CREATE TABLE tb_course (
  id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name_course` varchar(255) NOT NULL,
   );

CREATE TABLE tb_student(
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `fullname` varchar(255) NOT NULL,
  `age` INT NOT NULL,
  `id_course` INT NOT NULL,
  FOREIGN KEY `course_fk`(`id_course`),
  CONSTRAINT course_fk FOREIGN KEY (`id_course`) REFERENCES `tb_course` (`id`)
);