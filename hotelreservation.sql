/*
 Navicat Premium Data Transfer

 Source Server         : MySqlTest
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : hotelreservation

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 21/04/2019 12:31:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for con_test
-- ----------------------------
DROP TABLE IF EXISTS `con_test`;
CREATE TABLE `con_test`  (
  `a` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hotelroom
-- ----------------------------
DROP TABLE IF EXISTS `hotelroom`;
CREATE TABLE `hotelroom`  (
  `IDRoom` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TypeRoom` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SubclassRoom` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PriceRoom` int(5) NOT NULL,
  PRIMARY KEY (`IDRoom`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hotelroom
-- ----------------------------
INSERT INTO `hotelroom` VALUES ('1001', '单人房', '普通单人间', 180);
INSERT INTO `hotelroom` VALUES ('1003', '单人房', '豪华单人间', 300);
INSERT INTO `hotelroom` VALUES ('2005', '大床房', '标准大床房', 240);
INSERT INTO `hotelroom` VALUES ('2007', '大床房', '特色情侣房', 800);
INSERT INTO `hotelroom` VALUES ('2011', '大床房', '豪华大床房', 288);
INSERT INTO `hotelroom` VALUES ('3001', '双床房', '标准双床房', 220);
INSERT INTO `hotelroom` VALUES ('3002', '双床房', '高级双人房', 260);
INSERT INTO `hotelroom` VALUES ('4003', '双床房', '商务房', 350);
INSERT INTO `hotelroom` VALUES ('5004', '双床房', '行政双人房', 400);
INSERT INTO `hotelroom` VALUES ('5008', '大床房', '豪华套房', 1500);
INSERT INTO `hotelroom` VALUES ('6006', '大床房', '景观房', 550);

-- ----------------------------
-- Table structure for orderroom
-- ----------------------------
DROP TABLE IF EXISTS `orderroom`;
CREATE TABLE `orderroom`  (
  `IDOrder` int(255) NOT NULL AUTO_INCREMENT,
  `IDRoom` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `NickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `RealName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IDNumber` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TimeHousing` date NOT NULL,
  `DayHousing` int(3) NOT NULL,
  `HaveBreakfast` int(2) NOT NULL,
  `AllPrice` int(6) NOT NULL,
  `TimeOrder` date NOT NULL,
  PRIMARY KEY (`IDOrder`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderroom
-- ----------------------------
INSERT INTO `orderroom` VALUES (1, '1001', '李四', '李四机', '130684166950203216', '2019-04-09', 3, 3, 630, '2019-04-09');
INSERT INTO `orderroom` VALUES (13, '1003', '张立林', '张某', '130684166950203211', '2019-04-25', 4, 4, 1360, '2019-04-17');
INSERT INTO `orderroom` VALUES (14, '1003', '张立林', '张某', '130684166950203211', '2019-04-25', 4, 4, 1360, '2019-04-17');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `NickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `RealName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Age` int(11) NOT NULL,
  `Sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IDNumber` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Phone` varchar(13) CHARACTER SET utf16 COLLATE utf16_general_ci NOT NULL,
  PRIMARY KEY (`NickName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('张三', '123456987', '张三', 7, 'man', '130684166950203299', '15931255332');
INSERT INTO `users` VALUES ('张立林', '123456789', '张立林', 21, 'man', '130684166950203299', '15931255332');
INSERT INTO `users` VALUES ('李四', '123456789', '李四机', 7, 'man', '130684166950203216', '12345698526');
INSERT INTO `users` VALUES ('王五', '123456', '王无误', 7, 'man', '130684166950203265', '12345698526');

SET FOREIGN_KEY_CHECKS = 1;
