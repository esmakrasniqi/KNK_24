create database Stacioni;
use Stacioni;


insert into Autobusi(EmriAutobusit ,Pronari,Numri_Telefonit,Lokacioni,Nrudhetarve)values('Genti Tours','Ali Bytyqi',045856958,'Prishtine',80);      
create table Autobusi (
Aid integer primary key auto_increment not null  ,
EmriAutobusit varchar(30) not null ,
Pronari varchar(30),
Numri_Telefonit integer not null ,
Lokacioni varchar(40),
Nrudhetarve integer not null 
);


create table Linjat (
Lid integer primary key auto_increment not null  ,
Vendi_nisjes varchar(50) not null,
Destinacioni varchar(50) not null ,
Oranisjes time not null ,
OraArritjes time not null ,
Cmimi real not null ,
EmriKompanis varchar(30) ,
Verifikmi boolean

); 

 insert into Linjat(Vendi_nisjes,Destinacioni,Oranisjes,OraArritjes,Cmimi,EmriKompanis,Verifikmi)
 values('Prishtine','Lipjan','08:00:00','08:30:00',00.50,'Ali',1);                        						


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
Gjinia varchar(20),
Password varchar(40) not null);

insert into Regjistrohu(Emri,Mbiemri,Email,Username,Gjinia,Password) values ('Veton','Shala','vetonnshala@gmail.com','veton','M','1234');

create table Komentet(
Kid integer primary key auto_increment not null unique ,
Kemri varchar(50) not null ,
Komenti varchar(300) not null 
);

