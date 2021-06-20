
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_book
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
                           `id` int(5)  NOT NULL AUTO_INCREMENT,
                           `name` varchar(40) NOT NULL,
                           `title` varchar(20) NOT NULL,
                           `content` varchar(50) NOT NULL,
                           `time` varchar(20) NOT NULL,
                            PRIMARY KEY (`id`),
                            FOREIGN KEY (`name`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_book
-- ----------------------------
INSERT INTO `message` VALUES ('1', '小域', '今日天气', '天气好!','2021-6-2');
INSERT INTO `message` VALUES ('2', '小域', '今天天气', '天气坏！', '2021-6-2');
INSERT INTO `message` VALUES ('3', '小鸣', '刘慈欣小说', '好看！！', '2021-6-2');


-- ----------------------------
-- Table structure for tb_booktype
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                         `id` int(5) NOT NULL AUTO_INCREMENT,
                         `username` varchar(40) NOT NULL,
                         `password` varchar(20) NOT NULL,
                         `roled` int NOT NULL,
                         `status` int NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
--唯一性约束，作为message的外键
--外键不一定是管理表的主键，只要是管理表的唯一性约束就行{主键、唯一性索引}
ALTER TABLE `users` ADD unique(`username`);
-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '1234','1','0');
INSERT INTO `users` VALUES ('2', '小域', '1234','2','0');
INSERT INTO `users` VALUES ('3', '小鸣', '1234','2','1');
--测试
INSERT INTO `users` VALUES (null, '小金p', '20210609','2','1');
