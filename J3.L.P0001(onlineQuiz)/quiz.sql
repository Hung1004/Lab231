create database onlineQuiz
use onlineQuiz
go
create table [User](id int IDENTITY(1,1) primary key,userName nvarchar(max),passWord nvarchar(max),email nvarchar(max),role int)
create table Question(id int IDENTITY(1,1) primary key,question nvarchar(max),date nvarchar(max),creator int)
create table Answer(id int,[option] nvarchar(max),answer bit,idAnswer int)

select * from [User]
select top 1 id from [User] order by id desc

select * from Answer where id = 1  order by idAnswer