
insert into public.product_types values(nextval('public.product_types_id_seq'), 'Smartphones');

insert into public.product_types values(nextval('public.product_types_id_seq'), 'Tablets');

insert into public.product_types values(nextval('public.product_types_id_seq'), 'Headphones');

insert into public.product_types values(nextval('public.product_types_id_seq'), 'Laptops');

insert into public.product_types values(nextval('public.product_types_id_seq'), 'Computers');

insert into public.service_centers values(nextval('public.service_centers_id_seq'), 'Moscow');

insert into public.service_centers values(nextval('public.service_centers_id_seq'), 'Saint-Petersburg');

insert into public.service_centers values(nextval('public.service_centers_id_seq'), 'Nizhny Novgorod');

insert into public.claim_status values(nextval('public.claim_status_id_seq'), 'New');

insert into public.claim_status values(nextval('public.claim_status_id_seq'), 'In progress');

insert into public.claim_status values(nextval('public.claim_status_id_seq'), 'Done');

insert into public.claim_status values(nextval('public.claim_status_id_seq'), 'Closed');

insert into public.claim_status values(nextval('public.claim_status_id_seq'), 'Cancelled');

INSERT INTO public.claims VALUES (nextval('public.claims_id_seq'), 'sn1',1,1);

INSERT INTO public.claims VALUES (nextval('public.claims_id_seq'), 'sn2',2,2);

INSERT INTO public.claims_progress VALUES (nextval('public.claims_progress_id_seq'), '2021-12-05 12:20:01', 'Test comment 1', 1, 1);

INSERT INTO public.claims_progress VALUES (nextval('public.claims_progress_id_seq'), '2021-12-05 12:32:12', 'Test comment 2', 1, 2);

INSERT INTO public.claims_progress VALUES (nextval('public.claims_progress_id_seq'), '2021-12-05 12:52:12', 'Test comment 3', 1, 3);

INSERT INTO public.claims_progress VALUES (nextval('public.claims_progress_id_seq'), '2021-12-05 12:52:12', 'Test comment 4', 2, 1);

--username:admin password:password
insert into public.users values(nextval('public.users_id_seq'), '$2a$10$Ej3eIXvUj6ML9bmi3Thhq.VEmNU5IY2yrcxHrjsZSlQ67O0uPa.EG', 1, 'admin', 1);

commit;