create table "PracticeQA".country
(
    code varchar not null
        constraint country_pk
            primary key
        constraint country_airport_country_code_fk
            references "PracticeQA".airport (country_code),
    name varchar not null
        constraint country_clients_country_fk
            references "PracticeQA".clients (country)
);

alter table "PracticeQA".country
    owner to postgres;

create unique index country_code_uindex
    on "PracticeQA".country (code);

create unique index country_name_uindex
    on "PracticeQA".country (name);

