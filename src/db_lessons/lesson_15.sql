/*
    В уроке рассказывали про left join и right join.
 */
use shop;
-- объединение таблицы products с таблицей brand с выводом всех строк таблицы products:
select * from products
    left join brand on products.brand_id = brand.id;
-- объединение таблицы products с таблицами brand, product_type, category с выводом всех строк таблицы products:
select * from products
    left join brand on products.brand_id = brand.id
    left join product_type on products.product_type_id = product_type.id
    left join category on products.category_id = category.id;
-- объединение таблицы products с таблицами brand, product_type, category с выводом только необходимых колонок:
select products.id, brand.name, product_type.name, category.name, discount from products
    left join brand on products.brand_id = brand.id
    left join product_type on products.product_type_id = product_type.id
    left join category on products.category_id = category.id;
-- переименую выводимые колонки при помощи as:
select products.id, brand.name as brand, product_type.name as product_type, category.name as category, discount from products
    left join brand on products.brand_id = brand.id
    left join product_type on products.product_type_id = product_type.id
    left join category on products.category_id = category.id;
-- добавлю ограничение по скидке:
select products.id, brand.name as brand, product_type.name as product_type, category.name as category, discount from products
    left join brand on products.brand_id = brand.id
    left join product_type on products.product_type_id = product_type.id
    left join category on products.category_id = category.id
    where discount = 5;
-- ну и добавлю сортировку:
select products.id, brand.name as brand, product_type.name as product_type, category.name as category, discount from products
    left join brand on products.brand_id = brand.id
    left join product_type on products.product_type_id = product_type.id
    left join category on products.category_id = category.id
    where discount > 0
    order by discount;
-- объединение таблицы products с таблицей brand с выводом всех строк таблицы brand:
select * from products
    right join brand on products.brand_id = brand.id;
-- объединение таблицы products с таблицами brand, product_type, category с выводом всех строк таблицы category:
select * from products
    right join brand on products.brand_id = brand.id
    right join product_type on products.product_type_id = product_type.id
    right join category on products.category_id = category.id;