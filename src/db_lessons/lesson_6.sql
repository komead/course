/*
    В уроке рассказывали про команду select и where.
 */
use shop;
-- Вывод всех строк таблицы:
select * from brand;
-- Вывод всех строк с определённым значением столбца:
select * from category where discount = 5;
-- Вывод всех строк со скидкой не равной 5:
select * from category where discount <> 5;
-- Вывод всех строк со скидкой не меньше 6:
select * from category where not (discount < 6);
-- Вывод всех строк со скидкой меньше 15 и не равной 10:
select * from category where (discount < 15) and (discount <> 10);
-- Вывод всех строк со скидкой не меньше 6 или с определённым названием:
select * from category where not (discount < 6) or (name = 'Мужская одежда');
-- Вывод всех строк с заполненной скидкой:
select * from category where discount is not null;
-- Вывод столбцов id и name строк с определённым значением столбца:
select id, name from category where discount = 5;