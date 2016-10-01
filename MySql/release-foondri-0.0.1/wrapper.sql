/*
Created by: Rahul Prajapati
Date: 01/10/2016
*/

create database `foondri`;
create table if not exists `foondri`.`user_detail`(
	`id` bigint not null auto_increment,
	`mobile` varchar(10) not null,
	`email` varchar(255) default null,
	`password` varchar(100) not null,
	`address` mediumtext not null,
	`created_at` timestamp not null default current_timestamp,
	`updated_at` timestamp not null,
	primary key (id),
	unique key (mobile, email)
);

create table if not exists `foondri`.`item`(
	`id` bigint not null auto_increment,
	`item_name` varchar(255) not null,
	`dicription` mediumtext,
	`inventory` int not null default 0,
	`mrp` decimal not null,
	`selling_price` decimal not null,
	`rating` decimal default 5, 
	`created_at` timestamp not null default current_timestamp,
	`updated_at` timestamp not null,
	primary key (id),
	unique key (item_name)
);

create table if not exists `foondri`.`order`(
	`id` bigint not null auto_increment,
	`item_count` int not null,
	`order_amout` decimal not null,
	`promo_value` decimal default null,
	`net_payable_amount` decimal not null,
	`user_id` bigint not null,
	`user_mobile` varchar(10) not null,
	`user_email` varchar(255) default null,
	`delivery_address` mediumtext not null,
	`is_delevered` tinyint,
	`created_at` timestamp not null default current_timestamp,
	`updated_at` timestamp not null,
	primary key (id),
	foreign key fk_user_id (user_id) references `foondri`.`user_detail`(id)
);

create table if not exists `foondri`.`sub_order`(
	`id` bigint not null auto_increment,
	`order_id` int not null,
	`item_id` bigint not null,
	`item_name` varchar(255) not null,
	`item_count` int not null default 1,
	`sub_order_amount` decimal not null,
	`promo_code` varchar(48) default null,
	`promo_value` decimal default null,
	`net_payable_amount` decimal not null,
	`created_at` timestamp not null default current_timestamp,
	`updated_at` timestamp not null,
	primary key (id),
	unique key(id, order_id),
	foreign key fk_item_id (item_id) references `foondri`.`item`(id)
	-- foreign key fk_order_id (order_id) references `foondri`.`order`(id)
);


create table if not exists `foondri`.`promo_code_item_filter`(
	`id` bigint not null auto_increment,
	`promo_code_id` bigint not null,
	`created_at` timestamp not null default current_timestamp,
	`updated_at` timestamp not null,
	primary key (id,promo_code_id)
);

create table if not exists `foondri`.`promo_code`(
	`id` bigint not null auto_increment,
	`code` varchar(48) not null,
	`promo_code_type` varchar(48),
	`value` int not null,
	`min_purchage_value` int default 0,
	`max_discount` int not null,
	`value_used` int,
	`max_value_used` int not null,
	`promo_code_item_filter_id` bigint not null,
	`created_by` varchar(255),
	`created_at` timestamp not null default current_timestamp,
	`updated_at` timestamp not null,
	primary key (id),
	unique key(code),
	foreign key fk_promo_code_item_filter_id (promo_code_item_filter_id) references `foondri`.`promo_code_item_filter`(id)
);