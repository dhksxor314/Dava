
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
    genre varchar(100) not null,
    summary text,
    
    primary key(booknum)
);


insert into book(title,author,publisher,pub_date,price,sal,img,genre,summary) values('�޺�������1','����','��ũ�̵��','2007-01-15',4000,100,'Chrysanthemum.jpg','��Ÿ��','�޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������     �޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������');
insert into book(title,author,publisher,pub_date,price,sal,img,genre,summary) values('�޺�������2','����','��ũ�̵��','2007-01-15',4000,90,'Desert.jpg','��Ÿ��','�޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������     �޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������');
insert into book(title,author,publisher,pub_date,price,sal,img,genre,summary) values('�޺�������3','����','��ũ�̵��','2007-01-15',4000,80,'Chrysanthemum.jpg','��Ÿ��','�޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������     �޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������');
insert into book(title,author,publisher,pub_date,price,sal,img,genre,summary) values('�޺�������4','����','��ũ�̵��','2007-01-15',4000,70,'Desert.jpg','��Ÿ��','�޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������     �޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������');
insert into book(title,author,publisher,pub_date,price,sal,img,genre,summary) values('�޺�������5','����','��ũ�̵��','2007-01-15',4000,60,'Chrysanthemum.jpg','��Ÿ��','�޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������     �޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������');
insert into book(title,author,publisher,pub_date,price,sal,img,genre,summary) values('�޺�������6','����','��ũ�̵��','2007-01-15',4000,50,'Desert.jpg','��Ÿ��','�޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������     �޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������');
insert into book(title,author,publisher,pub_date,price,sal,img,genre,summary) values('�޺�������7','����','��ũ�̵��','2007-01-15',4000,30,'Chrysanthemum.jpg','��Ÿ��','�޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������     �޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������');
insert into book(title,author,publisher,pub_date,price,sal,img,genre,summary) values('�޺�������8','����','��ũ�̵��','2007-01-15',4000,40,'Desert.jpg','��Ÿ��','�޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������     �޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������');
insert into book(title,author,publisher,pub_date,price,sal,img,genre,summary) values('�޺�������9','����','��ũ�̵��','2007-01-15',4000,20,'Chrysanthemum.jpg','��Ÿ��','�޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������     �޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� �������������޺��� ������������');

CREATE TABLE BUY
(
	BUYNUM               INTEGER NOT NULL auto_increment,
	MEMNUM               INTEGER NOT NULL,
	BOOKNUM              INTEGER NOT NULL,
	BUY_DATE             DATE NULL,
	p_way 				varchar(20) not null,
	final_pay			INTEGER NOT NULL,
	primary key(buynum)
);

insert into buy(memnum, booknum, buy_date, p_way, final_pay) values(1, 1, curdate(), '����', 4000);
insert into buy(memnum, booknum, buy_date, p_way, final_pay) values(1, 2, curdate(), '�������Ա�', 5000);
insert into buy(memnum, booknum, buy_date, p_way, final_pay) values(1, 3, curdate(), '������ü', 2000);
insert into buy(memnum, booknum, buy_date, p_way, final_pay) values(1, 4, curdate(), '����', 3000);
insert into buy(memnum, booknum, buy_date, p_way, final_pay) values(2, 1, curdate(), '��ȯ', 4000);
insert into buy(memnum, booknum, buy_date, p_way, final_pay) values(2, 4, curdate(), '����', 5500);
insert into buy(memnum, booknum, buy_date, p_way, final_pay) values(2, 6, curdate(), '�ϳ�', 6000);
insert into buy(memnum, booknum, buy_date, p_way, final_pay) values(2, 3, curdate(), '����', 5000);


CREATE TABLE MEMBER
(
	MEMNUM               INTEGER NOT NULL auto_increment,
	ID                   VARCHAR(20) NULL,
	NICKNAME             VARCHAR(20) NULL,
	PASSWORD             VARCHAR(20) NULL,
	POINT				INTEGER NOT NULL,
	
	primary key(memnum)
);

insert into member(id, nickname, password, point) values('user00@naver.com', 'dava0', 'user00', 0);
insert into member(id, nickname, password, point) values('user11@naver.com', 'dava1', 'user11', 0);
insert into member(id, nickname, password, point) values('user22@naver.com', 'dava2', 'user22', 0);
insert into member(id, nickname, password, point) values('user33@naver.com', 'dava3', 'user33', 0);


CREATE TABLE MANAGER
(
	MANAGERNUM           INTEGER NOT NULL auto_increment,
	ID                   VARCHAR(20) NULL,
	PASSWORD             VARCHAR(20) NULL,
	NICKNAME             VARCHAR(20) NULL,

	primary key(managernum)
);


CREATE TABLE MYBOOK
(
	MYBOOKNUM            INTEGER NOT NULL auto_increment,
	BOOKMARK             INTEGER NULL,
	BUYNUM               INTEGER NOT NULL,
	primary key(mybooknum)
);

insert into mybook(bookmark, buynum) values(1, 1);
insert into mybook(bookmark, buynum) values(1, 2);
insert into mybook(bookmark, buynum) values(1, 3);
insert into mybook(bookmark, buynum) values(1, 4);
insert into mybook(bookmark, buynum) values(1, 5);
insert into mybook(bookmark, buynum) values(1, 6);
insert into mybook(bookmark, buynum) values(1, 7);
insert into mybook(bookmark, buynum) values(1, 8);


ALTER TABLE BUY
ADD CONSTRAINT R_2 FOREIGN KEY (MEMNUM) REFERENCES MEMBER (MEMNUM);

ALTER TABLE BUY
ADD CONSTRAINT R_3 FOREIGN KEY (BOOKNUM) REFERENCES BOOK (BOOKNUM);

ALTER TABLE MYBOOK
ADD CONSTRAINT R_4 FOREIGN KEY (BUYNUM) REFERENCES BUY (BUYNUM);