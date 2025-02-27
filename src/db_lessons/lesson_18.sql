/*
    В уроке рассказывали про group by.
 */
use shop;
-- вывод заказов с итоговой ценой по каждому товару:
select orders.username, price * count as total_price  from orders
    inner join orders_products on orders_products.orders_id = orders.id
    inner join products on products.id = orders_products.products_id;
-- вывод заказов с итоговой ценой всего заказа по имени пользователя:
select orders.username, sum(price * count) as total_price  from orders
    inner join orders_products on orders_products.orders_id = orders.id
    inner join products on products.id = orders_products.products_id
    group by orders.username;
-- вывод максимальной цены в заказе и количества товаров в заказе:
select orders.username, max(price), sum(count)  from orders
    inner join orders_products on orders_products.orders_id = orders.id
    inner join products on products.id = orders_products.products_id
    group by orders.username;