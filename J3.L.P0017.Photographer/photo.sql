create database photo
use photo

create table gallery(id int primary key , title nvarchar(max),description nvarchar(max),name nvarchar(max),url_img nvarchar(max))
create table image(gallery_id int ,stt int,url_img nvarchar(max))
create table contact(address nvarchar(max),city nvarchar(max),Country nvarchar(max),telephone nvarchar(max),email nvarchar(max))

insert into gallery values(1, 'Annie Leibovitz was the first woman to be named chief photographer', 'Annie Leibovitz was the first woman to be named chief photographer at Rolling Stone and the last person to take a portrait of John Lennon. In her first online photography class, Annie shows us that what makes a picture stunning isn’t the gear or technology—it’s the story.', 'Gallery 1','1.jpg')
insert into gallery values(2, 'Annie Leibovitz was the first woman to be named chief photographer', 'Annie Leibovitz was the first woman to be named chief photographer at Rolling Stone and the last person to take a portrait of John Lennon. In her first online photography class, Annie shows us that what makes a picture stunning isn’t the gear or technology—it’s the story.', 'Gallery 2','2.jpg')
insert into gallery values(3, 'Annie Leibovitz was the first woman to be named chief photographer', 'Annie Leibovitz was the first woman to be named chief photographer at Rolling Stone and the last person to take a portrait of John Lennon. In her first online photography class, Annie shows us that what makes a picture stunning isn’t the gear or technology—it’s the story.', 'Gallery 3','3.jpg')
insert into gallery values(4, 'Annie Leibovitz was the first woman to be named chief photographer', 'Annie Leibovitz was the first woman to be named chief photographer at Rolling Stone and the last person to take a portrait of John Lennon. In her first online photography class, Annie shows us that what makes a picture stunning isn’t the gear or technology—it’s the story.', 'Gallery 4','4.jpg')
insert into gallery values(5, 'Annie Leibovitz was the first woman to be named chief photographer', 'Annie Leibovitz was the first woman to be named chief photographer at Rolling Stone and the last person to take a portrait of John Lennon. In her first online photography class, Annie shows us that what makes a picture stunning isn’t the gear or technology—it’s the story.', 'Gallery 5','5.jpg')
insert into gallery values(6, 'Annie Leibovitz was the first woman to be named chief photographer', 'Annie Leibovitz was the first woman to be named chief photographer at Rolling Stone and the last person to take a portrait of John Lennon. In her first online photography class, Annie shows us that what makes a picture stunning isn’t the gear or technology—it’s the story.', 'Gallery 6','6.jpg')


insert into image values(1,1, '1.jpg')
insert into image values(1,2 ,'2.jpg')
insert into image values(1,3, '3.jpg')
insert into image values(1,4, '4.jpg')
insert into image values(1,5, '5.jpg')
insert into image values(1,6, '6.jpg')

insert into image values(2,1, '2.jpg')
insert into image values(2,2 ,'1.jpg')
insert into image values(2,3, '3.jpg')
insert into image values(2,4, '4.jpg')
insert into image values(2,5, '5.jpg')
insert into image values(2,6, '6.jpg')

insert into image values(3,1, '3.jpg')
insert into image values(3,2 ,'2.jpg')
insert into image values(3,3, '1.jpg')
insert into image values(3,4, '4.jpg')
insert into image values(3,5, '5.jpg')
insert into image values(3,6, '6.jpg')

insert into image values(4,1, '4.jpg')
insert into image values(4,2 ,'2.jpg')
insert into image values(4,3, '3.jpg')
insert into image values(4,4, '1.jpg')
insert into image values(4,5, '5.jpg')
insert into image values(4,6, '6.jpg')

insert into image values(5,1, '5.jpg')
insert into image values(5,2 ,'2.jpg')
insert into image values(5,3, '3.jpg')
insert into image values(5,4, '1.jpg')
insert into image values(5,5, '4.jpg')
insert into image values(5,6, '6.jpg')

insert into image values(6,1, '6.jpg')
insert into image values(6,2 ,'2.jpg')
insert into image values(6,3, '3.jpg')
insert into image values(6,4, '1.jpg')
insert into image values(6,5, '5.jpg')
insert into image values(6,6, '4.jpg')





insert into contact values('Ha Noi','Ha Noi','Viet Nam','999999','hung@fpt.edu.vn')

select * from image 
select * from image where gallery_id='1' order by stt
select * from contact
select * from gallery