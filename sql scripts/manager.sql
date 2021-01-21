drop database if exists customercdkomp;
create database customercdkomp;
use customercdkomp;

create table customer(
customer_id int auto_increment primary key not null,
owner varchar(200) not null,
address varchar(200) not null,
phone_number int not null
);

insert into customer values
(1, "Krzysztof Denisiuk", "street 1", 123456789),
(2, "Denisiuk Krzysztof", "street 18", 111155555),
(3, "John Smith", "street 40", 000000000);

create table details(
customer_id int,
id int auto_increment primary key,
delivered tinyint(1),
received varchar(200),
returned varchar(200),
manufacturer varchar(200),
manufacturer_pattern varchar(200),
pattern_number varchar(200),
symptoms varchar(1000),
repair varchar(1000),
power_supply varchar(200),
battery tinyint(1),
comments varchar(1000),
document_internal varchar(200),
document_external varchar(200),
document_warranty varchar(200),
foreign key (customer_id) references customer(customer_id)
);

