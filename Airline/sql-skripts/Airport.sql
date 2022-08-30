create table "PracticeQA".airport
(
    code         varchar not null
        constraint airport_flight_departure_from_fk
            references "PracticeQA".flight (departure_from),
    city         varchar not null,
    country_code varchar not null
);

alter table "PracticeQA".airport
    owner to postgres;

create unique index airport_city_uindex
    on "PracticeQA".airport (city);

create unique index airport_code_uindex
    on "PracticeQA".airport (code);

create unique index airport_country_code_uindex
    on "PracticeQA".airport (country_code);

