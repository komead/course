/*
    В уроке рассказывали про составные первичные ключи.
 */
use shop;
-- добавлю составной первичный ключ в таблицу orders_products:
alter table orders_products add  primary key (products_id, orders_id);