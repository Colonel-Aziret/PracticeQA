create table "PracticeQA".flight
(
    model           varchar   not null,
    departure_time  timestamp not null,
    departure_from  varchar   not null,
    arrival         varchar   not null,
    flight_duration integer   not null,
    seats           integer,
    flight_number   varchar   not null
        constraint flight_ticket_flight_number_fk
            references "PracticeQA".ticket (flight_number)
);

alter table "PracticeQA".flight
    owner to postgres;

create unique index flight_departure_from_uindex
    on "PracticeQA".flight (departure_from);

create unique index flight_arrival_uindex
    on "PracticeQA".flight (arrival);

