CREATE TABLE `t_product` (
  `product_id` bigint(20) unsigned NOT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `t_product` (`product_id`, `count`) VALUES (5001, 100);
