/*
    В уроке рассказывали про команды delete и update.
 */
use shop;
-- изменение названия по id строки:
update brand set name = 'adidas' where id = 1;
-- изменение категории по нескольким id строки:
update products set category_id = 3 where id in (2, 5);
-- попробовал ещё сделать таким способом, но mysql не даёт менять таблицу, которая используется в подзапросе:
update products set category_id = 2 where id in (select id from products where category_id = 3);
-- удаление строки по id:
delete from products where id = 6;