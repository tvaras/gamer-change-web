/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.25-log : Database - bdejemplojstl
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bdejemplojstl` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bdejemplojstl`;


DROP TABLE IF EXISTS `perfil`;

CREATE TABLE `perfil` (
  `codigo_perfil` int(11) NOT NULL,
  `nombre_perfil` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`codigo_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `perfil` */

insert  into `perfil`(`codigo_perfil`,`nombre_perfil`) values (1,'Administrador'),(2,'Usuario'),(3,'Alumno');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `login_usuario` varchar(15) DEFAULT NULL,
  `pass_usuario` varchar(10) DEFAULT NULL,
  `nombre_usuario` varchar(15) DEFAULT NULL,
  `apellido_usuario` varchar(25) DEFAULT NULL,
  `correo_usuario` varchar(50) DEFAULT NULL,
  `edad_usuario` int(11) DEFAULT NULL,
  `codigo_perfil` int(11) DEFAULT NULL,
  `fechaNacimiento_usuario` date DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `perfil_codigo` (`codigo_perfil`),
  CONSTRAINT `perfil_codigo` FOREIGN KEY (`codigo_perfil`) REFERENCES `perfil` (`codigo_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usuario` */

insert  into `usuario`(`id_usuario`,`login_usuario`,`pass_usuario`,`nombre_usuario`,`apellido_usuario`,`correo_usuario`,`edad_usuario`,`codigo_perfil`,`fechaNacimiento_usuario`) values (1,'admin','123','123','123','123@gmail.com',18,1,'2014-12-23'),(2,'alumno','123','alumno','123','alumno@alumnos.duoc.cl',18,3,'2016-09-12');

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `codigo_menu` int(11) NOT NULL,
  `nombre_menu` varchar(50) DEFAULT NULL,
  `padre_menu` int(11) DEFAULT NULL,
  `destino_menu` varchar(250) DEFAULT NULL,
  `perfil_codigo` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_menu`),
  KEY `perfil_codigo` (`perfil_codigo`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`perfil_codigo`) REFERENCES `perfil` (`codigo_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menu` */


/*Table structure for table `menu` */


insert  into `menu`(`codigo_menu`,`nombre_menu`,`padre_menu`,`destino_menu`,`perfil_codigo`) values 
(1,'Home',0,NULL,1),(2,'Materia JSTL',0,NULL,1),(3,'Mantenedores',0,'',1),(4,'Definiciones',2,'DefinicionesJSTL.jsp',1),
(5,'Mantenedor Perfil',3,'MantenedorPerfil.jsp',1),(6,'Ejemplos JSTL',2,'EjemplosJSTL.jsp',1),
(7,'Pagina Home',1,'Home.jsp',1),(8,'Consultas ',0,NULL,1),(9,'Home',0,NULL,3),(10,'Materia JSTL',0,NULL,3),
(11,'Pagina Home',9,'Home.jsp',3),(12,'Definiciones',10,'DefinicionesJSTL.jsp',3),
(13,'Ejemplos JSTL',10,'EjemplosJSTL.jsp',3),
(14,'Ingresar Juego',0,'ingresar-juego.html',1),
(15,'Ingresar Juego',0,'ingresar-juego.html',3);

/*Table structure for table `consola` */

DROP TABLE IF EXISTS `consola`;

CREATE TABLE `consola` (
  `id_consola` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(35) NOT NULL,
  PRIMARY KEY (`id_consola`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `consola` */

insert into `consola`(`descripcion`) values ('PS4'), ('PS3'), ('PC'), ('XBOX ONE'), ('XBOX 360'), ('NINTENDO SWITCH'), ('WII U'), ('NINTENDO 3DS'), ('SUPER NINTENDO');


/*Table structure for table `tiempo_uso` */

DROP TABLE IF EXISTS `tiempo_uso`;

CREATE TABLE `tiempo_uso` (
  `id_tiempo_uso` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(35) NOT NULL,
  PRIMARY KEY (`id_tiempo_uso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tiempo_uso` */

insert into `tiempo_uso`(`descripcion`) values ('0 A 3 MESES'), ('3 A 6 MESES'), ('6 A 12 MESES'), ('MÁS DE 1 AÑO');

/*Table structure for table `estado_juego` */

DROP TABLE IF EXISTS `estado_juego`;

CREATE TABLE `estado_juego` (
  `id_estado_juego` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(35) NOT NULL,
  PRIMARY KEY (`id_estado_juego`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `estado_juego` */

insert into `estado_juego`(`descripcion`) values ('10/10'), ('9/10'), ('8/10'), ('7/10'), ('6/10');

/*Table structure for table `juego` */

DROP TABLE IF EXISTS `juego`;

CREATE TABLE `juego` (
  `id_juego` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_creacion` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
  `nombre` varchar(100) NOT NULL,
  `id_consola` int(11) NOT NULL,
  `id_tiempo_uso` int(11) NOT NULL,
  `id_estado_juego` int(11) NOT NULL,
  `comentario` varchar(500),
  `intercambiado` BIT DEFAULT 0,
  `fecha_intercambio` TIMESTAMP,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_estado_juego`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `juego` */

commit;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
