create sequence hibernate_sequence start 1 increment 1

create table comment
(
    id        int8 not null,
    comment   varchar(255),
    serial_id   int8,
    rating_id int8,
    user_id   int8,
    primary key (id)
);

create table serial
(
    id          int8 not null,
    description varchar(4096) not null,
    filename    varchar(255),
    title       varchar(255) not null,
    view        int4,
    user_id     int8,
    primary key (id)
);

create table serial_comments
(
    serial_id     int8 not null,
    comments_id int8 not null,
    primary key (serial_id, comments_id)
);
create table serial_rating
(
    serial_id   int8 not null,
    rating_id int8 not null,
    primary key (serial_id, rating_id)
);
create table genre_name
(
    genre_id int8 not null,
    genres   varchar(255)
);
create table rating
(
    id      int8 not null,
    value   int4,
    user_id int8,
    primary key (id)
);
create table user_role
(
    user_id int8 not null,
    roles   varchar(255)
);
create table usr
(
    id       int8    not null,
    active   boolean not null,
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
);

alter table if exists serial_comments add constraint exH3x5PnNJd4OSQqhCvIpma5S2 unique (comments_id);

alter table if exists serial_rating add constraint AVPruq3xrZlxtzBWRLTkPm7r8Q unique (rating_id);

alter table if exists comment add constraint HXIPp5DCpV7pG8Qcu6wfa3HHrC foreign key (serial_id) references serial;

alter table if exists comment add constraint mIsxvjJUhjWqNyBrzhG31rt6k6  foreign key (rating_id) references rating;

alter table if exists comment add constraint i5Hf4BrJkk2Q6VMRlDaul1WFLN foreign key (user_id) references usr;

alter table if exists serial add constraint LpQeG4NWrf1WUKfBjuvW87HzWY foreign key (user_id) references usr;

alter table if exists serial_comments add constraint QSyxuyUB1nx0priAFsRigaEoar foreign key (comments_id) references comment;

alter table if exists serial_comments add constraint kQ9hUfXpmJE8Fs0mmpv4Mc6FqC foreign key (serial_id) references serial;

alter table if exists serial_rating add constraint q6hyJZfVPCMGWl6gtmQ5ldl3HX foreign key (rating_id) references rating;

alter table if exists serial_rating add constraint eUfagZBfntE6W40RDXBjaSAXRM foreign key (serial_id) references serial;

alter table if exists genre_name add constraint ej4GypiXZVjBwRX6VQ1VP7n37S foreign key (genre_id) references serial;

alter table if exists rating add constraint xAfSZq2AJFdV64uPeDPtOB3LWN foreign key (user_id) references usr;

alter table if exists user_role add constraint YGefn0QU68JWm1iEz83mnKFDXS foreign key (user_id) references usr;

