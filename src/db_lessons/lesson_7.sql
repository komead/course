/*
    В уроке рассказывали про команды distinct, order by и limit.
 */
use shop;
-- вывод множества скидок:
select distinct discount from category;
-- вывод строк со скидкой больше 5 с сортировкой скидок по возрастанию:
select * from category where discount > 5 order by discount;
-- вывод строк со скидкой не равной 0 с сортировкой скидок по возрастанию и названий по возрастанию:
select * from category where discount <> 0 order by discount, name;
-- вывод строк со скидкой не равной 0 с сортировкой скидок по убыванию и названий по возрастанию:
select * from category where discount <> 0 order by discount desc, name;
-- вывод первых 2-ух строк:
select * from category limit 2;
-- вывод первых двух строк множества скидок со скидкой больше 0, сортировкой скидок по возрастанию:
select distinct discount from category where discount > 0 order by discount limit 2;