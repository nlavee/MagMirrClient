# NOTE: THIS SCRIPT IS DESTRUCTIVE! 
# It will reset the database back to its initial state

drop database if exists magmirr;

create database magmirr;

grant all on magmirr.* to magmirr_web identified by 'restendingpoint';

use magmirr;

create table user (
	id integer(10) auto_increment not null,
	username varchar(50) unique not null,
	first_name varchar(50),
	last_name varchar(50),
	email varchar(50),
	password_id integer(10),
	uber_id varchar(50),
	weather_id varchar(50),
	primary key (id)
);

create table password (
	id integer(10) auto_increment not null,
	pw_hash varchar(100) not null,
	salt varchar(100) not null,
	primary key (id)
);

create table privilege (
	id integer(10) auto_increment not null,
	privilege_description varchar(50) not null,
	privilege_name varchar(50) not null,
	primary key (id)
);

create table message (
	id integer(10) auto_increment not null,
	user_id integer(10) not null,
	timestamp date not null,
	body varchar(100) not null,
	primary key (id)
);

create table mirror (
	id integer(10) auto_increment not null,
	mirror_IP_address varchar(100) not null,
	primary key (id)
);

create table mirror_user (
	id integer(10) auto_increment not null,
	mirror_id integer(10) not null,
	user_id integer(10) not null,
	privilege_id integer(10) not null,
	primary key (id)
);

create table news (
	id integer(10) auto_increment not null,
	section_name varchar(100) not null,
	primary key (id)
);

create table news_user (
	id integer(10) auto_increment not null,
	news_id integer(10) not null,
	user_id integer(10) not null,
	primary key (id)
);

create table uber_API (
	id integer(10) auto_increment not null,
	key_api varchar(200) not null,
	secret_api varchar(200) not null,
	primary key (id)
);

create table weather (
	id integer(10) auto_increment not null,
	zipcode integer(10) not null,
	user_id integer(10) not null,
	primary key (id)
);
