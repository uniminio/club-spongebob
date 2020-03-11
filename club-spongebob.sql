/*
 Navicat Premium Data Transfer

 Source Server         : centos-腾讯云@root
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 106.54.81.207:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 10/03/2020 10:41:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Admin
-- ----------------------------
DROP TABLE IF EXISTS `Admin`;
CREATE TABLE `Admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `head_img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20200014 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for Article
-- ----------------------------
DROP TABLE IF EXISTS `Article`;
CREATE TABLE `Article`  (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `catalog_id` int(11) NULL DEFAULT NULL,
  `admin_id` int(11) NULL DEFAULT NULL,
  `title` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `keywords` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `summary` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pub_date` timestamp(0) NOT NULL,
  `click` int(11) NOT NULL,
  PRIMARY KEY (`article_id`) USING BTREE,
  INDEX `FK_article_admin`(`admin_id`) USING BTREE,
  INDEX `FK_article_catalog`(`catalog_id`) USING BTREE,
  CONSTRAINT `FK_article_admin` FOREIGN KEY (`admin_id`) REFERENCES `Admin` (`admin_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `FK_article_catalog` FOREIGN KEY (`catalog_id`) REFERENCES `Catalog` (`catalog_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for Catalog
-- ----------------------------
DROP TABLE IF EXISTS `Catalog`;
CREATE TABLE `Catalog`  (
  `catalog_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `descr` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`catalog_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_login_log
-- ----------------------------
DROP TABLE IF EXISTS `admin_login_log`;
CREATE TABLE `admin_login_log`  (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) NULL DEFAULT NULL,
  `login_time` timestamp(0) NOT NULL,
  `login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`log_id`) USING BTREE,
  INDEX `FK_login_log_admin`(`admin_id`) USING BTREE,
  CONSTRAINT `FK_login_log_admin` FOREIGN KEY (`admin_id`) REFERENCES `Admin` (`admin_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comm_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NULL DEFAULT NULL,
  `admin_id` int(11) NULL DEFAULT NULL,
  `comm_nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comm_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comm_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comm_time` timestamp(0) NOT NULL,
  `notify` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`comm_id`) USING BTREE,
  INDEX `FK_comment_article`(`article_id`) USING BTREE,
  INDEX `comment_Admin_admin_id_fk`(`admin_id`) USING BTREE,
  CONSTRAINT `FK_comment_article` FOREIGN KEY (`article_id`) REFERENCES `Article` (`article_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `comment_Admin_admin_id_fk` FOREIGN KEY (`admin_id`) REFERENCES `Admin` (`admin_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 20200019 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
