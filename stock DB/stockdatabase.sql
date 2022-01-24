--users table
create table users
(user_id int GENERATED ALWAYS AS IDENTITY START WITH 1  primary key,
    user_name varchar(32) not null,
    email varchar2(40) UNIQUE,
    address varchar(100) not null,
    password varchar2(32) not null, 
    phonenumber NUMBER not null,
    usertype varchar2(8) default 'user');
    DESC users;
select * from users;
---drop table users cascade constraints;
commit;


select users.user_name from users where address='channei';

DELETE FROM users WHERE user_id=104;
insert into users(user_name,email,address,password,phonenumber) values('maari','maari@gmail.com','theni','Maari@65',9876543210);
drop table users CASCADE CONSTRAINTS;

--admins table
create table admin(
admin_email varchar2(50) unique,
admin_name varchar2(32) not null,
password varchar2(12) not null);

insert into admin values('pothi@gmail.com','pothi','pothi@123');
COMMIT;

select * from admin;
drop table admin;

drop table admin CASCADE CONSTRAINTS;

--products table
create table stock
(product_id number GENERATED ALWAYS AS IDENTITY START WITH 1 increment by 1 primary key,
product_name varchar2(32) not null,
product_qty number not null,
price number(10,2) not null );  
insert into stock(product_name,product_qty,price)values('battry',100,5000);
select * from stock;
select * from stock where product_name='oil';
update stock set product_qty=(select product_qty from stock where product_id= 1 )-10 where product_id=1; 

drop table products CASCADE CONSTRAINTS;

--purchases table 
create table purchasess(cart_id int GENERATED ALWAYS AS IDENTITY START WITH 10 primary key,
product_id number,
user_id number  ,
product_name VARCHAR(20),
quantity number not null,
total_price number not null,
status varchar(20) default 'ordered',
order_date date default sysdate,

FOREIGN key(user_id) REFERENCES users(user_id),
foreign key(product_id) references stock(product_id));

drop table purchasess;

select * from purchases_list;

--cart
create table cart(cart_id int GENERATED ALWAYS AS IDENTITY START WITH 100 primary key,
user_id int,
product_id int not null,
quantity int not null,
totalPrice number not null,
delivery_date date,
FOREIGN key (product_id) REFERENCES stock(product_id),
FOREIGN key(user_id) REFERENCES users(user_id)); 

select * from cart;
commit;
drop table cart CASCADE CONSTRAINTS;

--supplier---
create table supplier
( supplier_id number not null primary key,
 supplier_name varchar2(32) not null,
company varchar(32),
email varchar2(32) unique not null,
phone_number number unique,
product_name varchar2(32) not null,
product_price number,
quantity number);  

select * from supplier;
commit;
drop table supplier;

insert into supplier values(1004,'pothys','MRF','mrf@gmail.com',9876543211,'tyre',1200,150);

--invoice bill
create table bills(bill_id int GENERATED ALWAYS AS IDENTITY START WITH 100 primary key,
user_id int ,product_id int,
quantity int not null,
total_amount int not null,
purchase_date date not null);,
FOREIGN key(user_id) REFERENCES users(user_id),
FOREIGN key (product_id) REFERENCES stock(product_id));
---FOREIGN key(order_id) REFERENCES orders(order_id)); 
select * from bill;
insert into bills(user_id,product_id,quantity,total_amount,purchase_date) values(12,21,20,290,'12-03-2021');
drop table bills CASCADE CONSTRAINTS;
select * from bills;
commit;
select*from cart where user_id=41;
select * from purchases_list;
truncate table purchases_list;
select sysdate+2 from dual;
insert into cart (user_id,product_id,quantity,totalprice,delivery_date) values(?,?,?,?,sysdate+?);
commit;
select * from cart;