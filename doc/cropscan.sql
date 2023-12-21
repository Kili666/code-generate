/*
 Navicat Premium Data Transfer

 Source Server         : homepage
 Source Server Type    : MySQL
 Source Server Version : 80020 (8.0.20)
 Source Host           : 139.224.164.169:3306
 Source Schema         : cropscan

 Target Server Type    : MySQL
 Target Server Version : 80020 (8.0.20)
 File Encoding         : 65001

 Date: 20/12/2023 15:04:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `group_id` int NOT NULL DEFAULT 0 COMMENT '角色id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES (1, 'admin', '后台管理员', '$2a$10$VMGYeAVytBu2nlvzPvBLzensuXWQ26MF0KcElRb5bT47abRNQ68WG', 1, '2021-12-29 06:46:50', '2022-01-26 06:46:56');
INSERT INTO `tb_admin` VALUES (2, '123456', '普通管理员', '$2a$10$VMGYeAVytBu2nlvzPvBLzensuXWQ26MF0KcElRb5bT47abRNQ68WG', 2, '2022-01-05 15:07:11', '2022-01-27 15:07:16');

-- ----------------------------
-- Table structure for tb_group
-- ----------------------------
DROP TABLE IF EXISTS `tb_group`;
CREATE TABLE `tb_group`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `pid` int NOT NULL DEFAULT 0 COMMENT '上级id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户组' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_group
-- ----------------------------
INSERT INTO `tb_group` VALUES (1, 0, '超级管理员', '2022-01-12 06:47:09');
INSERT INTO `tb_group` VALUES (2, 0, '普通用户', '2022-01-26 14:57:41');

-- ----------------------------
-- Table structure for tb_group_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_group_role`;
CREATE TABLE `tb_group_role`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `group_id` int NOT NULL DEFAULT 0 COMMENT '用户id',
  `role_id` int NOT NULL DEFAULT 0 COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `group_foreign`(`group_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户权限关联表' ROW_FORMAT = FIXED;

-- ----------------------------
-- Records of tb_group_role
-- ----------------------------
INSERT INTO `tb_group_role` VALUES (1, 1, 1);
INSERT INTO `tb_group_role` VALUES (2, 1, 2);
INSERT INTO `tb_group_role` VALUES (3, 2, 1);
INSERT INTO `tb_group_role` VALUES (4, 2, 3);

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单id',
  `buyer_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家id， 一对一关系',
  `shipement_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流编号，一对一关系',
  `receiver_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人id, 一对一关系',
  `pay_records_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付记录，一对多关系',
  `total_num` int NULL DEFAULT NULL COMMENT '数量合计',
  `total_money` int NULL DEFAULT NULL COMMENT '金额合计',
  `pre_money` int NULL DEFAULT NULL COMMENT '优惠金额',
  `post_fee` int NULL DEFAULT NULL COMMENT '邮费',
  `pay_money` int NULL DEFAULT NULL COMMENT '实付金额',
  `pay_type` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '支付类型，1、在线支付、0 货到付款、2：积分支付',
  `create_time` datetime NULL DEFAULT NULL COMMENT '订单创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '订单更新时间',
  `pay_time` datetime NULL DEFAULT NULL COMMENT '付款时间',
  `consign_time` datetime NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '交易完成时间',
  `close_time` datetime NULL DEFAULT NULL COMMENT '交易关闭时间',
  `shipping_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '物流名称',
  `buyer_message` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '买家留言',
  `buyer_rate` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '是否评价',
  `receiver_contact` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '收货人',
  `receiver_mobile` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '收货人手机',
  `source_type` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '订单来源：1:web，2：app，3：微信公众号，4：微信小程序  5 H5手机页面，6：自营',
  `order_status` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '订单状态 (0:未完成,1:进行中(待支付）, 2:已完成, 3：已退货(取消））',
  `pay_status` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '支付状态 0:未支付 1:已支付',
  `consign_status` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '发货状态 0:未发货 1:已发货 2:已送达',
  `is_delete` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `create_time`(`create_time` ASC) USING BTREE,
  INDEX `status`(`order_status` ASC) USING BTREE,
  INDEX `payment_type`(`pay_type` ASC) USING BTREE,
  INDEX `buyer_fk`(`buyer_id` ASC) USING BTREE,
  INDEX `receiver_fk`(`receiver_id` ASC) USING BTREE,
  INDEX `shipment_fk`(`shipement_id` ASC) USING BTREE,
  INDEX `pay_record_fk`(`pay_records_id` ASC) USING BTREE,
  CONSTRAINT `buyer_fk` FOREIGN KEY (`buyer_id`) REFERENCES `tb_user` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `pay_record_fk` FOREIGN KEY (`pay_records_id`) REFERENCES `tb_payment` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `receiver_fk` FOREIGN KEY (`receiver_id`) REFERENCES `tb_user` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `shipment_fk` FOREIGN KEY (`shipement_id`) REFERENCES `tb_shipement` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '订单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('1', 'test', '1', 'Kili', '1', 4, 26940, 26939, NULL, 1, '1', '2022-05-03 17:32:15', '2022-05-03 18:36:44', '2022-05-03 18:36:44', NULL, NULL, NULL, NULL, '', '0', '李千军', '15800406868', '1', '2', '1', '0', '0');
INSERT INTO `tb_order` VALUES ('1521500997460037632', 'Kili', '2', 'Kili', '2', 1, 7943, NULL, NULL, 1, '1', '2022-05-03 22:44:41', '2022-05-04 00:59:32', '2022-05-03 22:46:15', NULL, '2022-05-04 00:59:32', NULL, NULL, '', '1', '李千军', '15800406868', '2', '2', '1', '2', '0');
INSERT INTO `tb_order` VALUES ('1521535073961250816', 'Kili', '3', 'qianjun', '2', 1, 3167, NULL, NULL, 1, '1', '2022-05-04 01:00:05', NULL, '2022-05-04 01:00:26', NULL, NULL, NULL, NULL, '', '0', '李千军', '15800406868', '2', '1', '1', '0', '0');
INSERT INTO `tb_order` VALUES ('1521546643877531648', 'Kili', '4', 'Kili', '1', 1, 7890, NULL, NULL, 1, NULL, '2022-05-04 01:46:03', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', NULL, NULL, '2', '1', '0', '0', '0');
INSERT INTO `tb_order` VALUES ('1521552447347499009', 'Kili', '5', 'Kili', '2', 1, 399998, 399878, NULL, 120, '2', '2022-05-04 02:09:07', '2022-05-04 02:09:07', NULL, NULL, NULL, NULL, NULL, '', '0', '李千军', '15800406868', '6', '1', '0', '0', '0');
INSERT INTO `tb_order` VALUES ('1521826065449099266', 'Kili', '6', 'test', '2', 1, 3850, 3849, NULL, 1, '1', '2022-05-04 20:16:23', '2022-05-04 20:16:37', '2022-05-04 20:16:37', NULL, NULL, NULL, NULL, '', '0', '李千军', '15800406868', '1', '2', '1', '0', '0');
INSERT INTO `tb_order` VALUES ('1521826465061412865', 'Kili', '7', 'Kili', '2', 1, 3850, 3849, NULL, 1, '1', '2022-05-04 20:17:58', '2022-05-04 20:18:13', '2022-05-04 20:18:13', NULL, NULL, NULL, NULL, '', '0', '李千军', '15800406868', '1', '2', '1', '2', '0');
INSERT INTO `tb_order` VALUES ('1533005554736570369', 'qianjun', '8', 'Kili', '3', 1, 1400, 1399, NULL, 1, '1', '2022-06-04 16:39:41', '2022-06-04 16:39:41', NULL, NULL, NULL, NULL, NULL, '', '0', '秦湘婷', '18302143872', '6', '1', '0', '0', '0');

-- ----------------------------
-- Table structure for tb_payment
-- ----------------------------
DROP TABLE IF EXISTS `tb_payment`;
CREATE TABLE `tb_payment`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付流水号',
  `order_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `payment_time` datetime NULL DEFAULT NULL COMMENT '支付日期',
  `payment_method` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付方式',
  `amount` float NULL DEFAULT NULL COMMENT '支付金额',
  `currency` tinyint NULL DEFAULT NULL COMMENT '币种',
  `payment_status` int NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id`(`id` ASC) USING BTREE,
  INDEX `amount`(`amount` ASC) USING BTREE,
  INDEX `order_id_2`(`order_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '支付记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_payment
-- ----------------------------
INSERT INTO `tb_payment` VALUES ('1', '1', '2023-01-01 10:00:00', 'Credit Card', 100.5, 1, 1);
INSERT INTO `tb_payment` VALUES ('10', '9', '2023-01-09 15:15:00', 'Credit Card', 95.3, 1, 1);
INSERT INTO `tb_payment` VALUES ('2', '1', '2023-01-10 14:00:00', 'PayPal', 130.4, 2, 1);
INSERT INTO `tb_payment` VALUES ('3', '2', '2023-01-02 11:30:00', 'PayPal', 75.2, 2, 1);
INSERT INTO `tb_payment` VALUES ('4', '3', '2023-01-03 14:45:00', 'Bank Transfer', 120.75, 1, 1);
INSERT INTO `tb_payment` VALUES ('5', '1', '2023-01-04 09:15:00', 'Cash', 50, 2, 2);
INSERT INTO `tb_payment` VALUES ('6', '1', '2023-01-05 16:30:00', 'Credit Card', 90.8, 1, 1);
INSERT INTO `tb_payment` VALUES ('7', '6', '2023-01-06 12:00:00', 'PayPal', 110.25, 2, 1);
INSERT INTO `tb_payment` VALUES ('8', '7', '2023-01-07 13:45:00', 'Bank Transfer', 80.5, 1, 1);
INSERT INTO `tb_payment` VALUES ('9', '8', '2023-01-08 10:30:00', 'Cash', 65.9, 2, 2);

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `pid` int NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '页面路由地址',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `identification` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '唯一标识，用来标识权限',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `identification`(`identification`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台菜单+权限' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES (1, 0, NULL, '增删改', 'ROLE_ADMIN', '2022-01-26 06:47:37');
INSERT INTO `tb_role` VALUES (2, 0, NULL, '查询', 'ROLE_USER', '2022-01-26 07:10:09');
INSERT INTO `tb_role` VALUES (3, 0, NULL, '编辑信息', 'ROLE_OPEN', '2022-01-26 07:10:43');

-- ----------------------------
-- Table structure for tb_shipement
-- ----------------------------
DROP TABLE IF EXISTS `tb_shipement`;
CREATE TABLE `tb_shipement`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物流id',
  `order_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `shipment_date` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '发货日期',
  `carrier_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '承运商名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物流信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shipement
-- ----------------------------
INSERT INTO `tb_shipement` VALUES ('1', '1', '2023-01-01 10:00:00', 'Express Shipping');
INSERT INTO `tb_shipement` VALUES ('10', '2', '2023-01-10 14:00:00', 'Ground Shipping');
INSERT INTO `tb_shipement` VALUES ('2', '1', '2023-01-02 11:30:00', 'Standard Shipping');
INSERT INTO `tb_shipement` VALUES ('3', '1', '2023-01-03 14:45:00', 'Courier Service');
INSERT INTO `tb_shipement` VALUES ('4', '1', '2023-01-04 09:15:00', 'Air Freight');
INSERT INTO `tb_shipement` VALUES ('5', '1', '2023-01-05 16:30:00', 'Ground Shipping');
INSERT INTO `tb_shipement` VALUES ('6', '2', '2023-01-06 12:00:00', 'Express Shipping');
INSERT INTO `tb_shipement` VALUES ('7', '2', '2023-01-07 13:45:00', 'Standard Shipping');
INSERT INTO `tb_shipement` VALUES ('8', '2', '2023-01-08 10:30:00', 'Courier Service');
INSERT INTO `tb_shipement` VALUES ('9', '2', '2023-01-09 15:15:00', 'Air Freight');

-- ----------------------------
-- Table structure for tb_token
-- ----------------------------
DROP TABLE IF EXISTS `tb_token`;
CREATE TABLE `tb_token`  (
  `user_id` int NOT NULL DEFAULT 0,
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'JWT',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '登录token' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_token
-- ----------------------------
INSERT INTO `tb_token` VALUES (1, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZG1pbiIsInJlYWxOYW1lIjoi6LaF57qn566h55CG5ZGYIiwiZXhwIjoxNjQwOTU0NTM3LCJ1c2VyTmFtZSI6ImFkbWluIiwiaWF0IjoxNjQwOTU0NDc3LCJ1c2VySWQiOjF9.FDn3qk8h5Z3b0GBxQ1aBVVtiUYXrGcKWJ9gO0jxvO14', '2022-01-07 04:12:33', 0);
INSERT INTO `tb_token` VALUES (2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZG1pbiIsInJlYWxOYW1lIjoi6LaF57qn566h55CG5ZGYIiwiZXhwIjoxNjQwOTU0NTM3LCJ1c2VyTmFtZSI6ImFkbWluIiwiaWF0IjoxNjQwOTU0NDc3LCJ1c2VySWQiOjF9.FDn3qk8h5Z3b0GBxQ1aBVVtiUYXrGcKWJ9gO0jxvO14', '2022-01-07 04:12:33', 0);
INSERT INTO `tb_token` VALUES (3, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZG1pbiIsInJlYWxOYW1lIjoi6LaF57qn566h55CG5ZGYIiwiZXhwIjoxNjQwOTU0NTM3LCJ1c2VyTmFtZSI6ImFkbWluIiwiaWF0IjoxNjQwOTU0NDc3LCJ1c2VySWQiOjF9.FDn3qk8h5Z3b0GBxQ1aBVVtiUYXrGcKWJ9gO0jxvO14', '2022-01-07 04:12:33', 0);
INSERT INTO `tb_token` VALUES (4, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZG1pbiIsInJlYWxOYW1lIjoi6LaF57qn566h55CG5ZGYIiwiZXhwIjoxNjQwOTU0NTM3LCJ1c2VyTmFtZSI6ImFkbWluIiwiaWF0IjoxNjQwOTU0NDc3LCJ1c2VySWQiOjF9.FDn3qk8h5Z3b0GBxQ1aBVVtiUYXrGcKWJ9gO0jxvO14', '2022-01-07 04:12:33', 0);
INSERT INTO `tb_token` VALUES (5, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZG1pbiIsInJlYWxOYW1lIjoi6LaF57qn566h55CG5ZGYIiwiZXhwIjoxNjQwOTU0NTM3LCJ1c2VyTmFtZSI6ImFkbWluIiwiaWF0IjoxNjQwOTU0NDc3LCJ1c2VySWQiOjF9.FDn3qk8h5Z3b0GBxQ1aBVVtiUYXrGcKWJ9gO0jxvO14', '2022-01-07 04:12:33', 0);
INSERT INTO `tb_token` VALUES (6, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZG1pbiIsInJlYWxOYW1lIjoi6LaF57qn566h55CG5ZGYIiwiZXhwIjoxNjQwOTU0NTM3LCJ1c2VyTmFtZSI6ImFkbWluIiwiaWF0IjoxNjQwOTU0NDc3LCJ1c2VySWQiOjF9.FDn3qk8h5Z3b0GBxQ1aBVVtiUYXrGcKWJ9gO0jxvO14', '2022-01-07 04:12:33', 1);
INSERT INTO `tb_token` VALUES (7, 'bbbbbbbbbbbbb', '2022-01-07 04:12:33', 0);
INSERT INTO `tb_token` VALUES (9, 'bbbbbbbbbbbbb', NULL, 0);
INSERT INTO `tb_token` VALUES (8, 'bbbbbbbbbbbbb', NULL, 0);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码，加密存储',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册邮箱',
  `created` datetime NOT NULL COMMENT '创建时间',
  `updated` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `source_type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员来源：1:PC，2：H5，3：Android，4：IOS',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用状态（1正常 0非正常）',
  `head_pic` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ号码',
  `is_mobile_check` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '手机是否验证 （0否  1是）',
  `is_email_check` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '邮箱是否检测（0否  1是）',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '性别，1男，0女',
  `user_level` int NULL DEFAULT NULL COMMENT '会员等级',
  `points` int NULL DEFAULT 0 COMMENT '积分',
  `experience_value` int NULL DEFAULT NULL COMMENT '经验值',
  `birthday` datetime NULL DEFAULT NULL COMMENT '出生年月日',
  `last_login_time` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`username`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE,
  INDEX `username_2`(`username` ASC, `phone` ASC) USING BTREE,
  INDEX `phone`(`phone` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('Kili', '$2a$10$GBkRrEkHHx2uhJjasjpbO.Sb5DNNHGfWM4Z5sG2ZImTHp7b.dg0r6', '15800406868', 'lqjkok@foxmail.com', '2022-05-02 10:40:43', '2022-05-04 12:18:12', NULL, 'Kili', '李千军', NULL, 'http://static.lqjai.com/qjmall/img/mine/22d6c28bebf4eccd7499fd1b741253f.png', NULL, '0', '0', '1', NULL, 200, NULL, NULL, '2022-05-05 07:13:32');
INSERT INTO `tb_user` VALUES ('qianjun', '$2a$10$fMLh.qvJCxpJBrQTM5b26eRU81TNZuKFUKfbDRasB8eoqsaAFarY6', '13036753489', NULL, '2022-05-21 08:01:03', '2023-12-12 21:11:00', NULL, NULL, NULL, NULL, 'http://static.lqjai.com/qjmall/img/mine/22d6c28bebf4eccd7499fd1b741253f.png', NULL, '0', '0', '1', NULL, 100, NULL, NULL, '2023-12-12 13:11:00');
INSERT INTO `tb_user` VALUES ('sttjhd', '$2a$10$Xi1e/FQbDTZqE/PYdtQHIufj760AEtLsNw1hfygv/vuExvFx7OiE2', '15124307834', NULL, '2023-03-27 09:41:17', '2023-03-27 22:31:55', NULL, NULL, NULL, NULL, 'http://static.lqjai.com/qjmall/img/mine/22d6c28bebf4eccd7499fd1b741253f.png', NULL, '0', '0', '1', NULL, 100, NULL, NULL, '2023-03-27 14:31:55');
INSERT INTO `tb_user` VALUES ('test', '$2a$10$Scnlf89ioJrClDbXYk6B4OUVc3WPk5nOf6G/yXiODRvDXG8tT7pj2', '18207407968', NULL, '2022-05-05 07:12:43', '2022-06-17 16:09:23', NULL, NULL, NULL, NULL, 'http://static.lqjai.com/qjmall/img/mine/22d6c28bebf4eccd7499fd1b741253f.png', NULL, '0', '0', '1', NULL, 100, NULL, NULL, '2022-06-17 08:09:23');
INSERT INTO `tb_user` VALUES ('xiangting', '$2a$10$laAgPM8AtWPAFt5EdVyPx.fcLNpNMOUads5V.Kwi3Nl17Pcto9PNi', '18302143872', NULL, '2022-06-04 08:10:47', '2022-06-04 16:41:20', NULL, NULL, NULL, NULL, 'http://static.lqjai.com/qjmall/img/mine/22d6c28bebf4eccd7499fd1b741253f.png', NULL, '0', '0', '1', NULL, 100, NULL, NULL, '2022-06-04 08:41:21');
INSERT INTO `tb_user` VALUES ('xux', '$2a$10$jWqrWhFK40eyQB7InATRjuY4ZWIMz8AZxJv4xHohYTpcK4We4TGqu', '15505217645', NULL, '2023-07-12 08:03:54', '2023-07-12 16:04:18', NULL, NULL, NULL, NULL, 'http://static.lqjai.com/qjmall/img/mine/22d6c28bebf4eccd7499fd1b741253f.png', NULL, '0', '0', '1', NULL, 100, NULL, NULL, '2023-07-12 08:04:18');

SET FOREIGN_KEY_CHECKS = 1;
