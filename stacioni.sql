create database Stacioni;
use Stacioni;
drop database stacioni;

create table Autobusi (
Aid integer primary key auto_increment not null  ,
EmriAutobusit varchar(30) not null ,
Pronari varchar(30),
Numri_Telefonit integer not null ,
Lokacioni varchar(40),
Nrudhetarve integer not null 
);

select * from Linjat;
create table Linjat (
Lid integer primary key auto_increment not null  ,
Vendi_nisjes varchar(50) not null,
Destinacioni varchar(50) not null ,
Oranisjes time not null ,
OraArritjes time not null ,
Cmimi real not null ,
EmriKompanis varchar(30) ,
Verifikmi boolean);
                         						


create table Biletat (
Bid integer auto_increment primary key not null unique ,
Lid integer not null ,
Bemri varchar(40) not null ,
Bmbiemri varchar(40) not null ,
B_ora time not null ,
NrBiletav integer not null ,
Kthyese boolean,
foreign key(Lid) references Linjat(Lid) on delete cascade);



create table Regjistrohu(
User_id integer primary key  auto_increment not null ,
Emri varchar(30) not null ,
Mbiemri varchar(40) not null ,
Email varchar(40) not null ,
Username varchar(40) not null ,
Password varchar(40) not null);

insert into Regjistrohu(Emri,Mbiemri,Email,Username,Password) values ('Veton','Shala','vetonnshala@gmail.com','veton','1234');

create table Komentet(
Kid integer primary key auto_increment not null unique ,
Kemri varchar(50) not null ,
Komenti varchar(300) not null 
);

