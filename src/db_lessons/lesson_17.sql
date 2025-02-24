/*
    В уроке рассказывали про агрегирующие функции count, sum, min, max.
 */
use shop;
-- добавлю колонку с ценой в таблицу products:
alter table products add column price int not null;
-- заполню цены:
update products set price = 100 where id = 1;
update products set price = 120 where id = 2;
update products set price = 200 where id = 3;
update products set price = 90 where id = 4;
update products set price = 150 where id = 5;
-- выведу количество строк в таблице products:
select count(*) from products;
-- выведу сумму цен, максимальную и минимальную цену:
select sum(price), max(price), min(price) from products;
-- выведу количество строк в таблице products при объединении таблицы products с таблицами brand, product_type, category с выводом всех строк таблицы products:
select count(*) from products
    left join brand on products.brand_id = brand.id
    left join product_type on products.product_type_id = product_type.id
    left join category on products.category_id = category.id
    where discount > 0
    order by discount;
-- выведу сумму цен в таблице products при объединении таблицы products с таблицами brand, product_type, category с выводом всех строк таблицы products:
select sum(price) from products
    left join brand on products.brand_id = brand.id
    left join product_type on products.product_type_id = product_type.id
    left join category on products.category_id = category.id
    where discount > 0
    order by discount;