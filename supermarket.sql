drop database supermarket;
create database supermarket;
use supermarket;

create table customer (
	mob_no varchar(10),
	name varchar(30),
	primary key(mob_no)	
);

create table product (
	code varchar(20),
	name varchar(30),
	price double(8, 2),
	category varchar(20),
	avail_quant int,
	primary key(code)
);

create table distributor (
	id int not null auto_increment,
	name varchar(30),
	mob_no varchar(10),
	email varchar(30),
	primary key(id)
);

create table placedOrder (
	order_id int not null auto_increment,
	date_time datetime,
	mob_no varchar(10),
	total_amt int,
	primary key(order_id),
	foreign key (mob_no) references customer(mob_no) on delete cascade
);


create table stockOrder (
	stock_id int not null auto_increment,
	date_time datetime,
	primary key(stock_id)
);

create table order_product (
	order_id int,
	code varchar(20),
	ordered_quant int,
	primary key(order_id, code),
	foreign key (order_id) references placedOrder(order_id) on delete cascade,
	foreign key (code) references product(code) on delete cascade
);

create table product_stockOrder (
	stock_id int,
	code varchar(20),
	given_quant int,
	primary key(stock_id, code),
	foreign key (stock_id) references stockOrder(stock_id) on delete cascade,
	foreign key (code) references product(code) on delete cascade
);

create table dist_stockOrder (
	id int,
	stock_id int,
	status varchar(10),
	check (status in ('ordered', 'received')),
	primary key(stock_id, id),	
	foreign key (id) references distributor(id) on delete cascade,
	foreign key (stock_id) references stockOrder(stock_id) on delete cascade	
)
