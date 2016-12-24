CREATE TABLE Pacient(idPacient INTEGER PRIMARY KEY, nomPacient,edat,anysEscola);
CREATE TABLE Sessio(idSessio INTEGER PRIMARY KEY, numSessio, any, mes, dia, idPacient);
CREATE TABLE Descripcio(idDescripcio INTEGER PRIMARY KEY, descripcio, idSessio);
CREATE TABLE Timestamp(idTimestamp INTEGER PRIMARY KEY, temps, idSessio);
CREATE TABLE Imatge(nomImatge PRIMARY KEY, path, hora, minut, segon, idSessio);