create table "PracticeQA".ticket
(
    client_id          integer   not null,
    flight_number      varchar   not null,
    ticket_pickup_time timestamp not null,
    ticket_number      varchar   not null
);

alter table "PracticeQA".ticket
    owner to postgres;

create unique index ticket_flight_number_uindex
    on "PracticeQA".ticket (flight_number);

create unique index ticket_id_uindex
    on "PracticeQA".ticket (client_id);

create unique index ticket_ticket_number_uindex
    on "PracticeQA".ticket (ticket_number);

