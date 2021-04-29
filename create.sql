create sequence hibernate_sequence start with 1 increment by 1;
create table owner (id bigint not null, created_at timestamp, updated_at timestamp, first_name varchar(255), last_name varchar(255), address varchar(255), city varchar(255), telephone varchar(255), primary key (id))
create table pet (id bigint not null, created_at timestamp, updated_at timestamp, dob date, name varchar(255), owner_id bigint, pet_type_id bigint, primary key (id))
create table pet_type (id bigint not null, created_at timestamp, updated_at timestamp, name varchar(255), primary key (id))
create table speciality (id bigint not null, created_at timestamp, updated_at timestamp, description varchar(255), primary key (id))
create table vet (id bigint not null, created_at timestamp, updated_at timestamp, first_name varchar(255), last_name varchar(255), primary key (id))
create table vet_speciality (vet_id bigint not null, speciality_id bigint not null, primary key (vet_id, speciality_id))
create table visit (id bigint not null, created_at timestamp, updated_at timestamp, date date, description varchar(255), pet_id bigint, primary key (id))
alter table pet add constraint FK7qfti9yba86tgfe9oobeqxfxg foreign key (owner_id) references owner
alter table pet add constraint FKc1u0f9npdkvdswepubsjkdb5f foreign key (pet_type_id) references pet_type
alter table vet_speciality add constraint FKns25xuxcyf46sbycxgsblcvja foreign key (speciality_id) references speciality
alter table vet_speciality add constraint FKoh5v7f4x7bl2m2lkaw69h4lr7 foreign key (vet_id) references vet;
alter table visit add constraint FKpr2103nfb1ueid78p80lvv1ed foreign key (pet_id) references pet;
