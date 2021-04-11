
insert into public.person values(nextval('public.person_id_seq'), 10, 'John@gmail.com', 'John');

insert into public.person values(nextval('public.person_id_seq'), 22, 'Jane@gmail.com', 'Jane');

commit;
