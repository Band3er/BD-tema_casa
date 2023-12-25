CREATE TABLE EVENT
    (
        ID_EVENT    NUMBER(3)
            CONSTRAINT event_id_event_nn NOT NULL,
        NAME        VARCHAR2(40)
            CONSTRAINT event_name_nn NOT NULL,
            CONSTRAINT event_name_ck CHECK (REGEXP_LIKE(NAME, '^[A-Za-z0-9\s]*$')),
        DATE_EVENT  DATE
            CONSTRAINT event_date_event_nn NOT NULL,
        LOCATION    VARCHAR2(40)
            CONSTRAINT event_location_nn NOT NULL,
        CONSTRAINT event_id_event_pk PRIMARY KEY (ID_EVENT)
    );
drop table event;
CREATE TABLE TRANSPORTATION
    (
        ID_TRANSPORT    NUMBER(3)
            CONSTRAINT transportation_id_transport_nn NOT NULL,
        NAME            VARCHAR2(40)
            CONSTRAINT transportation_name_nn NOT NULL,
            CONSTRAINT transportation_name_ck CHECK (REGEXP_LIKE(NAME, '^[A-Za-z0-9\s]*$')),
        DESCRIPTION     VARCHAR2(60),   
        COST            NUMBER(10)
            CONSTRAINT transportation_cost_nn NOT NULL,
            CONSTRAINT transportation_cost_ck CHECK (COST >= 0),
        CONSTRAINT transportation_id_transport_pk PRIMARY KEY (ID_TRANSPORT)
    );
drop table transportation;
CREATE TABLE MENU
    (
        ID_MENU         NUMBER(3)
            CONSTRAINT menu_id_menu_nn NOT NULL,
        NAME            VARCHAR2(40)
            CONSTRAINT menu_name_nn NOT NULL,
            CONSTRAINT menu_name_ck CHECK (REGEXP_LIKE(NAME, '^[A-Za-z0-9\s]*$')),
        DESCRIPTION     VARCHAR2(60),   
        COST            NUMBER(10)
            CONSTRAINT menu_cost_nn NOT NULL,
            CONSTRAINT menu_cost_ck CHECK (COST >= 0),
        CONSTRAINT menu_id_menu_pk PRIMARY KEY (ID_MENU)
    );
drop table menu;
CREATE TABLE MONEY
    (
        ID_MONEY        NUMBER(3)
            CONSTRAINT money_id_money_nn NOT NULL,
        PAYMENT_AMOUNT  NUMBER(12,2),
        TOTAL           NUMBER(12,2),
            CONSTRAINT money_total_ck CHECK (TOTAL >= 0),
        CONSTRAINT money_id_money_pk PRIMARY KEY (ID_MONEY)
    );
drop table money;
CREATE TABLE DRINKS
    (
        ID_DRINKS       NUMBER(3)
            CONSTRAINT drinks_id_drinks_nn NOT NULL,
        NAME            VARCHAR2(40)
            CONSTRAINT drinks_name_nn NOT NULL,
            CONSTRAINT drinks_name_ck CHECK (REGEXP_LIKE(NAME, '^[A-Za-z0-9\s]*$')),
        DESCRIPTION     VARCHAR2(60),   
        COST            NUMBER(10)
            CONSTRAINT drinks_cost_nn NOT NULL,
            CONSTRAINT drinks_cost_ck CHECK (COST >= 0),
        CONSTRAINT drinks_id_drinks_pk PRIMARY KEY (ID_DRINKS)
    );
drop table drinks;
CREATE TABLE PERSONS 
    (
        ID_PERSON       NUMBER(3)
            CONSTRAINT persons_id_person_nn NOT NULL,
        LAST_NAME       VARCHAR2(30)
            CONSTRAINT persons_last_name_nn NOT NULL,
            CONSTRAINT persons_last_name_ck CHECK (REGEXP_LIKE(LAST_NAME, '[A-Za-z]+\s+')),
        FIRST_NAME      VARCHAR2(30)
            CONSTRAINT persons_first_name_nn NOT NULL,
            CONSTRAINT persons_first_name_ck CHECK (REGEXP_LIKE(FIRST_NAME, '[A-Za-z]+\s+')),
        AGE             NUMBER(3)
            CONSTRAINT persons_age_nn NOT NULL,
            CONSTRAINT persons_age_ck CHECK (AGE > 0),
        ADDRESS         VARCHAR2(100),
        PHONE_NUMBER    NUMBER(10)
            CONSTRAINT persons_phone_number_nn NOT NULL,
            CONSTRAINT persons_phone_number_ck CHECK (AGE LIKE '07%'),
            CONSTRAINT persons_phone_number_uk UNIQUE (PHONE_NUMBER),
        EMAIL           VARCHAR2(50),
            CONSTRAINT persons_email_ck CHECK (REGEXP_LIKE(EMAIL, '[a-zA-Z0-9._%-]+@[a-zA-Z0-9._%-]+\.[a-zA-Z]{2,8}')),
            CONSTRAINT persons_email_uk UNIQUE (EMAIL),
        BUDGET          NUMBER(3),
        TRANSPORT       NUMBER(3),
        MENU            NUMBER(3),
        DRINKS          NUMBER(3),
        CONSTRAINT persons_id_person_pk PRIMARY KEY (ID_PERSON),
        CONSTRAINT persons_budget_fk FOREIGN KEY (BUDGET) REFERENCES MONEY(ID_MONEY),
        CONSTRAINT persons_transport_fk FOREIGN KEY (TRANSPORT) REFERENCES TRANSPORTATION(ID_TRANSPORT),
        CONSTRAINT persons_menu_fk FOREIGN KEY (MENU) REFERENCES MENU(ID_MENU),
        CONSTRAINT persons_drinks_fk FOREIGN KEY (DRINKS) REFERENCES DRINKS(ID_DRINKS)
    );
drop table persons;
CREATE TABLE ENTRIES
    (
        ID_PERSON       NUMBER(3),
        ID_EVENT        NUMBER(3),
        CONSTRAINT entries_id_person_fk FOREIGN KEY (ID_PERSON) REFERENCES PERSONS(ID_PERSON),
        CONSTRAINT entries_id_event_fk FOREIGN KEY (ID_EVENT) REFERENCES EVENT(ID_EVENT)
    );
drop table entries;