create database if not exists userservice;
use userservice;

create table if not exists role(
		role_id int primary key auto_increment,
        role_name varchar(225) not null unique,
        created_ts timestamp not null default current_timestamp
);


create table if not exists user(
		user_id int primary key auto_increment,
		email varchar(225) unique not null,
        username varchar(225) unique not null,
		password varchar(225) not null,
		phone_number varchar(10) unique not null,
        role_id int not null,
        is_email_verified boolean not null default false,
		is_phone_number_verified boolean not null default false,
		is_account_locked boolean not null default false,
        email_verified_ts timestamp null,
        phone_number_verified_ts timestamp null,
        registered_ts timestamp not null default current_timestamp,
        updated_ts timestamp null,
        
        foreign key user_role_id_fk(role_id) references role(role_id)
        
        
);
