/* elegir DDBB*/
USE argentina_programa;

/* creo tablas de canciones, discos, interprete y genero*/
CREATE TABLE canciones(
id INT(11) unsigned NOT NULL UNIQUE auto_increment, 
nombre VARCHAR(50), 
duracion VARCHAR(10), 
interprete_id VARCHAR(50), 
genero_id VARCHAR(50), 
disco_id VARCHAR(50), 
primary key (id));

CREATE TABLE discos ( 
id INT(11) unsigned NOT NULL UNIQUE auto_increment, 
nombre VARCHAR(50), 
interprete_id integer, 
primary key (id));

CREATE TABLE interpretes ( 
id INT(11) unsigned NOT NULL UNIQUE auto_increment, 
nombre VARCHAR(50), 
primary key (id));

CREATE TABLE generos ( 
id INT(11) unsigned NOT NULL UNIQUE auto_increment, 
nombre VARCHAR(50), 
primary key (id));

/* inserto unos valores de prueba */

INSERT INTO generos( nombre) VALUES ( "Rock");
INSERT INTO generos( nombre) VALUES ( "Pop");
INSERT INTO interpretes( nombre) VALUES ( "Queen");
INSERT INTO interpretes( nombre) VALUES ( "Madonna");
INSERT INTO discos ( nombre, interprete_id) VALUES ("A Night at the Opera", 1);
INSERT INTO discos ( nombre, interprete_id) VALUES ("Like a Virgin", 2);
INSERT INTO discos ( nombre, interprete_id) VALUES ("The Game", 1);
INSERT INTO canciones ( nombre, duracion, interprete_id, genero_id, disco_id) VALUES ( 
"Bohemian Rhapsody", "5:55", 1, 1, 1);
INSERT INTO canciones ( nombre, duracion, interprete_id, genero_id, disco_id) VALUES ( 
"Another One Bites the Dust", "3:35", 1, 2, 1);
INSERT INTO canciones ( nombre, duracion, interprete_id, genero_id, disco_id) VALUES ( 
"Like a Virgin", "3:39", 2, 2, 2);

/* pruebo con un select */

SELECT C.nombre, duracion, D.nombre AS 'disco', I.nombre AS 'interprete', G.nombre AS 'género' 
FROM canciones C INNER JOIN discos D ON C.disco_id = D.id 
INNER JOIN interpretes I ON C.interprete_id = I.id
INNER JOIN generos G ON C.genero_id = G.id;