/*
Navicat MySQL Data Transfer

Source Server         : 123
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : mike

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2017-11-08 10:12:16
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `code` varchar(40) NOT NULL COMMENT '会员账号',
  `email` varchar(40) DEFAULT NULL COMMENT '邮箱地址',
  `phone` bigint(40) DEFAULT NULL COMMENT '手机号',
  `weibo_code` varchar(80) DEFAULT NULL,
  `wechat_code` varchar(80) DEFAULT NULL,
  `qq_code` varchar(80) DEFAULT NULL,
  `safe_number` int(11) unsigned zerofill DEFAULT NULL,
  `is_bind_secur` bit(1) DEFAULT b'0' COMMENT '是否绑定密保',
  `password` varchar(80) NOT NULL COMMENT '密码',
  `login_count` int(11) DEFAULT NULL COMMENT '登录次数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `enable` bit(1) NOT NULL COMMENT '是否启用',
  `last_login_ip` varchar(40) DEFAULT NULL COMMENT '最后登录ip地址',
  `source` tinyint(4) DEFAULT NULL COMMENT '来源',
  `salt` varchar(50) DEFAULT NULL COMMENT '盐',
  `locked` bit(1) DEFAULT NULL COMMENT '是否锁定',
  `del_flag` bit(1) DEFAULT NULL,
  `corp_id` int(10) DEFAULT NULL,
  `dept_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------

-- ----------------------------
-- Table structure for s_user_token
-- ----------------------------
DROP TABLE IF EXISTS `s_user_token`;
CREATE TABLE `s_user_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_code` varchar(50) NOT NULL COMMENT '用户id',
  `token` int(11) NOT NULL COMMENT 'token值',
  `last_time` datetime NOT NULL COMMENT '登录时间',
  `expire_time` datetime NOT NULL COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user_token
-- ----------------------------
