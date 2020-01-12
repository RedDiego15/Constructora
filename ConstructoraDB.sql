create database Constructora;
use Constructora;
create table Usuarios(
	cedula varchar(10) primary Key,
    Pasaporte varchar(20),
    Contrasenia  varchar(50),
    rol char
);
create table Empresas(
	idEmpresa int auto_increment primary Key,
    Nombre varchar(100),
    Direccion  varchar(100),
    Telefono_Trabajo varchar(10),
    cedula_cliente varchar(10)
);
create table Elementos(
	idElemento int auto_increment primary Key,
	Tipo_de_elemento varchar(100),
    Precio float
);
create table Empleados(
	Cedula varchar(10) primary Key,
    Pasaporte varchar(20),
    Nombre varchar(10),
    Apellido varchar(10),
	Correo varchar(30),
    NumCelular varchar(10),
	Telefono_Trabajo varchar(20),
    Estado_Civil varchar(10),
    cargo varchar(20),
    Activo boolean
);

create table Clientes(
	Cedula varchar(10) primary Key,
    idEmpresa int,
    Pasaporte varchar(20),
    Nombre varchar(10),
    Apellido varchar(10),
    NumCelular varchar(10),
    Correo varchar(30),
    Direccion_Domicilio varchar(100),
    Estado_Civil varchar(10),
    cargoEmpresa varchar(30),
    NumHijos int,
   foreign key (idEmpresa) references Empresas(idEmpresa)
);
create table Casas(
	idCasa int auto_increment primary Key,
    cliente varchar(10),
	-- idElementos_casa int,
    Metros_cuadrados float,
    NumPlantas  int,
    Esquinera boolean,
    Orientacion varchar(10),
    TmnPatio float,
    NumHabitaciones int,
    numBanios int,
    Precio float,
	foreign key (cliente) references Clientes(cedula)
    
);
create table Reportes(
	NumReporte int auto_increment primary Key,
    cliente varchar(10),
	-- idElementos_casa int,
    Empleado varchar(10),
    Fecha  Date,
    Descripcion varchar(200),
    foreign key (cliente) references Clientes(cedula),
    foreign key (Empleado) references Empleados(cedula)
);

create table Elementos_casa(
	idEC int auto_increment primary Key,
	casa int,
    Elemento int,
    
   foreign key (casa) references Casas(idCasa),
   foreign key (Elemento) references Elementos(idElemento)
);















-- Se debe hacer en este orden

insert into Empresas (Nombre,Direccion,Telefono_Trabajo,cedula_cliente) values("Empresa1","6 de diciembre y rio coca","1234567","1105164931");

insert into Clientes values("1105164931",1,"1263456",'Diego','Rojas','0995977694','correo@','alborada X','soltero','CTO',2);

insert into Casas (Metros_cuadrados,cliente,NumPlantas,Esquinera,Orientacion,TmnPatio,NumHabitaciones,NumBanios,Precio)
values(250,'1105164931',3,true,'derecha',40,4,4,150000);

insert into Casas (Metros_cuadrados,cliente,NumPlantas,Esquinera,Orientacion,TmnPatio,NumHabitaciones,NumBanios,Precio)
values(150,'1105164931',2,false,'derecha',40,3,3,100000);

-- Diego esta asociado a la casa 1 y 2
 insert into Usuarios (cedula,contrasenia,rol) values('123','711383a59fda05336fd2ccf70c8059d1523eb41a',1);




-- Primero debe existir el Elemento 
insert into Elementos (Tipo_de_Elemento,Precio) values("cerrucho",100);
insert into Elementos (Tipo_de_Elemento,Precio) values("cortadora",100);
insert into Elementos (Tipo_de_Elemento,Precio) values("podadora",100);
insert into Elementos (Tipo_de_Elemento,Precio) values("lampara",100);
-- Despues los organizo en elementos casa

insert into Elementos_Casa (Casa,Elemento)
values(1,1);
insert into Elementos_Casa (Casa,Elemento)
values(1,2);insert into Elementos_Casa (Casa,Elemento)
values(1,3);

insert into Elementos_Casa (Casa,Elemento)
values(2,1);


SELECT * from empresas em
join clientes c on em.idEmpresa = c.idEmpresa
join casas ca on ca.cliente = c.cedula
join elementos_casa el on el.casa = ca.idCasa
join elementos e on e.idElemento = el.Elemento;

select* from casas;

-- drop database Constructora;
-- drop table empresas;
-- drop table clientes;
-- drop table casas;
-- drop table elementos_casa;
 -- drop table Usuarios;
-- DELETE from Casas where idCasa =2;

show tables;






