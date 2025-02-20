/*
    В уроке рассказывали про внешние ключи.
 */
 use shop;
-- добавлю простые внешние ключи в таблицу products:
alter table products
    add constraint fk_products_brand
    foreign key (brand_id)
    references brand (id)
    /*on delete cascade*/;

alter table products
    add constraint fk_products_product_type
    foreign key (product_type_id)
    references product_type (id)
    /*on delete cascade*/;

alter table products
    add constraint fk_products_category
    foreign key (category_id)
    references category (id)
    /*on delete cascade*/;