
create table if not exists user_role (
                           user_id int8 not null,
                           roles varchar(255)
);

create table if not exists usr  (
                     id SERIAL not null,
                     username varchar(255) not null,
                     password varchar(255) not null,
                     primary key (id)
);

insert into usr (id, username, password)
values (1, 'admin', '$2a$08$d.nFHGd5XsJny2bdKYrl6eEes1trbREVqfJh.50nFYLjZl2vD.t8S');

insert into user_role (user_id, roles)
values (1, 'USER'), (1, 'ADMIN');


insert into purchase (name) values ('Телевизор');
insert into purchase (name) values ('Смартфон');
insert into purchase (name) values ('Соковыжималка');
insert into purchase (name) values ('Наушники');
insert into purchase (name) values ('Клавиатура');

insert into purchase_info (age, amount, count, creation_date, lastname, name, purchase_id)
values (18, 314.1, 16, '2019-12-25 10:28:15.439378', 'фамилия 1', 'name 1', 1);


insert into purchase_info (age, amount, count, creation_date, lastname, name, purchase_id)
values (18, 312.2, 12, '2019-09-11 10:28:15.439378', 'фамилия 2', 'name 2', 2);

insert into purchase_info (age, amount, count, creation_date, lastname, name, purchase_id)
values (15, 201.1, 1, '2019-12-17 10:28:15.439378', 'фамилия 3', 'name 3', 3);


insert into purchase_info (age, amount, count, creation_date, lastname, name, purchase_id)
values (21, 100, 32, '2019-12-19 10:28:15.439378', 'фамилия 2', 'name 2', 1);


insert into purchase_info (age, amount, count, creation_date, lastname, name, purchase_id)
values (23, 301, 12, '2019-12-20 10:28:15.439378', 'фамилия 3', 'name 3', 2);

insert into purchase_info (age, amount, count, creation_date, lastname, name, purchase_id)
values (25, 506, 5, '2019-12-21 10:28:15.439378', 'фамилия 4', 'name 4', 3);





