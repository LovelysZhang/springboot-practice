DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表主键,身份编号',
                        `username` varchar(20) NOT NULL DEFAULT '' COMMENT '姓名',
                        `sex` tinyint(4) NOT NULL DEFAULT '1' COMMENT '性别(女:0 男:1)',
                        `age` tinyint(4) NOT NULL DEFAULT '0' COMMENT '年龄',
                        `note` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
                        `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `uniq_name` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;
