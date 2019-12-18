DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment,
  `rid` int(11) NOT NULL,
  `username` varchar(30) default NULL,
  `password` varchar(30) default NULL,
  `realname` varchar(30) default NULL,
  `phone` varchar(30) default NULL,
  `email` varchar(30) default NULL,
  `address` varchar(30) default NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`roleid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `users`(`id`,`rid`,`username`,`password`,`realname`,`phone`,`email`,`address`) values (1,1,'saleManage_one','123456','陈某某','135256321447','421@qq.com','广东东莞');
insert  into `users`(`id`,`rid`,`username`,`password`,`realname`,`phone`,`email`,`address`) values (2,4,'sale_one','123456','页某某','135256321447','421@qq.com','广东东莞');



DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NUL auto_increment,
  `rolename` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `role`(`id`,`rolename`) values (1,'超级管理员'),(2,'销售管理员'),(3,'仓库管理员'),(4,'销售员');


DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL auto_increment,
  `menuname` varchar(30) default NULL,
  `parid` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `permission`(`id`,`menuname`,`parid`) values (1,'合同管理',null);


DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL auto_increment,
  `roleid` int(11) NOT NULL,
  `permissionid` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`roleid`) REFERENCES `role` (`id`),
  FOREIGN KEY (`permissionid`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `role_permission`(`id`,`roleid`,`permissionid`) values (1,1,1);


DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(30) default NULL,
  `phone` varchar(30) default NULL,
  `email` varchar(30) default NULL,
  `address` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `customer`(`id`,`name`,`phone`,`email`,`address`) values (1,'梁某某','13545236558','2132@qq.com','广东东莞');
insert  into `customer`(`id`,`name`,`phone`,`email`,`address`) values (2,'陈某某','13545236558','2132@qq.com','广东东莞');

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(30) default NULL,
  `price` int(11) default NULL,
  `nums` int(11) default NULL,
  `minn` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `goods`(`id`,`name`,`price`,`nums`,`minn`) values (1,'木材',55,1200,50);
insert  into `goods`(`id`,`name`,`price`,`nums`,`minn`) values (2,'钢板',125,1200,40);
insert  into `goods`(`id`,`name`,`price`,`nums`,`minn`) values (3,'水泥',66,1200,30);

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `id` int(11) NOT NULL auto_increment,
  `ispay` int(2) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `purchase`(`id`,`ispay`) values (1,1);
insert  into `purchase`(`id`,`ispay`) values (2,0);


DROP TABLE IF EXISTS `purchase_goods`;
CREATE TABLE `purchase_goods` (
  `id` int(11) NOT NULL auto_increment,
  `purchaseid` int(11) NOT NULL,
  `goodsid` int(11) NOT NULL,
  `quantity` int(11) default NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`purchaseid`) REFERENCES `purchase` (`id`),
  FOREIGN KEY (`goodsid`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `purchase_goods`(`id`,`purchaseid`,`goodsid`,`quantity`) values (1,1,1,250);
insert  into `purchase_goods`(`id`,`purchaseid`,`goodsid`,`quantity`) values (2,1,2,550);

DROP TABLE IF EXISTS `customer_purchase`;
CREATE TABLE `customer_purchase` (
  `id` int(11) NOT NULL auto_increment,
  `purchaseid` int(11) NOT NULL,
  `customerid` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`purchaseid`) REFERENCES `purchase` (`id`),
  FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `customer_purchase`(`id`,`purchaseid`,`customerid`) values (1,1,1);


DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `id` int(11) NOT NULL auto_increment,
  `customerid` int(11) NOT NULL,
  `purchaseid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `start_time` timestamp,
  `end_time` timestamp,
  `fahuoid` int(11) default NULL,
  `jinhuoid` int(11) default NULL,
  `totalmoney` int(11) default NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
  FOREIGN KEY (`purchaseid`) REFERENCES `purchase` (`id`),
  FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `contract`(`id`,`customerid`,`purchaseid`,`userid`,`start_time`,`end_time`,`fahuoid`,`jinhuoid`,`totalmoney`) values (1,1,1,2,'0000-00-00 00:00:00','0000-00-00 00:00:00',null,null,null);



DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics` (
  `id` int(11) NOT NULL auto_increment,
  `times` timestamp NOT NULL,
  `context` varchar(30),
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `id` int(11) NOT NULL auto_increment,
  `purchase_goodsid` int(11) NOT NULL,
  `issent` int(2) NOT NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`purchase_goodsid`) REFERENCES `purchase_goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `invoice_logistics`;
CREATE TABLE `invoice_logistics` (
  `id` int(11) NOT NULL auto_increment,
  `invoiceid` int(11) NOT NULL,
  `logisticsid` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`invoiceid`) REFERENCES `invoice` (`id`),
  FOREIGN KEY (`logisticsid`) REFERENCES `logistics` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `buyorder`;
CREATE TABLE `buyorder` (
  `id` int(11) NOT NULL auto_increment,
  `goodsquantityid` int(11) NOT NULL,
  `goodsname` varchar(40) NOT NULL,
  `minquantity` int(11) NOT NULL,
  `realquantity` int(11) NOT NULL,
  `isbuy` int(2) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




