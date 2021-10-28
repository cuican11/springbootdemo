CREATE TABLE `product_lock` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `product_no` varchar(255) DEFAULT NULL COMMENT '产品编号',
    `stock` int(11) DEFAULT NULL COMMENT '库存量',
    `version` int(11) DEFAULT NULL COMMENT '版本号',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique` (`id`) USING BTREE)
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品信息表';