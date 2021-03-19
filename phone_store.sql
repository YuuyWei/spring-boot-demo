CREATE DATABASE `phone_store_demo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- phone_store_demo.buyer_address definition

CREATE TABLE `buyer_address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `buyer_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家地址',
  `area_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址编码',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='收货地址表';

INSERT INTO phone_store_demo.buyer_address (buyer_name,buyer_phone,buyer_address,area_code,update_time,create_time) VALUES
('张三','13678900987','北京市北京市东城区168号306室','110101','2021-03-18 17:22:26.0','2021-03-18 17:22:26.0')
,('张三','12456543321','北京市北京市西城区168号306室','110102','2021-03-18 20:54:15.0','2021-03-18 20:50:53.0')
,('毕达哥拉斯','12345678901','天津市天津市河东区建设大道45号','120102','2021-03-18 20:55:55.0','2021-03-18 20:55:55.0')
;

-- phone_store_demo.order_master definition

CREATE TABLE `order_master` (
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `buyer_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家地址',
  `phone_id` int DEFAULT NULL COMMENT '商品编号',
  `phone_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品名称',
  `phone_quantity` int DEFAULT NULL COMMENT '商品数量',
  `phone_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品小图',
  `specs_id` int DEFAULT NULL COMMENT '规格编号',
  `specs_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '规格名称',
  `specs_price` decimal(8,2) DEFAULT NULL COMMENT '规格单价',
  `order_amount` decimal(8,2) NOT NULL COMMENT '订单总金额',
  `pay_status` tinyint NOT NULL DEFAULT '0' COMMENT '支付状态，默认0未支付',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单表';
INSERT INTO phone_store_demo.order_master (order_id,buyer_name,buyer_phone,buyer_address,phone_id,phone_name,phone_quantity,phone_icon,specs_id,specs_name,specs_price,order_amount,pay_status,create_time,update_time) VALUES
('1616061889072797294','张三','13678787878','广东省深圳市罗湖区科技路123号456室',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'32GB',280000.00,2800.00,0,'2020-04-01 18:03:08.0','2021-03-18 15:20:30.0')
,('1616062080344786087','张三','13678787878','广东省深圳市罗湖区科技路123号456室',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'32GB',280000.00,2800.00,1,'2020-04-01 18:03:08.0','2021-03-18 15:20:30.0')
,('1616071851109630887','张三','13678787878','广东省深圳市罗湖区科技路123号456室',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'32GB',280000.00,2810.00,0,'2020-04-01 18:03:08.0','2021-03-18 15:20:30.0')
,('1616076807068144277','张三','13678900987','北京市北京市东城区168号306室',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',2,'64GB',320000.00,3210.00,1,'2020-04-01 18:03:08.0','2021-03-18 20:53:18.0')
,('1616077676498240016','张三','12456543321','北京市北京市西城区168号306室',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'32GB',280000.00,2810.00,1,'2020-04-01 18:03:08.0','2021-03-18 20:53:18.0')
,('1616078654069211856','毕达哥拉斯','12345678901','天津市天津市河东区建设大道45号',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',2,'64GB',320000.00,3210.00,0,'2020-04-01 18:03:08.0','2021-03-18 20:53:18.0')
,('1616078654252757408','毕达哥拉斯','12345678901','天津市天津市河东区建设大道45号',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',2,'64GB',320000.00,3210.00,1,'2020-04-01 18:03:08.0','2021-03-18 20:53:18.0')
,('1616079079038367956','毕达哥拉斯','12345678901','天津市天津市河东区建设大道45号',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'32GB',280000.00,2810.00,1,'2020-04-01 18:03:08.0','2021-03-18 20:53:18.0')
,('1616079079239725143','毕达哥拉斯','12345678901','天津市天津市河东区建设大道45号',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'32GB',280000.00,2810.00,0,'2020-04-01 18:03:08.0','2021-03-18 20:53:18.0')
,('1616079357730208131','毕达哥拉斯','12345678901','天津市天津市河东区建设大道45号',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'32GB',280000.00,2810.00,1,'2020-04-01 18:03:08.0','2021-03-18 22:55:39.0')
;
INSERT INTO phone_store_demo.order_master (order_id,buyer_name,buyer_phone,buyer_address,phone_id,phone_name,phone_quantity,phone_icon,specs_id,specs_name,specs_price,order_amount,pay_status,create_time,update_time) VALUES
('1616079393902312713','张三','12456543321','北京市北京市西城区168号306室',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'32GB',280000.00,2810.00,1,'2020-04-01 18:03:08.0','2021-03-18 22:55:39.0')
,('1616133862808580429','毕达哥拉斯','12345678901','天津市天津市河东区建设大道45号',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',2,'64GB',320000.00,3210.00,1,'2020-04-01 18:03:08.0','2021-03-18 22:55:39.0')
;

-- phone_store_demo.phone_category definition

CREATE TABLE `phone_category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类目名称',
  `category_type` int NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `uqe_category_type` (`category_type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='类目表';

INSERT INTO phone_store_demo.phone_category (category_name,category_type,create_time,update_time) VALUES
('魅焰红',1,'2020-04-01 18:39:43.0','2020-04-01 20:35:54.0')
,('极光蓝',2,'2020-04-01 18:39:43.0','2020-04-01 20:35:54.0')
,('铂光金',3,'2020-04-01 18:39:43.0','2020-04-01 20:35:54.0')
,('幻夜黑',4,'2020-04-01 18:39:43.0','2020-04-01 20:35:54.0')
;

-- phone_store_demo.phone_info definition

CREATE TABLE `phone_info` (
  `phone_id` int NOT NULL AUTO_INCREMENT,
  `phone_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `phone_price` decimal(8,2) NOT NULL COMMENT '商品单价',
  `phone_description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `phone_stock` int NOT NULL COMMENT '库存',
  `phone_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '小图',
  `category_type` int NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `phone_tag` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`phone_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品表';

INSERT INTO phone_store_demo.phone_info (phone_name,phone_price,phone_description,phone_stock,phone_icon,category_type,create_time,update_time,phone_tag) VALUES
('Honor 8A',2800.00,'魅焰红',3,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'2020-04-01 18:03:08.0','2021-03-18 22:55:39.0','720P珍珠屏&Micro USB接口')
,('Honor 10 青春版',2800.00,'极光蓝',100,'../static/8f0bd0d0-a11e-4185-927e-04b54ff4a1bd.jpg',2,'2020-04-01 18:03:08.0','2020-04-01 22:30:42.0','720P珍珠屏&EMUI9 Lite')
,('Honor V20',3450.00,'铂光金',100,'../static/fd7fee3c-a35c-477b-b007-9fda6e9c589a.jpg',3,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','2+1独立三卡槽')
,('HUAWEI Mate 20 Pro',4550.00,'幻夜黑',100,'../static/cb819ad9-ec6f-4123-a4e9-aa629e2f8224.jpg',4,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','内存3GB&EMUI9 Lite')
,('HUAWEI nova 5 Pro',5450.00,'魅焰红',100,'../static/8a0f5be0-3c78-4f23-b58b-dc2a92f1f95a.jpg',1,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','内存3GB&Micro USB接口')
,('HUAWEI P30',8700.00,'极光蓝',100,'../static/6dcad185-315f-40f0-87f2-52910f49c8b7.jpg',2,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','720P珍珠屏&内存3GB')
,('HUAWEI P30 Pro',8988.00,'铂光金',100,'../static/b12a46a9-3738-49ab-ab3a-6878539bd76b.jpg',3,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','720P珍珠屏&Micro USB接口')
,('HUAWEI 畅想9 Plus',2760.00,'幻夜黑',100,'../static/15a5dcf2-4b50-41a0-93e8-08df97c21341.jpg',4,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','内存3GB&存储32GB')
,('SAMSUNG G S10',7254.00,'魅焰红',100,'../static/a4f0cef8-59da-4f7c-abfa-d373f6648035.jpg',1,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','720P珍珠屏&存储32GB')
,('OPPO K3',2889.00,'极光蓝',100,'../static/efc31538-a1f0-4dba-a673-4369f17e5708.jpg',2,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','存储32GB&Micro USB接口')
;
INSERT INTO phone_store_demo.phone_info (phone_name,phone_price,phone_description,phone_stock,phone_icon,category_type,create_time,update_time,phone_tag) VALUES
('Iphone XR',9888.00,'铂光金',100,'../static/4ef5a3c0-ad88-495f-a6bc-a31c1dde667b.jpg',3,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','1300万像素&Micro USB接口')
,('MI 8',5888.00,'幻夜黑',100,'../static/aff8224c-3196-42a9-ae9e-4f06e20555c4.jpg',4,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','内存3GB&存储32GB')
,('VIVO X27',2888.00,'魅焰红',100,'../static/cdf065ec-e409-4204-93e6-600e172e461a.jpg',1,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','F/1.8光圈&Micro USB接口')
,('Iphone 6',5678.00,'极光蓝',100,'../static/899a9c64-62d0-416d-b320-e730b4585cb0.jpg',2,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','720P珍珠屏&F/1.8光圈')
,('Iphone 7',5576.00,'铂光金',100,'../static/67aa6e9b-681f-4a6f-aae4-97eb3ec51b08.jpg',3,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','720P珍珠屏&1300万像素')
,('Iphone 8',6212.00,'幻夜黑',100,'../static/a8b5b846-7fbb-4e7b-abcf-01ae73979000.jpg',4,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','内存3GB&F/1.8光圈')
,('Meizu 16s',1220.00,'魅焰红',100,'../static/1a2b8e30-6e98-405f-9a18-9cd31ff96c35.jpg',1,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','720P珍珠屏&Micro USB接口')
,('Iphone X',6770.00,'极光蓝',100,'../static/39197368-aeaf-48ea-b399-5ad65f7b6c47.jpg',2,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','F/1.8光圈&Micro USB接口')
,('HUAWEI P20',5580.00,'铂光金',100,'../static/f382351b-7fc8-4b34-bcce-162085e75191.jpg',3,'2020-04-01 18:14:54.0','2020-04-01 22:30:42.0','1300万像素&Micro USB接口')
;

-- phone_store_demo.phone_specs definition

CREATE TABLE `phone_specs` (
  `specs_id` int NOT NULL AUTO_INCREMENT,
  `phone_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `specs_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格名称',
  `specs_stock` int NOT NULL COMMENT '库存',
  `specs_price` decimal(8,2) NOT NULL COMMENT '单价',
  `specs_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '小图',
  `specs_preview` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '预览图',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`specs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品规格表';

INSERT INTO phone_store_demo.phone_specs (phone_id,specs_name,specs_stock,specs_price,specs_icon,specs_preview,update_time,create_time) VALUES
('1','32GB',1,280000.00,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg','../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg','2021-03-18 22:54:52.0','2020-04-01 22:16:36.0')
,('1','64GB',2,320000.00,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg','../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg','2021-03-18 22:55:41.0','2020-04-01 22:16:36.0')
;