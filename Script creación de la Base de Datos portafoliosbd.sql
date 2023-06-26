create table usuarios (
    id int not null auto_increment primary key,
    nombre varchar (255) not null,
    correo_electronico varchar (255) not null,
    contrasena varchar (255) not null,
    fecha_registro date not null,
    estado varchar (255) not null
);