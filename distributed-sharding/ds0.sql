/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : ds0

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 05/07/2023 10:34:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` bigint UNSIGNED NOT NULL,
  `user_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (1687333321786, 947);
INSERT INTO `t_order` VALUES (1687333321874, 675);
INSERT INTO `t_order` VALUES (1687333321879, 793);
INSERT INTO `t_order` VALUES (1687333321883, 131);
INSERT INTO `t_order` VALUES (1687333321888, 230);
INSERT INTO `t_order` VALUES (1687333321892, 688);
INSERT INTO `t_order` VALUES (1687333321896, 619);
INSERT INTO `t_order` VALUES (1687333321900, 315);
INSERT INTO `t_order` VALUES (1687333321904, 456);
INSERT INTO `t_order` VALUES (1687333321909, 690);
INSERT INTO `t_order` VALUES (1687333321913, 203);
INSERT INTO `t_order` VALUES (1687333321917, 607);
INSERT INTO `t_order` VALUES (1687333321922, 122);
INSERT INTO `t_order` VALUES (1687333321927, 417);
INSERT INTO `t_order` VALUES (1687333321931, 325);
INSERT INTO `t_order` VALUES (1687333321936, 749);
INSERT INTO `t_order` VALUES (1687333321943, 254);
INSERT INTO `t_order` VALUES (1687333321947, 954);
INSERT INTO `t_order` VALUES (1687333321951, 600);
INSERT INTO `t_order` VALUES (1687333321956, 632);
INSERT INTO `t_order` VALUES (1687349782290, 331);
INSERT INTO `t_order` VALUES (1688392117251, 917);
INSERT INTO `t_order` VALUES (1688392141475, 523);
INSERT INTO `t_order` VALUES (1688392175612, 367);
INSERT INTO `t_order` VALUES (1688392491681, 526);
INSERT INTO `t_order` VALUES (1688392507703, 190);
INSERT INTO `t_order` VALUES (1688392569525, 125);
INSERT INTO `t_order` VALUES (1688392581739, 587);
INSERT INTO `t_order` VALUES (1688392658767, 692);
INSERT INTO `t_order` VALUES (1688392674067, 759);

-- ----------------------------
-- Table structure for t_order_0
-- ----------------------------
DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0`  (
  `order_id` bigint UNSIGNED NOT NULL,
  `user_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_0
-- ----------------------------
INSERT INTO `t_order_0` VALUES (878389878449483776, 245);
INSERT INTO `t_order_0` VALUES (878391115337150464, 115);
INSERT INTO `t_order_0` VALUES (878391115949518848, 798);
INSERT INTO `t_order_0` VALUES (878391115995656192, 454);
INSERT INTO `t_order_0` VALUES (878391116033404928, 930);
INSERT INTO `t_order_0` VALUES (878391116075347968, 590);
INSERT INTO `t_order_0` VALUES (878391116113096704, 377);
INSERT INTO `t_order_0` VALUES (878391116155039744, 60);
INSERT INTO `t_order_0` VALUES (878391116192788480, 527);
INSERT INTO `t_order_0` VALUES (878391116247314432, 638);
INSERT INTO `t_order_0` VALUES (878391116280868864, 58);

-- ----------------------------
-- Table structure for t_order_1
-- ----------------------------
DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1`  (
  `order_id` bigint UNSIGNED NOT NULL,
  `user_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_1
-- ----------------------------
INSERT INTO `t_order_1` VALUES (878391115932741633, 44);
INSERT INTO `t_order_1` VALUES (878391115970490369, 108);
INSERT INTO `t_order_1` VALUES (878391116012433409, 10);
INSERT INTO `t_order_1` VALUES (878391116050182145, 706);
INSERT INTO `t_order_1` VALUES (878391116096319489, 247);
INSERT INTO `t_order_1` VALUES (878391116134068225, 612);
INSERT INTO `t_order_1` VALUES (878391116171816961, 766);
INSERT INTO `t_order_1` VALUES (878391116222148609, 912);
INSERT INTO `t_order_1` VALUES (878391116264091649, 236);
INSERT INTO `t_order_1` VALUES (878391116297646081, 10099);

SET FOREIGN_KEY_CHECKS = 1;