/*
 Navicat Premium Data Transfer

 Source Server         : mysql8
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : practice

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 06/06/2019 23:27:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id_activity` int(11) NOT NULL,
  `id_organizer` int(11) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `place` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time_signup` datetime(0) NULL DEFAULT NULL,
  `time_start` datetime(0) NULL DEFAULT NULL,
  `capacity` int(11) NULL DEFAULT NULL,
  `detail` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `seat_seletable` int(4) NOT NULL,
  `seat_row` int(11) NULL DEFAULT NULL,
  `seat_col` int(11) NULL DEFAULT NULL,
  `seat_map` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_activity`) USING BTREE,
  INDEX `activity-O_idx`(`id_organizer`) USING BTREE,
  CONSTRAINT `activity-O` FOREIGN KEY (`id_organizer`) REFERENCES `user_organizer` (`id_organizer`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id_notice` int(11) NOT NULL,
  `id_act` int(11) NOT NULL,
  `time_publish` datetime(0) NULL,
  `detail` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_notice`, `id_act`) USING BTREE,
  INDEX `notice-Act_idx`(`id_act`) USING BTREE,
  CONSTRAINT `notice-Act` FOREIGN KEY (`id_act`) REFERENCES `activity` (`id_activity`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket`  (
  `id_activity` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `seat` int(11) NOT NULL,
  PRIMARY KEY (`id_activity`, `id_user`, `seat`) USING BTREE,
  INDEX `tickets-userN_idx`(`id_user`) USING BTREE,
  CONSTRAINT `tickets-Act` FOREIGN KEY (`id_activity`) REFERENCES `activity` (`id_activity`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tickets-userN` FOREIGN KEY (`id_user`) REFERENCES `user_normal` (`id_normal`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id_user` int(11) NOT NULL,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel_num` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_user`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (111, '111', '111', NULL, NULL);
INSERT INTO `user` VALUES (222, '222', '222', NULL, NULL);

-- ----------------------------
-- Table structure for user_normal
-- ----------------------------
DROP TABLE IF EXISTS `user_normal`;
CREATE TABLE `user_normal`  (
  `id_normal` int(11) NOT NULL,
  `nickname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `avator` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id_normal`) USING BTREE,
  CONSTRAINT `id_N` FOREIGN KEY (`id_normal`) REFERENCES `user` (`id_user`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_organizer
-- ----------------------------
DROP TABLE IF EXISTS `user_organizer`;
CREATE TABLE `user_organizer`  (
  `id_organizer` int(11) NOT NULL,
  `organize` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contact` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_organizer`) USING BTREE,
  CONSTRAINT `id_O` FOREIGN KEY (`id_organizer`) REFERENCES `user` (`id_user`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
