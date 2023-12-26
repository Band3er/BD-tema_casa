INSERT INTO TRANSPORTATION(name, DESCRIPTION, cost) VALUES ('masina', 'alaturi de alex', 20);
INSERT INTO TRANSPORTATION(name, DESCRIPTION, cost) VALUES ('tren', 'plec din gara de la Iasi', 12.2);

INSERT INTO MENU(name, DESCRIPTION, cost) VALUES ('piftie', 'adusa de Maria', 0);
INSERT INTO MENU(name, DESCRIPTION, cost) VALUES ('carne ', 'cumparat de la Kaufland', 11);

INSERT INTO MONEY(PAYMENT_AMOUNT, total) VALUES (120, 200);
INSERT INTO MONEY(PAYMENT_AMOUNT, total) VALUES (50, 455);

INSERT INTO DRINKS(name, DESCRIPTION, cost) VALUES ('vodka', 'de la kaufland', 69.99);
INSERT INTO DRINKS(name, DESCRIPTION, cost) VALUES ('Coca', 'de la kaufland', 13.99);
INSERT INTO DRINKS(name, DESCRIPTION, cost) VALUES ('Pepsi Cola', 'de la kaufland', 15.02);

INSERT INTO EVENT(name, date_event, location) VALUES ('Padure pe Golgota', '12-MAR-2023', 'IASI');
INSERT INTO EVENT(name, date_event, location) VALUES ('Cabana la Rege', '28-FEB-2023', 'Gura Humorului');

INSERT INTO PERSONS(last_name, first_name, age, address, phone_number, email) VALUES ('Sprii', 'Ion', 21, 'B-dul Revolutiei', 758166384, 'ionut3711@gmail.com');
INSERT INTO PERSONS(last_name, first_name, age, address, phone_number, email) VALUES ('Soraba', 'Dia', 19, 'Socola', 0765144089, 'ioan.spiridon@student.tuiasi.ro');

INSERT INTO ENTRIES VALUES (1, 1);
INSERT INTO ENTRIES VALUES (2, 2);

select * from persons;
select * from event;
select * from entries;
select * from drinks;
select * from menu;
select * from money;
select * from transportation;

drop sequence transportation_id_transport_sequence;
drop trigger transportation_on_insert;

drop table entries;
drop table persons;
drop table event;
drop table drinks;
drop table menu;
drop table money;
drop table transportation;

purge RECYCLEBIN;