drop database if exists jdbcall;

create database jdbcall;

use jdbcall;

drop table if exists ServletAuthWeb;


create table ServletAuthWeb(
	empId int NOT NULL AUTO_INCREMENT,
	empName varchar(25) NOT NULL,
	empEmail varchar(25) NOT NULL,
	empPassword varchar(12) NOT NULL,
	primary key(empId)
)

insert into ServletAuthWeb(empId,empName,empEmail,empPassword) values(1001,"Tharun","abc@gmail.com","tharun123");
commit;