/*
    В уроке рассказывали про inner join.
 */
use shop;
-- простое объединение таблицы products с таблицей brand:
select * from products
    inner join brand on products.brand_id = brand.id;
-- простое объединение таблицы products с таблицами brand, product_type, category:
select * from products
    inner join brand on products.brand_id = brand.id
    inner join product_type on products.product_type_id = product_type.id
    inner join category on products.category_id = category.id;
-- вывод без ссылок на id и самих id:
select brand.name, product_type.name, category.name, discount from products
    inner join brand on products.brand_id = brand.id
    inner join product_type on products.product_type_id = product_type.id
    inner join category on products.category_id = category.id;
-- добавляю ограничение на вывод количества первых строк:
select brand.name, product_type.name, category.name, discount from products
    inner join brand on products.brand_id = brand.id
    inner join product_type on products.product_type_id = product_type.id
    inner join category on products.category_id = category.id
    limit 4;
-- добавляю ограничение на скидки:
select brand.name, product_type.name, category.name, discount from products
    inner join brand on products.brand_id = brand.id
    inner join product_type on products.product_type_id = product_type.id
    inner join category on products.category_id = category.id
    where discount > 5;
-- добавляю сортировку по названию бренда в обратном порядке:
select brand.name, product_type.name, category.name, discount from products
    inner join brand on products.brand_id = brand.id
    inner join product_type on products.product_type_id = product_type.id
    inner join category on products.category_id = category.id
    where discount > 5
    order by brand.name desc;