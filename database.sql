USE hotelMS;
create table login(username varchar(25),password varchar(25));
select * from login;
insert into login values('abhijeet','7066235795');
create table login2(username varchar(25),password varchar(25));
select * from login2;
insert into login2 values('abhijeet','325325');
create table department(department varchar(80),budget varchar(50));
select * from department;
insert into department values('office','50000');
insert into department values('Housekeeping','40000');
insert into department values('Food','80000');
insert into department values('Kitchen','20000');
insert into department values('Security','60000');
-- 2️⃣ Create Room table
CREATE TABLE room (
    roomnumber VARCHAR(20),
    availability VARCHAR(20),
    cleaning_status VARCHAR(20),
    price VARCHAR(20),
    bed_type VARCHAR(20)
);
 -- View Room data
SELECT * FROM room;
-- 3️⃣ Create Employee table
CREATE TABLE employee (
    name VARCHAR(20),
    age VARCHAR(20),
    gender VARCHAR(20),
    job VARCHAR(20),
    salary VARCHAR(20),
    phone VARCHAR(20),
    email VARCHAR(20),
    aadhar VARCHAR(20)
);
-- View Employee data
-- 4️⃣ Drop Employee table (if needed)
DROP TABLE employee;
select * from employee;
-- 5️⃣ Create Driver table
CREATE TABLE driver (
    name VARCHAR(20),
    age VARCHAR(20),
    gender VARCHAR(20),
    comapny VARCHAR(20),   -- note: "company" is misspelled in original queries
    carname VARCHAR(20),
    available VARCHAR(20),
    location VARCHAR(20)
);
select * from driver;
create table customer(
document varchar(30),
number varchar(30),
name varchar(30),
gender varchar(30),
country varchar(30),
room varchar(30),
checkintime varchar(80),
deposit varchar(30)
);
select * from customer;
