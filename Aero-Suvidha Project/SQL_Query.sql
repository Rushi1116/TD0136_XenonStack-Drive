create database aero;
use aero;

CREATE TABLE User (
    userId int NOT NULL AUTO_INCREMENT,
    firstName varchar(255),
    lastName varchar(255),
    email varchar(255),
    password varchar(255),
    role varchar(255),
    dateOfBirth date,
    PRIMARY KEY (userId)
);
INSERT INTO User ( firstName, lastName,email,password ,role,dateOfBirth)
VALUES ("tejas","pawar","tejas@gmail.com","tejas123","admin","1997-08-10");
INSERT INTO User ( firstName, lastName,email,password ,role,dateOfBirth)
VALUES ("shubham","fendar","shubham@gmail.com","shubham123","admin","1996-11-02");
INSERT INTO User ( firstName, lastName,email,password ,role,dateOfBirth)
VALUES ("virat","palve","virat@gmail.com","virat123","user","1994-7-25");
INSERT INTO User ( firstName, lastName,email,password ,role,dateOfBirth)
VALUES ("sachin","sahare","sachin@gmail.com","sachin123","user","1993-9-15");

select * from User;
 
 CREATE TABLE Flight (
     flightId int NOT NULL ,
     airlineName varchar(255),
     companyName varchar(255),
     economyClassSeats int,
     buisnessClassSeats int, 
     firstClassSeats int,
     checkinBaggageCapacity int,
     cabinBaggageCapacity int,
    PRIMARY KEY (flightId)
);
 INSERT INTO Flight ( flightId, airlineName,companyName,economyClassSeats ,buisnessClassSeats,firstClassSeats,checkinBaggageCapacity,cabinBaggageCapacity)
VALUES (101,"kingfisher-12a","kingfisher",50,50,50,15,8);
INSERT INTO Flight ( flightId, airlineName,companyName,economyClassSeats ,buisnessClassSeats,firstClassSeats,checkinBaggageCapacity,cabinBaggageCapacity)
VALUES (102,"kingfisher-39a","kingfisher",60,40,50,15,8);
INSERT INTO Flight ( flightId, airlineName,companyName,economyClassSeats ,buisnessClassSeats,firstClassSeats,checkinBaggageCapacity,cabinBaggageCapacity)
VALUES (201,"airindia-12a","airindia",50,50,50,15,8);
INSERT INTO Flight ( flightId, airlineName,companyName,economyClassSeats ,buisnessClassSeats,firstClassSeats,checkinBaggageCapacity,cabinBaggageCapacity)
VALUES (301,"spj-24","spicejet",120,30,30,15,8);

select * from Flight;
