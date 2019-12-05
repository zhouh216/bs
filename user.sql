/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : fiction_crawler_db

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2019-04-21 12:44:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `collect_list` varchar(128) DEFAULT NULL,
  `subscription_list` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
