drop database if exists customercdkomp;
create database customercdkomp;
use customercdkomp;

create table customer(
customer_id int auto_increment primary key not null,
owner varchar(200) not null,
address varchar(200) not null,
phone_number int not null,
email varchar(200) 
);

insert into customer values
(1, "Krzysztof Denisiuk", "ulica 1", 123456789, "kdenisiuk1993@gmail.com"),
(2, "Sebastian Gałecki", "stołowa 18", 123456789, ""),
(3, "John Smith", "street 40", 444555666, ""),
(4, "Jan Kowalski", "ulicowa 18", 777888999, ""),
(5, "John Wick", "pieskowa 10", 888999777, "");

create table details(
customer_id int,
id int auto_increment primary key,
delivered tinyint(1),
received date,
returned date,
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

insert into details values
(1, 1, false, "2021-01-10", "2021-01-15", "Asus", "x54hr", "0001", "broken", "fixed", "true", true, "", "", "", ""),
(1, 2, false , "2021-01-15", "2021-01-18", "HP", "ProBook", "G3", "broken", "fixed", "true", true, "", "", "", ""),
(1, 3, false , "2021-01-15", "2021-01-16", "Lenovo", "G20", "07", "broken", "fixed", "true", true, "", "", "", ""),
(1, 4, false , "2021-01-15", "2021-01-17", "Dell", "KM", "500", "broken", "fixed", "true", true, "", "", "", ""),
(2, 5, false , "2021-01-17", "2021-01-19", "Razer", "08", "100", "broken", "fixed", "true", true, "", "", "", "");

create table mail(
template_id int auto_increment primary key not null,
subject varchar(200),
text varchar(500),
address varchar(200)
);