/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : preeticket

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 15/06/2019 10:49:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id_activity` int(11) NOT NULL AUTO_INCREMENT,
  `id_organizer` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `place` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time_signup` datetime(0) NULL DEFAULT NULL,
  `time_start` datetime(0) NULL DEFAULT NULL,
  `capacity` int(11) NOT NULL,
  `detail` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `seat_seletable` int(4) NOT NULL,
  `seat_row` int(11) NULL DEFAULT NULL,
  `seat_col` int(11) NULL DEFAULT NULL,
  `seat_map` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_activity`) USING BTREE,
  INDEX `activity-O_idx`(`id_organizer`) USING BTREE,
  CONSTRAINT `act-Org` FOREIGN KEY (`id_organizer`) REFERENCES `user_organizer` (`id_organizer`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (1001, 2001, 1, '演唱会', '天佑会堂', '2019-06-15 10:13:26', '2019-06-30 08:00:00', 100, 'no detail', 1, 100, 100, '00000000000000');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id_notice` int(11) NOT NULL AUTO_INCREMENT,
  `id_act` int(11) NOT NULL,
  `time_publish` datetime(0) NULL DEFAULT NULL,
  `detail` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id_notice`) USING BTREE,
  INDEX `notice-Act_idx`(`id_act`) USING BTREE,
  CONSTRAINT `notict-Act` FOREIGN KEY (`id_act`) REFERENCES `activity` (`id_activity`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (10001, 1001, '2019-06-15 10:15:00', 'no detail');

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket`  (
  `id_activity` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `seat` int(11) NOT NULL,
  PRIMARY KEY (`id_activity`, `id_user`, `seat`) USING BTREE,
  INDEX `tickets-userN_idx`(`id_user`) USING BTREE,
  CONSTRAINT `ticket-Own` FOREIGN KEY (`id_user`) REFERENCES `user_normal` (`id_normal`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ticket-Act` FOREIGN KEY (`id_activity`) REFERENCES `activity` (`id_activity`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES (1001, 1001, 37);

-- ----------------------------
-- Table structure for user_normal
-- ----------------------------
DROP TABLE IF EXISTS `user_normal`;
CREATE TABLE `user_normal`  (
  `id_normal` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `avator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` int(10) NULL DEFAULT NULL,
  `tel_num` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_normal`, `username`) USING BTREE,
  INDEX `id_normal`(`id_normal`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_normal
-- ----------------------------
INSERT INTO `user_normal` VALUES (1001, 'user1', '111', 'Normal1', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3443176063,4021563566&fm=27&gp=0.jpg', 1, '111111', '1@11.com');
INSERT INTO `user_normal` VALUES (1002, 'user2', '222', 'Normal2', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3512142610,2378185322&fm=27&gp=0.jpg', 0, '111111', '2@qq.com');
INSERT INTO `user_normal` VALUES (1004, 'user3', '333', 'Normal3', NULL, 0, NULL, NULL);

-- ----------------------------
-- Table structure for user_organizer
-- ----------------------------
DROP TABLE IF EXISTS `user_organizer`;
CREATE TABLE `user_organizer`  (
  `id_organizer` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `organize` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel_num` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_organizer`, `username`) USING BTREE,
  INDEX `id_organizer`(`id_organizer`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_organizer
-- ----------------------------
INSERT INTO `user_organizer` VALUES (2001, 'Org1', '111', '学生会', '111111', '1@qq.com', 'Intro');

SET FOREIGN_KEY_CHECKS = 1;
