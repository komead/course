/*
 Задание:
 В уроке рассказывали про команду insert. Нужно заполнить таблицы данными.
*/
use shop;
insert into category (name, discount) values
    ('Мужская одежда', 5),
    ('Женская одежда', 5),
    ('Мужская обувь', 10);
insert into brand (name) values
    ('abibas'),
    ('puma'),
    ('ostin'),
    ('fila'),
    ('lacoste'),
    ('reebok');
insert into product_type (name) values
    ('Ботинки'),
    ('Шапка'),
    ('Куртка');
insert into products (brand_id, product_type_id, category_id) values
    (1, 2, 1),
    (3, 3, 2),
    (2, 1, 1),
    (4, 3, 2),
    (5, 2, 2),
    (6, 1, 2);