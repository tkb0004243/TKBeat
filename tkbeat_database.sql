-- --------------------------------------------------------
-- 主機:                           127.0.0.1
-- 伺服器版本:                        10.5.6-MariaDB - mariadb.org binary distribution
-- 伺服器作業系統:                      Win64
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 傾印 tkbeat 的資料庫結構
CREATE DATABASE IF NOT EXISTS `tkbeat` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tkbeat`;

-- 傾印  資料表 tkbeat.user 結構
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) NOT NULL DEFAULT '0' COMMENT '帳號',
  `password` varchar(50) NOT NULL DEFAULT '0' COMMENT '密碼',
  `name` varchar(50) NOT NULL DEFAULT '0' COMMENT '姓名',
  `phone` varchar(50) DEFAULT NULL COMMENT '電話號碼',
  `status` varchar(50) NOT NULL DEFAULT '0' COMMENT '狀態',
  `create_by` varchar(50) NOT NULL DEFAULT '系統建立' COMMENT '創建者',
  `update_by` varchar(50) NOT NULL DEFAULT '系統更新' COMMENT '更新者',
  `create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '創建時間',
  `update_time` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新時間',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='會員資料';

-- 取消選取資料匯出。

-- 傾印  資料表 tkbeat.user_info 結構
CREATE TABLE IF NOT EXISTS `user_info` (
  `user_info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '會員個人資料唯一值',
  `age` int(11) NOT NULL DEFAULT 0 COMMENT '會員年齡',
  `real_name` varchar(50) NOT NULL DEFAULT '0' COMMENT '會員真實姓名',
  `address` varchar(100) NOT NULL DEFAULT '0' COMMENT '會員住址',
  `profile` varchar(50) NOT NULL DEFAULT '0' COMMENT '會員頭像',
  `email` varchar(100) DEFAULT '0' COMMENT '會員電子郵件',
  PRIMARY KEY (`user_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='user的子表單(負責記錄會員的個人資訊)';

-- 取消選取資料匯出。

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
