/*
    В уроке рассказывали про индексы.
 */
use shop;
-- добавлю индекс в таблицу brand для поля name:
alter table brand add index name_index (name asc);
-- добавлю индекс в таблицу orders для поля username:
alter table orders add index username (username asc);