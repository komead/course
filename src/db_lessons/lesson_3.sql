/*Задание:
  В уроке сделали несколько таблиц в Exel, нужно переделать в sql
  В Exel были таблицы с полями:
  Товары (Артикул, ID бренда, ID типа товара, ID категории, цена)
  Категория товаров (ID, Категория, Скидка)
  Бренд (ID, Тип)
  Тип товара (ID, Тип)
*/
use shop;
create table category (
    id       int         not null auto_increment,
    name     varchar(15) not null,
    discount tinyint     not null,
    primary key (id)
);
create table brand (
    id   int         not null auto_increment,
    name varchar(15) not null,
    primary key (id)
);
create table product_type (
    id   int         not null auto_increment,
    name varchar(15) not null,
    primary key (id)
);
create table products (
    id              int not null auto_increment,
    brand_id        int not null,
    product_type_id int not null,
    category_id     int not null,
    primary key (id)
);