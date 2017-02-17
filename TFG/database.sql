
CREATE TABLE Usuari(idUsuari PRIMARY KEY, nomUsuari,contrasenya,rol);

CREATE TABLE Pacient(idPacient INTEGER PRIMARY KEY, nomPacient,edat,anysEscola,idUsuari);

CREATE TABLE Sessio(idSessio INTEGER PRIMARY KEY, numSessio, any, mes, dia, idPacient);

CREATE TABLE Resposta(idResposta INTEGER PRIMARY KEY, pregunta, resposta, idSessio);

CREATE TABLE Descripcio(idDescripcio INTEGER PRIMARY KEY, descripcio, idSessio);

CREATE TABLE Gravacio(idGravacio INTEGER PRIMARY KEY, nom, data, idSessio);

CREATE TABLE Timestamp(idTimestamp INTEGER PRIMARY KEY, temps, idGravacio);

