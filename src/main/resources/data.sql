
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

INSERT INTO public.claims VALUES (nextval('public.claims_id_seq'),'claim_no_1','sn1',1,1);

INSERT INTO public.claims VALUES (nextval('public.claims_id_seq'),'claim_no_2','sn2',2,2);

INSERT INTO public.claims_progress VALUES (nextval('public.claims_progress_id_seq'), '2021-12-05 12:20:01', 'Test comment 1', 1, 1);

INSERT INTO public.claims_progress VALUES (nextval('public.claims_progress_id_seq'), '2021-12-05 12:32:12', 'Test comment 2', 1, 2);

INSERT INTO public.claims_progress VALUES (nextval('public.claims_progress_id_seq'), '2021-12-05 12:52:12', 'Test comment 3', 1, 3);

insert into public.person values(nextval('public.person_id_seq'), 10, 'John@gmail.com', 'John');

insert into public.person values(nextval('public.person_id_seq'), 22, 'Jane@gmail.com', 'Jane');

commit;