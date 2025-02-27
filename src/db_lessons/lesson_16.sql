/*
    В уроке рассказывали про union.
 */
use shop;
-- :
select * from category where id = 2
union
select * from category where discount > 0;

-- :
insert into orders (username, phone) values ('Иннокентий', '364583');

select * from orders
    left join orders_products on orders_products.orders_id = orders.id
    left join products on orders_products.products_id = products.id
union
select * from orders
    inner join orders_products on orders_products.orders_id = orders.id
    right join products on orders_products.products_id = products.id;
