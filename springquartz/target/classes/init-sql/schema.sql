SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `sys_cron`;
CREATE TABLE `sys_cron` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `tgroup` varchar(11) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  `className` varchar(50) DEFAULT NULL,
  `expression` varchar(40) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_cron` VALUES (1,'klay1','g1', '测试任务1','com.cn.quarts.job.TestJob1','0/20 * * * * ?','1','2017-11-13 16:04:39');
INSERT INTO `sys_cron` VALUES (2,'klay2','g1', '测试任务2','com.cn.quarts.job.TestJob2','0/20 * * * * ?','1','2017-11-13 16:04:39');