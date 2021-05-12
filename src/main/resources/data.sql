
insert into public.product_types values(nextval('public.product_types_id_seq'), 'Смартфоны');

insert into public.product_types values(nextval('public.product_types_id_seq'), 'Планшеты');

insert into public.product_types values(nextval('public.product_types_id_seq'), 'Гаджеты');

insert into public.product_types values(nextval('public.product_types_id_seq'), 'Аксессуары для планшетов');

insert into public.product_types values(nextval('public.product_types_id_seq'), 'Аксессуары для смартфонов');

insert into public.product_types values(nextval('public.product_types_id_seq'), 'Наушники');

insert into public.product_types values(nextval('public.product_types_id_seq'), 'Ноутбуки');

insert into public.product_types values(nextval('public.product_types_id_seq'), 'Компьютеры');

insert into public.product_types values(nextval('public.product_types_id_seq'), 'Комплектующие для ПК');

insert into public.service_centers values(nextval('public.service_centers_id_seq'), 'Москва');

insert into public.service_centers values(nextval('public.service_centers_id_seq'), 'Санкт-Петербург');

insert into public.service_centers values(nextval('public.service_centers_id_seq'), 'Нижний Новгород');

insert into public.claim_status values(nextval('public.claim_status_id_seq'), 'Новое');

insert into public.claim_status values(nextval('public.claim_status_id_seq'), 'В работе');

insert into public.claim_status values(nextval('public.claim_status_id_seq'), 'Выполнено');

insert into public.claim_status values(nextval('public.claim_status_id_seq'), 'Закрыто');

insert into public.person values(nextval('public.person_id_seq'), 10, 'John@gmail.com', 'John');

insert into public.person values(nextval('public.person_id_seq'), 22, 'Jane@gmail.com', 'Jane');

commit;