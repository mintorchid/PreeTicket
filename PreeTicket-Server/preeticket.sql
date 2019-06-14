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

 Date: 13/06/2019 23:15:42
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
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (101, 1002, 'TestActivity', '天佑会堂', '2019-06-13 23:08:18', '2019-06-15 08:00:00', 100, 'no activity detail', 1, 10, 10, '');

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
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (10001, 101, '2019-06-13 23:30:00', 'no notice detail');

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
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES (101, 1001, 63);
INSERT INTO `ticket` VALUES (101, 1003, 64);

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
INSERT INTO `user` VALUES (1001, 'user1', '111', '111111', '111@qq.com');
INSERT INTO `user` VALUES (1002, 'user2', '222', '222222', '222@qq.com');
INSERT INTO `user` VALUES (1003, 'user3', '333', '333333', '333@qq.com');

-- ----------------------------
-- Table structure for user_normal
-- ----------------------------
DROP TABLE IF EXISTS `user_normal`;
CREATE TABLE `user_normal`  (
  `id_normal` int(11) NOT NULL,
  `nickname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `avator` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id_normal`) USING BTREE,
  CONSTRAINT `id_N` FOREIGN KEY (`id_normal`) REFERENCES `user` (`id_user`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_normal
-- ----------------------------
INSERT INTO `user_normal` VALUES (1001, 'Normal1', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3443176063,4021563566&fm=27&gp=0.jpg', 1);
INSERT INTO `user_normal` VALUES (1003, 'Normal2', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3512142610,2378185322&fm=27&gp=0.jpg', 0);

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

-- ----------------------------
-- Records of user_organizer
-- ----------------------------
INSERT INTO `user_organizer` VALUES (1002, '学生会', 'Intro', '123456');

SET FOREIGN_KEY_CHECKS = 1;
