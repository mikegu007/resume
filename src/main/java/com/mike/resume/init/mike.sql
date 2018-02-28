/*
Navicat MySQL Data Transfer

Source Server         : 123
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : mike

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-02-28 14:28:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for c_card
-- ----------------------------
DROP TABLE IF EXISTS `c_card`;
CREATE TABLE `c_card` (
  `id` int(11) NOT NULL,
  `open_id` varchar(50) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `del_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of c_card
-- ----------------------------

-- ----------------------------
-- Table structure for c_order
-- ----------------------------
DROP TABLE IF EXISTS `c_order`;
CREATE TABLE `c_order` (
  `order_no` varchar(255) NOT NULL,
  `open_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `amount_actual` decimal(40,0) DEFAULT NULL,
  `amount` decimal(40,0) DEFAULT NULL,
  `detail_count` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `has_pay` bit(1) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_order
-- ----------------------------

-- ----------------------------
-- Table structure for c_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `c_order_detail`;
CREATE TABLE `c_order_detail` (
  `id` int(11) NOT NULL,
  `order_no` varchar(255) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `del_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for c_product
-- ----------------------------
DROP TABLE IF EXISTS `c_product`;
CREATE TABLE `c_product` (
  `id` int(11) NOT NULL,
  `category_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `des` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `pro_pic_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `price` decimal(40,0) DEFAULT NULL,
  `enable` bit(1) DEFAULT b'1' COMMENT '是否启用',
  `del_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of c_product
-- ----------------------------

-- ----------------------------
-- Table structure for c_product_size
-- ----------------------------
DROP TABLE IF EXISTS `c_product_size`;
CREATE TABLE `c_product_size` (
  `id` int(11) NOT NULL,
  `c_product_id` int(11) DEFAULT NULL,
  `size_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_product_size
-- ----------------------------

-- ----------------------------
-- Table structure for c_product_taste
-- ----------------------------
DROP TABLE IF EXISTS `c_product_taste`;
CREATE TABLE `c_product_taste` (
  `id` int(11) NOT NULL,
  `c_product_id` int(11) DEFAULT NULL,
  `taste_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_product_taste
-- ----------------------------

-- ----------------------------
-- Table structure for lottery
-- ----------------------------
DROP TABLE IF EXISTS `lottery`;
CREATE TABLE `lottery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `period` varchar(255) DEFAULT NULL COMMENT '期数',
  `date` datetime DEFAULT NULL,
  `red_one` int(11) DEFAULT NULL,
  `red_two` int(11) DEFAULT NULL,
  `red_three` int(11) DEFAULT NULL,
  `red_four` int(11) DEFAULT NULL,
  `red_five` int(11) DEFAULT NULL,
  `red_six` int(11) DEFAULT NULL,
  `blue_one` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lottery
-- ----------------------------
INSERT INTO `lottery` VALUES ('31', '17102', '2017-08-31 00:00:00', '4', '8', '10', '14', '18', '20', '11');
INSERT INTO `lottery` VALUES ('32', '17103', '2017-09-03 00:00:00', '1', '21', '23', '25', '31', '33', '1');
INSERT INTO `lottery` VALUES ('33', '17104', '2017-09-05 00:00:00', '1', '14', '15', '20', '23', '30', '14');
INSERT INTO `lottery` VALUES ('34', '17105', '2017-09-07 00:00:00', '3', '6', '7', '12', '25', '26', '7');
INSERT INTO `lottery` VALUES ('35', '17106', '2017-09-10 00:00:00', '12', '15', '20', '25', '27', '31', '2');
INSERT INTO `lottery` VALUES ('36', '17107', '2017-09-12 00:00:00', '8', '9', '15', '17', '30', '32', '6');
INSERT INTO `lottery` VALUES ('37', '17108', '2017-09-14 00:00:00', '7', '12', '14', '15', '17', '20', '1');
INSERT INTO `lottery` VALUES ('38', '17109', '2017-09-17 00:00:00', '8', '14', '16', '18', '21', '23', '16');
INSERT INTO `lottery` VALUES ('39', '17110', '2017-09-19 00:00:00', '1', '3', '12', '15', '19', '23', '14');
INSERT INTO `lottery` VALUES ('40', '17111', '2017-09-21 00:00:00', '5', '10', '17', '19', '29', '32', '12');
INSERT INTO `lottery` VALUES ('41', '17112', '2017-09-24 00:00:00', '3', '10', '14', '16', '22', '23', '11');
INSERT INTO `lottery` VALUES ('42', '17113', '2017-09-26 00:00:00', '4', '6', '16', '27', '29', '33', '5');
INSERT INTO `lottery` VALUES ('43', '17114', '2017-09-28 00:00:00', '6', '12', '13', '15', '18', '26', '13');
INSERT INTO `lottery` VALUES ('44', '17115', '2017-10-01 00:00:00', '4', '10', '11', '25', '30', '31', '1');
INSERT INTO `lottery` VALUES ('45', '17116', '2017-10-03 00:00:00', '2', '14', '20', '22', '30', '32', '2');
INSERT INTO `lottery` VALUES ('46', '17117', '2017-10-05 00:00:00', '1', '2', '8', '11', '14', '21', '9');
INSERT INTO `lottery` VALUES ('47', '17118', '2017-10-08 00:00:00', '8', '9', '15', '22', '30', '33', '16');
INSERT INTO `lottery` VALUES ('48', '17119', '2017-10-10 00:00:00', '9', '16', '21', '25', '26', '31', '14');
INSERT INTO `lottery` VALUES ('49', '17120', '2017-10-12 00:00:00', '8', '10', '15', '19', '23', '28', '16');
INSERT INTO `lottery` VALUES ('50', '17121', '2017-10-15 00:00:00', '11', '18', '19', '22', '24', '32', '7');
INSERT INTO `lottery` VALUES ('51', '17122', '2017-10-17 00:00:00', '11', '20', '21', '22', '24', '27', '15');
INSERT INTO `lottery` VALUES ('52', '17123', '2017-10-19 00:00:00', '4', '5', '6', '11', '21', '31', '10');
INSERT INTO `lottery` VALUES ('53', '17124', '2017-10-22 00:00:00', '2', '6', '11', '26', '28', '29', '3');
INSERT INTO `lottery` VALUES ('54', '17125', '2017-10-24 00:00:00', '1', '14', '23', '25', '29', '30', '3');
INSERT INTO `lottery` VALUES ('55', '17126', '2017-10-26 00:00:00', '1', '16', '17', '21', '27', '30', '16');
INSERT INTO `lottery` VALUES ('56', '17127', '2017-10-29 00:00:00', '14', '15', '21', '24', '27', '32', '12');
INSERT INTO `lottery` VALUES ('57', '17128', '2017-10-31 00:00:00', '2', '6', '13', '22', '29', '31', '8');
INSERT INTO `lottery` VALUES ('58', '17129', '2017-11-02 00:00:00', '5', '6', '9', '14', '21', '33', '2');
INSERT INTO `lottery` VALUES ('59', '17130', '2017-11-05 00:00:00', '5', '13', '14', '23', '25', '31', '2');
INSERT INTO `lottery` VALUES ('60', '17131', '2017-11-07 00:00:00', '1', '7', '10', '11', '26', '27', '11');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `open_id` varchar(50) NOT NULL,
  `avatar_url` varchar(250) DEFAULT NULL COMMENT '用户头像',
  `city` varchar(120) DEFAULT NULL COMMENT '用户所在城市',
  `country` varchar(120) DEFAULT NULL COMMENT '用户所在国家',
  `province` varchar(120) DEFAULT NULL COMMENT '用户所在省份',
  `language` varchar(120) DEFAULT NULL COMMENT '用户的语言,简体中文为zh_CN',
  `nick_name` varchar(80) DEFAULT NULL COMMENT '用户昵称',
  `gender` int(11) DEFAULT '0' COMMENT '性别值为1时是男性，值为2时是女性，值为0时是未知',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `enable` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否启用',
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------

-- ----------------------------
-- Table structure for s_user_address
-- ----------------------------
DROP TABLE IF EXISTS `s_user_address`;
CREATE TABLE `s_user_address` (
  `id` int(11) NOT NULL,
  `open_id` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `postcode` varchar(255) NOT NULL COMMENT '邮编',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of s_user_address
-- ----------------------------

-- ----------------------------
-- Table structure for s_user_token
-- ----------------------------
DROP TABLE IF EXISTS `s_user_token`;
CREATE TABLE `s_user_token` (
  `id` int(11) NOT NULL,
  `open_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user_token
-- ----------------------------
