create table USER (
ID int not null auto_increment
,NAME varchar(60) not null
,LOGIN varchar(60) not null
,AGE int not null
,PASSWORD varchar(60) not null
,unique UQ_USER_1 (LOGIN)
,primary key (ID)
);