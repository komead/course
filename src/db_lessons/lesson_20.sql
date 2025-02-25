/*
    В уроке рассказывали про транзакции.
 */
use shop;
-- в таблицу products добавлю колонку с информацией о количестве доступных для покупки товаров:
alter table products add column available int;
-- заполню эту колонку данными:
update products set available = 2 where id = 1;
update products set available = 3 where id = 2;
update products set available = 3 where id = 3;
update products set available = 2 where id = 4;
update products set available = 4 where id = 5;
-- делаю транзакцию, которая при покупке уменьшает количество товаров:
start transaction;
	insert into orders_products (products_id, orders_id, count) value (1, 1, 1);
    update products set available = available - (
		select count from orders_products where products_id = 1 and orders_id = 1
    ) where id = 1;
commit