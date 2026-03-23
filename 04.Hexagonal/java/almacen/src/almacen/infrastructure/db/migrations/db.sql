create table articulo (
    id int primary key,
    codigo varchar(255) not null unique,
    nombre varchar(255) not null
);

create table empleado (
    id int primary key,
    nombre varchar(255) not null
);

create table solicitud (
    id int primary key,
    fecha date not null,
    id_empleado int,
    foreign key (id_empleado) references empleado(id)
);

create table detalle_solicitud (
    id_solicitud int,
    id_articulo int,
    cantidad int not null,
    primary key (id_solicitud, id_articulo),
    foreign key (id_solicitud) references solicitud(id),
    foreign key (id_articulo) references articulo(id)
);
