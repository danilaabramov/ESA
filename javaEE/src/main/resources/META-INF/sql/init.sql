DROP  TABLE IF EXISTS hospitals CASCADE;
DROP  TABLE IF EXISTS rooms CASCADE;
DROP  TABLE IF EXISTS patients CASCADE;

create table hospitals (
 id_hospital integer primary key
);

create table rooms(
 id_hospital int references hospitals(id_hospital),
 id_room int primary key
);

create table patients(
 id_hospital int references hospitals(id_hospital),
 id_card int primary key,
 id_room int references rooms(id_room),
 full_name text not null,
 gender text check(gender = 'F' or gender ='M'),
 years int
);