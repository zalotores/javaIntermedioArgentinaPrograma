/* elegir DDBB*/
USE argentina_programa;
/* creacion de tablas*/
CREATE TABLE clientes(
dni int unsigned NOT NULL UNIQUE, 
nombre VARCHAR(250), 
direccion VARCHAR(250), 
mail VARCHAR(250), 
primary key (dni));
CREATE TABLE categorias(
id integer unsigned NOT NULL UNIQUE auto_increment, 
descripcion VARCHAR(250), 
primary key (id));
CREATE TABLE tecnicos(
id integer unsigned NOT NULL UNIQUE auto_increment, 
nombre VARCHAR(250), 
primary key (id));
CREATE TABLE ordenes(
id integer unsigned NOT NULL UNIQUE auto_increment, 
descripcion VARCHAR(250),
costo VARCHAR(250),
fecha_orden DATE,
estado VARCHAR(250),
id_cliente int unsigned,
id_categoria int unsigned,
id_tecnico int unsigned,
primary key (id));
/* carga de datos*/
INSERT INTO clientes (dni, nombre, direccion, mail) 
VALUES (23425741, 'Juan Perez', 'Calle Falsa 123, La Quiaca, Jujuy', 'postmaster@hotmail.com');
INSERT INTO clientes (dni, nombre, direccion, mail) 
VALUES (45727112, 'Maria Ansiedad', 'Av Cabildo 2233, Capital Federal', 'milipili@gmail.com');
INSERT INTO clientes (dni, nombre, direccion, mail) 
VALUES (7025774, 'Mirtha Legrand', 'Cordoba 121, Villa Cañas, Santa Fe', 'chiqui07@aol.com.ar');
INSERT INTO categorias(descripcion) VALUES ('Fija');
INSERT INTO categorias(descripcion) VALUES ('Movil');
INSERT INTO categorias(descripcion) VALUES ('Fija + Movil');
INSERT INTO categorias(descripcion) VALUES ('Control');
INSERT INTO tecnicos(nombre) VALUES ('Juan Perez');
INSERT INTO tecnicos(nombre) VALUES ('Pedro Perez Pereyra');
INSERT INTO tecnicos(nombre) VALUES ('Margo Thompson');
INSERT INTO ordenes(descripcion, costo, fecha_orden, estado, id_cliente, id_categoria, id_tecnico) 
VALUES ('Fibra cortada', '1100', '2020-11-11', 'Cerrado', 45727112, 1, 3);
INSERT INTO ordenes(descripcion, costo, fecha_orden, estado, id_cliente, id_categoria, id_tecnico) 
VALUES ('Fibra cortada', '1100', '2020-11-18', 'Abierto', 45727112, 1, 2);
/* select para comprobar datos*/
select * from ordenes;
