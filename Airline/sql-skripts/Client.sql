create table "PracticeQA".clients
(
    inn     varchar not null,
    id      integer not null
        constraint clients_pk
            primary key
        constraint clients_ticket_client_id_fk
            references "PracticeQA".ticket (client_id),
    fio     varchar not null,
    gender  varchar,
    country varchar
);

alter table "PracticeQA".clients
    owner to postgres;

create unique index clients_id_uindex
    on "PracticeQA".clients (id);

create unique index clients_inn_uindex
    on "PracticeQA".clients (inn);

create unique index clients_country_uindex
    on "PracticeQA".clients (country);

