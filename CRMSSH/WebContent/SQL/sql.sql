/*
SQLyog Ultimate v8.8 
MySQL - 5.7.17-log : Database - crm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crm` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `crm`;

/*Table structure for table `t_customer` */

DROP TABLE IF EXISTS `t_customer`;

CREATE TABLE `t_customer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `custName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `custSource` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `custPhone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `custMobile` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `custLevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FKo6oqtbbjmu6890to85xbpymcd` (`custLevel`),
  CONSTRAINT `FKo6oqtbbjmu6890to85xbpymcd` FOREIGN KEY (`custLevel`) REFERENCES `t_dict` (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_customer` */

insert  into `t_customer`(`cid`,`custName`,`custSource`,`custPhone`,`custMobile`,`custLevel`) values (1,'百度','新闻','13233','556989',3),(2,'阿里巴巴','网络','5698','65655',2),(3,'京东','网络','123','995',1),(4,'唯品会','网络','596','56556',2);

/*Table structure for table `t_dict` */

DROP TABLE IF EXISTS `t_dict`;

CREATE TABLE `t_dict` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_dict` */

insert  into `t_dict`(`did`,`dname`) values (1,'vip客户'),(2,'普通客户'),(3,'超级管理员');

/*Table structure for table `t_linkman` */

DROP TABLE IF EXISTS `t_linkman`;

CREATE TABLE `t_linkman` (
  `linkid` int(11) NOT NULL AUTO_INCREMENT,
  `linkName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `linkGender` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `linkPhone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `linkMobile` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `clid` int(11) DEFAULT NULL,
  PRIMARY KEY (`linkid`),
  KEY `FKjtgu0oocf35ij4fmulu123vwk` (`clid`),
  CONSTRAINT `FKjtgu0oocf35ij4fmulu123vwk` FOREIGN KEY (`clid`) REFERENCES `t_customer` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_linkman` */

insert  into `t_linkman`(`linkid`,`linkName`,`linkGender`,`linkPhone`,`linkMobile`,`clid`) values (1,'小杨','男','656556','89898',1),(2,'rose','女','654545','98889',4),(5,'小丽','女','12356','595988',1),(6,'Jim','男','12333','8989595',1);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_user` */

insert  into `t_user`(`uid`,`username`,`password`,`address`) values (1,'Tom','123','日本'),(2,'Rose','456','美国'),(3,'Jim','569','英国'),(4,'John','693','法国');

/*Table structure for table `t_visit` */

DROP TABLE IF EXISTS `t_visit`;

CREATE TABLE `t_visit` (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `vaddress` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `vcontent` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `uvid` int(11) DEFAULT NULL,
  `cvid` int(11) DEFAULT NULL,
  PRIMARY KEY (`vid`),
  KEY `FKnbsiiqbdcpvtugygwe4vj42s0` (`uvid`),
  KEY `FKfq1vs5t876wufr6l5tctnopps` (`cvid`),
  CONSTRAINT `FKfq1vs5t876wufr6l5tctnopps` FOREIGN KEY (`cvid`) REFERENCES `t_customer` (`cid`),
  CONSTRAINT `FKnbsiiqbdcpvtugygwe4vj42s0` FOREIGN KEY (`uvid`) REFERENCES `t_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_visit` */

insert  into `t_visit`(`vid`,`vaddress`,`vcontent`,`uvid`,`cvid`) values (1,'日本','公关',2,1),(2,'美国','销售',1,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
