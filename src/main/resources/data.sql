
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
values (1, 2, 16, now(), 'фамилия 1', 'name 1', 1);


insert into purchase_info (age, amount, count, creation_date, lastname, name, purchase_id)
values (1, 2, 12, now(), 'фамилия 2', 'name 2', 2);

insert into purchase_info (age, amount, count, creation_date, lastname, name, purchase_id)
values (1, 2, 1, now(), 'фамилия 3', 'name 3', 3);


insert into purchase_info (age, amount, count, creation_date, lastname, name, purchase_id)
values (1, 2, 32, now(), 'фамилия 2', 'name 2', 1);


insert into purchase_info (age, amount, count, creation_date, lastname, name, purchase_id)
values (1, 2, 12, now(), 'фамилия 3', 'name 3', 2);

insert into purchase_info (age, amount, count, creation_date, lastname, name, purchase_id)
values (1, 2, 5, now(), 'фамилия 4', 'name 4', 3);





