
-- +migrate Up
create table demo10(
    id serial primary key,
    name varchar(255) not null,
    created_at timestamp with time zone default now(),
    updated_at timestamp with time zone default now()
);
-- +migrate Down
drop table demo10;