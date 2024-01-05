CREATE SEQUENCE event_id_event_sequnce;

CREATE OR REPLACE TRIGGER event_on_insert
BEFORE INSERT ON EVENT
FOR EACH ROW
    BEGIN
        SELECT event_id_event_sequnce.nextval
        INTO :new.id_event
        FROM dual;
    END;

CREATE SEQUENCE transportation_id_transport_sequence;

CREATE OR REPLACE TRIGGER transportation_on_insert
BEFORE INSERT ON TRANSPORTATION
FOR EACH ROW
    BEGIN
        SELECT transportation_id_transport_sequence.nextval
        INTO :new.id_transport
        FROM dual;
    END;

CREATE SEQUENCE menu_id_menu_sequence;

drop sequence event_id_event_sequnce;
drop trigger event_on_insert;

CREATE OR REPLACE TRIGGER menu_on_insert
BEFORE INSERT ON MENU
FOR EACH ROW
    BEGIN
        SELECT menu_id_menu_sequence.nextval
        INTO :new.id_menu
        FROM dual;
    END;

CREATE SEQUENCE drinks_id_drinks_sequnce;

CREATE OR REPLACE TRIGGER drinks_on_insert
BEFORE INSERT ON DRINKS
FOR EACH ROW
    BEGIN
        SELECT drinks_id_drinks_sequnce.nextval
        INTO :new.id_drinks
        FROM dual;
    END;

CREATE SEQUENCE persons_id_person_sequence;

CREATE OR REPLACE TRIGGER persons_on_insert
BEFORE INSERT ON PERSONS
FOR EACH ROW
    BEGIN
        SELECT persons_id_person_sequence.nextval
        INTO :new.id_person
        FROM dual;
    END;