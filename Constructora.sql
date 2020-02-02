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

insert into Casas (Metros_cuadrados,cliente,NumPlantas,Esquinera,Orientacion,TmnPatio,NumHabitaciones,NumBanios,Precio) -- casa cielo
values(250,'1105164931',3,true,'derecha',40,4,4,150000);

insert into Casas (Metros_cuadrados,cliente,NumPlantas,Esquinera,Orientacion,TmnPatio,NumHabitaciones,NumBanios,Precio) -- casa paraiso
values(150,'1105164931',2,false,'derecha',40,3,3,100000);

insert into Casas (Metros_cuadrados,NumPlantas,Esquinera,Orientacion,TmnPatio,NumHabitaciones,NumBanios,Precio) -- casa oasis
values(150,1,false,'derecha',60,2,1,60000);

-- Diego esta asociado a la casa 1 y 2 contra prueba
 insert into Usuarios (cedula,contrasenia,rol) values('123','711383a59fda05336fd2ccf70c8059d1523eb41a',1);




-- Primero debe existir el Elemento 
insert into Elementos (Tipo_de_Elemento,Precio) values("Piso Porcelanato Nacional",100);
insert into Elementos (Tipo_de_Elemento,Precio) values("Piso Porcelanato importado",150);
insert into Elementos (Tipo_de_Elemento,Precio) values("grifería estándar",50);
insert into Elementos (Tipo_de_Elemento,Precio) values("grifería Italiana",100);
insert into Elementos (Tipo_de_Elemento,Precio) values("iluminación tradicional ",60);
insert into Elementos (Tipo_de_Elemento,Precio) values("iluminación led ",120);
insert into Elementos (Tipo_de_Elemento,Precio) values("baños insonorizados",200);
insert into Elementos (Tipo_de_Elemento,Precio) values("Techo con aislante térmico ",500);
-- Despues los organizo en elementos casa

insert into Elementos_casa (Casa,Elemento)
values(1,1);
insert into Elementos_casa (Casa,Elemento)
values(1,2);
insert into Elementos_casa (Casa,Elemento)
values(1,3);

insert into Elementos_casa (Casa,Elemento)
values(2,1);

-- DELETE FROM  Elementos_casa WHERE idEC = 4;


SELECT * FROM Elementos_casa;

-- DELETE FROM  Elementos WHERE idElemento = 4;

SELECT * FROM Elementos;


SELECT * from Empresas em
join Clientes c on em.idEmpresa = c.idEmpresa
join Casas ca on ca.cliente = c.cedula
join Elementos_casa el on el.casa = ca.idCasa
join Elementos e on e.idElemento = el.Elemento;

select* from Casas;

-- drop database Constructora;
-- drop table empresas;
-- drop table clientes;
-- drop table casas;
-- drop table elementos_casa;
 -- drop table Usuarios;
-- DELETE from Casas where idCasa =2;


delimiter $
create procedure iniciaSesion(in ced varchar(10))
Begin
	select * from Usuarios where cedula=ced;
end $
delimiter ;

delimiter $$
create procedure registrarEmpresa(in nombre varchar(10), in direccion  varchar(100),in telefono varchar(10), in cedulaCliente varchar(10))
begin 
    insert into Empresas(Nombre,Direccion,Telefono_Trabajo,cedula_cliente) 
                values(nombre,direccion, telefono, cedulaCliente);
end $$
delimiter ;

delimiter $$
create procedure obtenerEmpresa(in nombre varchar(10), out id INTEGER)
begin 
    select e.idEmpresa into id from Empresas e where e.Nombre=nombre;
end $$
delimiter ;

delimiter $$
create procedure obtenerNombreEmpresas()
begin
select e.Nombre from Empresas e;
end $$
delimiter ;

delimiter $$
create procedure registrarCliente(in id varchar(10), in idEmp integer, in nombre varchar(10),in apellido varchar(10), in numCelular varchar(10), 
										in correo varchar(30), in direccion_Domicilio varchar(100), in estado_Civil varchar(10), in cargo varchar(30), in numHijos int)
begin
	Insert into Clientes(Cedula,idEmpresa,Nombre,Apellido,NumCelular,Correo, Direccion_Domicilio,Estado_Civil,cargoEmpresa,NumHijos)
    values(id,idEmp,nombre,apellido,numCelular,correo,direccion_Domicilio,estado_Civil,cargo,numHijos);
end $$
delimiter ;

delimiter $$
create procedure registrarEmpleado(in cedula varchar(10), in pasaporte varchar(2), in nombre varchar(10),in apellido varchar(10), in correo varchar(30), 
										in numCelular varchar(10), in tlf_trabajo varchar(20), in estado_Civil varchar(10), in cargo varchar(20))
begin
         insert into Empleados 
         values(cedula,pasaporte,nombre,apellido,correo,numCelular,tlf_trabajo,estado_civil,cargo,true);
end $$
delimiter ;

delimiter $$
create procedure crearUsuario(in cedula varchar(10), in pasaporte varchar(20), in pw varchar(50), in rol char)
begin
	Insert into Usuarios values(cedula, pasaporte, pw, rol);
end $$
delimiter ;

delimiter $$
create procedure obtenerClientes()
begin 
	select * from Clientes;
end $$
delimiter ;

delimiter $$
create procedure actualizarCliente(in id varchar(10),in nombre varchar(10),in apellido varchar(10), in numCelular varchar(10), in pasaporte varchar(20),
										in correo varchar(30), in direccion varchar(100),  in numHijos int)
begin
	Update Clientes Set Nombre=nombre, Apellido=apellido, NumCelular=numCelular, Pasaporte=pasaporte, Correo=correo, Direccion_Domicilio=direccion, NumHijos=numHijos Where Cedula=id;
end $$
delimiter ;

CREATE USER 'Constructor'@'localhost' IDENTIFIED BY 'constructor';

GRANT ALL PRIVILEGES ON * . * TO 'Constructor'@'localhost';

FLUSH PRIVILEGES;

SHOW GRANTS FOR 'Constructor'@'localhost';

-- grant select,update,insert on Constructora.Usuarios to 'Constructor2';

SELECT * FROM Elementos_casa;

SELECT * FROM Elementos;

