
-- +migrate Up
create table demo11(
    id serial primary key,
    name varchar(255) not null,
    fecha date,
    created_at timestamp with time zone default now(),
    updated_at timestamp with time zone default now()
);
-- +migrate Down
drop table demo11;