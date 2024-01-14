insert into hospitals (id_hospital)
values (1);

insert into rooms (id_hospital, id_room)
VALUES (1, 1, 101),
       (2, 1, 202),
       (3, 1, 303);

INSERT INTO patients (ID_card, id_hospital, id_room, full_name, gender, years)
VALUES (1234, 1, 101, 'Андреев Роман Артурович', 'M', 14),
       (5678, 1, 202, 'Степанова Вероника Максимовна', 'F', 41),
       (9101, 1, 303, 'Кузнецов Иван Артёмович', 'M', 24);