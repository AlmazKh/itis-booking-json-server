insert into cabinet (capacity, floor, number)
values (20, 13,1301);
insert into cabinet (capacity, floor, number)
values (20, 13,1302);
insert into cabinet (capacity, floor, number)
values (20, 13,1303);
insert into cabinet (capacity, floor, number)
values (20, 13,1304);
insert into cabinet (capacity, floor, number)
values (20, 13,1305);
insert into cabinet (capacity, floor, number)
values (30, 13,1306);
insert into cabinet (capacity, floor, number)
values (30, 13,1307);
insert into cabinet (capacity, floor, number)
values (30, 13,1308);
insert into cabinet (capacity, floor, number)
values (30, 13,1309);
insert into cabinet (capacity, floor, number)
values (30, 13,1310);
insert into cabinet (capacity, floor, number)
values (20, 13,1311);
insert into cabinet (capacity, floor, number)
values (20, 14,1404);
insert into cabinet (capacity, floor, number)
values (20, 14,1405);
insert into cabinet (capacity, floor, number)
values (30, 14,1408);
insert into cabinet (capacity, floor, number)
values (30, 14,1409);
insert into cabinet (capacity, floor, number)
values (20, 14,1412);
insert into cabinet (capacity, floor, number)
values (30, 15,1509);
insert into cabinet (capacity, floor, number)
values (20, 15,1508);



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

insert into business (date, status, time, cabinet_id, usr_id)
values ('11/04/2020', 'Booked', 'FirstClass', 3, 1);
insert into business (date, status, time, cabinet_id, usr_id)
values ('11/04/2020', 'Booked', 'SecondClass', 3, 1);
insert into business (date, status, time, cabinet_id, usr_id)
values ('11/04/2020', 'Booked', 'ThirdClass', 3, 1);
insert into business (date, status, time, cabinet_id, usr_id)
values ('11/04/2020', 'Booked', 'FourthClass', 3, 1);
insert into business (date, status, time, cabinet_id, usr_id)
values ('11/04/2020', 'Booked', 'FifthClass', 3, 1);
insert into business (date, status, time, cabinet_id, usr_id)
values ('11/04/2020', 'Booked', 'SixthClass', 3, 1);


DO
$do$
    BEGIN
        FOR i IN 1..(SELECT count(*) FROM cabinet)
            LOOP
                insert into free_time (time, cabinet_id)
                values ('FirstClass', i);
                insert into free_time (time, cabinet_id)
                values ('SecondClass', i);
                insert into free_time (time, cabinet_id)
                values ('ThirdClass', i);
                insert into free_time (time, cabinet_id)
                values ('FourthClass', i);
                insert into free_time (time, cabinet_id)
                values ('FifthClass', i);
                insert into free_time (time, cabinet_id)
                values ('SixthClass', i);
            END LOOP;
    END;
$do$;
