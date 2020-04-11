insert into cabinet (capacity, number)
values (20, 1301);
insert into cabinet (capacity, number)
values (35, 1302);
insert into cabinet (capacity, number)
values (35, 1303);

insert into usr (email, group_number, institute, name, priority)
values ('hamedzhanovalmaz@gmail.com', '11-702', 'Высшая школа ИТИС', 'Хамеджанов Алмаз', 0);

insert into business (date, status, time, cabinet_id, usr_id)
values ('11/04/2020', 'Booked', 'FirstClass', 1, 1);
insert into business (date, status, time, cabinet_id, usr_id)
values ('11/04/2020', 'Booked', 'SecondClass', 1, 1);
insert into business (date, status, time, cabinet_id, usr_id)
values ('11/04/2020', 'Booked', 'ThirdClass', 1, 1);
insert into business (date, status, time, cabinet_id, usr_id)
values ('11/04/2020', 'Booked', 'FourthClass', 1, 1);
insert into business (date, status, time, cabinet_id, usr_id)
values ('11/04/2020', 'Booked', 'FifthClass', 2, 1);
insert into business (date, status, time, cabinet_id, usr_id)
values ('11/04/2020', 'Booked', 'SixthClass', 2, 1);

create table time_class
(
    time       varchar(255),
    cabinet_id BIGINT
);

alter table time_class
    add constraint fk_cabinet_id foreign key (cabinet_id) references cabinet;

insert into time_class (time, cabinet_id)
values ('FirstClass', 1);
insert into time_class (time, cabinet_id)
values ('SecondClass', 1);
insert into time_class (time, cabinet_id)
values ('ThirdClass', 1);
insert into time_class (time, cabinet_id)
values ('FourthClass', 1);
insert into time_class (time, cabinet_id)
values ('FifthClass', 1);
insert into time_class (time, cabinet_id)
values ('SixthClass', 1);
insert into time_class (time, cabinet_id)
values ('FirstClass', 2);
insert into time_class (time, cabinet_id)
values ('SecondClass', 2);
insert into time_class (time, cabinet_id)
values ('ThirdClass', 2);
insert into time_class (time, cabinet_id)
values ('FourthClass', 2);
insert into time_class (time, cabinet_id)
values ('FifthClass', 2);
insert into time_class (time, cabinet_id)
values ('SixthClass', 2);

SELECT *
FROM time_class wt
WHERE wt.name NOT IN
      (SELECT b.time FROM business b WHERE b.cabinet_id = 1 AND b.date = '11/04/2020');

SELECT *
FROM cabinet cab JOIN time_class tc on cab.id = tc.cabinet_id
WHERE cab.id NOT IN
      (SELECT b.cabinet_id, b.time FROM business b WHERE b.time NOT IN (SELECT name FROM time_class));



insert into cabinet_businesses(cabinet_id, businesses_id)
values (1, 1);
insert into cabinet_businesses(cabinet_id, businesses_id)
values (1, 2);
insert into cabinet_businesses(cabinet_id, businesses_id)
values (1, 3);
insert into cabinet_businesses(cabinet_id, businesses_id)
values (1, 4);
insert into cabinet_businesses(cabinet_id, businesses_id)
values (2, 5);
insert into cabinet_businesses(cabinet_id, businesses_id)
values (2, 6);

insert into usr_businesses(usr_id, businesses_id)
values (1, 1);
insert into usr_businesses(usr_id, businesses_id)
values (1, 2);
insert into usr_businesses(usr_id, businesses_id)
values (1, 3);
insert into usr_businesses(usr_id, businesses_id)
values (1, 4);
insert into usr_businesses(usr_id, businesses_id)
values (1, 5);
insert into usr_businesses(usr_id, businesses_id)
values (1, 6);


insert into business_time_status_map (business_id, time_status_map, time_status_map_key)
values (1, 'Booked', 'FirstClass');
insert into business_time_status_map (business_id, time_status_map, time_status_map_key)
values (1, 'Booked', 'SecondClass');
insert into business_time_status_map (business_id, time_status_map, time_status_map_key)
values (1, 'Free', 'ThirdClass');
insert into business_time_status_map (business_id, time_status_map, time_status_map_key)
values (1, 'Booked', 'FourthClass');
insert into business_time_status_map (business_id, time_status_map, time_status_map_key)
values (1, 'Booked', 'FifthClass');
insert into business_time_status_map (business_id, time_status_map, time_status_map_key)
values (1, 'Free', 'SixthClass');
'FirstClass'
'SecondClass'
'ThirdClass'
'FourthClass'
'FifthClass'
'SixthClass'