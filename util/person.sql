create table Person 
(

personId INTEGER default AUTOINCREMENT: start 1 increment 1 not null primary key,
firstName varchar(100),
lastName varchar(100),
street varchar(100),
postalCode int,
city varchar(100),
birthday varchar(10)

)