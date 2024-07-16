create table person
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);


INSERT INTO person
(ID,NAME,LOCATION,BIRTH_DATE)
VALUES
(1001,'tarun','bng',current_date()),
(1002,'revo','hyd',current_date()),
(1003,'ramesh','bng',current_date());