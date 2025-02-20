/*
    В уроке рассказывали про создание таблиц с отношением ManyToMany.
 */
use shop;
-- добавлю таблицу, которой понадобится такая связь:
create table orders (
    id int not null auto_increment,
    username varchar(15) not null,
    phone varchar(10) not null,
    primary key (id)
);
-- ввод тестовых данных:
insert into orders (username, phone)
    values ('Andrey', '777777'),
           ('Victor', '222222');

-- создание связывающей таблицы и её заполнение:
create table orders_products (
    products_id int not null,
    orders_id int not null,
    count int not null
);

alter table orders_products
    add constraint fk_orders_products_products
    foreign key (products_id)
    references products (id);

alter table orders_products
    add constraint fk_orders_products_orders
        foreign key (orders_id)
            references orders (id);

insert into orders_products (products_id, orders_id, count)
    values (1, 2, 3),
           (2, 1, 1);