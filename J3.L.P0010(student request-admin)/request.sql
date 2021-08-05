create database Request
use Request
go

create table Account(aid int IDENTITY (1,1) primary key,username nvarchar(20) ,password nvarchar(20),fullname nvarchar(30),shortname nvarchar(20))
create table Department(did int primary key ,name nvarchar(40))
create table Student(studentId nvarchar(20) primary key ,studentName nvarchar(40))
create table Request(rid int IDENTITY (1,1) primary key,did int foreign key references Department(did),studentId nvarchar(20) foreign key references Student(studentId),
		dateCreate date,title nvarchar(100),content nvarchar(200),state int,closeDate date,solvedId int foreign key references Account(aid),
		attached nvarchar(30),solution nvarchar(200),status int)

-- Querry --
--Insert --
insert into Account values('hung','1234','Khuat Dinh Hung','HungKD' )

insert into Department values(1,'Academic Department')
insert into Department values(2,'Social Department')

insert into Student values('HE140756','Khuat Dinh Hung')
insert into Student values('HE140000','Nguyen Van A')

insert into Request values(1,'HE140756','2021-07-05','inquery for PE result','My PE score in Prj321 is 1. The school helps me check again.',-1,NULL,NULL,'pe.txt',NULL,0)
insert into Request values(1,'HE140000','2021-07-05','inquery for FE result','My PE score in Prj321 is 2. The school helps me check again.',1,'2021-07-6',1,NULL,'Oke Checked. You can check again your core!',1)
insert into Request values(1,'HE140756','2021-07-05','inquery for FE result','My PE score in Prj321 is 3. The school helps me check again.',-1,NULL,NULL,'pe.txt',NULL,0)
insert into Request values(2,'HE140000','2021-07-05','inquery for PE result','My PE score in Prj321 is 4. The school helps me check again.',-1,NULL,NULL,'pe.txt',NULL,0)
insert into Request values(2,'HE140000','2021-07-14','inquery for PE result','My PE score in Prj321 is 4. The school helps me check again.',-1,NULL,NULL,'pe.txt',NULL,0)
-- Select --
Select * from Account where username ='hung' and password='1234'
Select * from Department 
Select rid,c.name,d.studentId,d.studentName,dateCreate,title,content,state,closeDate,b.shortname,attached,solution,status from Request a
LEFT JOIN Account b ON a.solvedId=b.aid
LEFT JOIN Department c ON a.did = c.did
LEFT JOIN Student d ON a.studentId = d.studentId
Where dateCreate = '2021-07-05' 
order by dateCreate 

select COUNT( *) from Request 
Where  did =1 
and dateCreate between '2021-07-05'  and '2021-07-06' 
select * from Account
select * from Department
select * from Student
select * from Request

-- update --
Update Request set solution='1'
where rid = '1'