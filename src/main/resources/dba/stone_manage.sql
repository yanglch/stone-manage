/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : stone_manage

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-03-05 04:02:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stone
-- ----------------------------
DROP TABLE IF EXISTS `stone`;
CREATE TABLE `stone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `type_code` varchar(100) NOT NULL,
  `gmt_modifier` datetime NOT NULL,
  `gmt_created` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stone
-- ----------------------------
INSERT INTO `stone` VALUES ('1', '测试石材产品', 'aaccdd', '2019-03-06 03:07:06', '2019-03-05 03:07:11');
INSERT INTO `stone` VALUES ('2', 'ce是', 'aaccdd', '2019-03-05 03:17:47', '2019-03-05 03:17:50');
INSERT INTO `stone` VALUES ('3', '12311111111111111111111111111111111122', 'aaccdd', '2019-03-05 03:40:31', '2019-03-05 03:38:19');

-- ----------------------------
-- Table structure for stone_type
-- ----------------------------
DROP TABLE IF EXISTS `stone_type`;
CREATE TABLE `stone_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `code` varchar(100) NOT NULL,
  `gmt_modifier` datetime DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stone_type
-- ----------------------------
INSERT INTO `stone_type` VALUES ('1', '22', '33', '2019-03-05 02:23:17', '2019-03-08 02:23:21');
INSERT INTO `stone_type` VALUES ('2', '12311111111111111111111111111111111122', '13321', '2019-03-05 03:50:14', '2019-03-05 03:48:27');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `role_id` text,
  `user_id` text,
  `gmt_modifier` datetime DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `user_id` text,
  `permission_id` text,
  `gmt_modifier` datetime DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(100) DEFAULT NULL,
  `login_name` varchar(100) NOT NULL,
  `pass_word` varchar(100) NOT NULL,
  `salt` varchar(100) NOT NULL,
  `role_id` text,
  `permission_id` text,
  `gmt_modifier` datetime DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', '1', '1', '1', '1', '1', null, null);
