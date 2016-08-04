
CREATE TABLE BOOK
(
	BOOKNUM  int not null auto_increment,
	TITLE                VARCHAR(30) not NULL,
	AUTHOR               VARCHAR(20) not NULL,
	PUBLISHER            VARCHAR(20) not NULL,
	PUB_DATE             DATE not NULL,
	PRICE                INTEGER not NULL,
    sal integer default 0,
    hwp varchar(150) not null,
    img varchar(150) not null,
    genre varchar(100) not null,
    summary text,
    
    
    primary key(booknum)
);

CREATE TABLE BUY
(
	BUYNUM               INTEGER NOT NULL auto_increment,
	MEMNUM               INTEGER NOT NULL,
	BOOKNUM              INTEGER NOT NULL,
	BUY_DATE             DATETIME NULL,
	p_way 				varchar(20) not null,
	final_pay			INTEGER NOT NULL,
	primary key(buynum),
	
    unique key (MEMNUM,BOOKNUM)
);



CREATE TABLE MEMBER
(
	MEMNUM               INTEGER NOT NULL auto_increment,
	ID                   VARCHAR(20) NULL,
	NICKNAME             VARCHAR(20) NULL,
	PASSWORD             VARCHAR(200) NULL,
	POINT				INTEGER NOT NULL,
	
	primary key(memnum),
    unique key (ID)
);

create table shop_bag
(
	bagnum integer not null auto_increment,
	booknum integer not null,
	memnum integer not null,
	primary key(bagnum),
    unique key (booknum,memnum)
);



CREATE TABLE MYBOOK
(
	MYBOOKNUM            INTEGER NOT NULL auto_increment,
	BOOKMARK             INTEGER NULL,
	memnum				 integer not null,
	primary key(mybooknum)
);
