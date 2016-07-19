
CREATE TABLE BOOK
(
	BOOKNUM  int not null auto_increment,
	TITLE                VARCHAR(30) not NULL,
	AUTHOR               VARCHAR(20) not NULL,
	PUBLISHER            VARCHAR(20) not NULL,
	PUB_DATE             DATE not NULL,
	PRICE                INTEGER not NULL,
    sal integer not null,
    img varchar(150) null,
    summary text,
    primary key(booknum)
);


insert into book(title,author,publisher,pub_date,price,sal,img,summary) values('�޺�������2','����','��ũ�̵��','2007-01-15',4000,0,'�̹����̸�','~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.~~~~~~~~~~~~~~~~~~~~~~.`~.2@!>3!@>43!@>$!@>$1$>>���������������������Ϥ����Ƥӷ����Ӥ���');
insert into book(title,author,publisher,pub_date,price,sal,img,summary) values('�޺�������3','����','��ũ�̵��','2007-01-15',4000,0,'�̹����̸�','~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.~~~~~~~~~~~~~~~~~~~~~~.`~.2@!>3!@>43!@>$!@>$1$>>���������������������Ϥ����Ƥӷ����Ӥ���');
insert into book(title,author,publisher,pub_date,price,sal,img,summary) values('�޺�������4','����','��ũ�̵��','2007-01-15',4000,0,'�̹����̸�','~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.~~~~~~~~~~~~~~~~~~~~~~.`~.2@!>3!@>43!@>$!@>$1$>>���������������������Ϥ����Ƥӷ����Ӥ���');
insert into book(title,author,publisher,pub_date,price,sal,img,summary) values('�޺�������5','����','��ũ�̵��','2007-01-15',4000,0,'�̹����̸�','~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.~~~~~~~~~~~~~~~~~~~~~~.`~.2@!>3!@>43!@>$!@>$1$>>���������������������Ϥ����Ƥӷ����Ӥ���');

CREATE TABLE BUY
(
	BUYNUM               INTEGER NOT NULL,
	MEMNUM               INTEGER NOT NULL,
	BOOKNUM              INTEGER NOT NULL,
	BUY_DATE             DATE NULL
);

ALTER TABLE BUY
ADD CONSTRAINT XPKBUY PRIMARY KEY (BUYNUM);

CREATE TABLE MANAGER
(
	MANAGERNUM           INTEGER NOT NULL,
	ID                   VARCHAR(20) NULL,
	PASSWORD             VARCHAR(20) NULL,
	NICKNAME             VARCHAR(20) NULL
);

ALTER TABLE MANAGER
ADD CONSTRAINT XPKMANAGER PRIMARY KEY (MANAGERNUM);

CREATE TABLE MEMBER
(
	MEMNUM               INTEGER NOT NULL,
	ID                   VARCHAR(20) NULL,
	NICKNAME             VARCHAR(20) NULL,
	PASSWORD             VARCHAR(20) NULL
);

ALTER TABLE MEMBER
ADD CONSTRAINT XPKMEMBER PRIMARY KEY (MEMNUM);

CREATE TABLE MYBOOK
(
	MYBOOKNUM            INTEGER NOT NULL,
	BOOKMARK             INTEGER NULL,
	BUYNUM               INTEGER NOT NULL
);

ALTER TABLE MYBOOK
ADD CONSTRAINT XPKMYBOOK PRIMARY KEY (MYBOOKNUM);

ALTER TABLE BUY
ADD CONSTRAINT R_2 FOREIGN KEY (MEMNUM) REFERENCES MEMBER (MEMNUM);

ALTER TABLE BUY
ADD CONSTRAINT R_3 FOREIGN KEY (BOOKNUM) REFERENCES BOOK (BOOKNUM);

ALTER TABLE MYBOOK
ADD CONSTRAINT R_4 FOREIGN KEY (BUYNUM) REFERENCES BUY (BUYNUM);