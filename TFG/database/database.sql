CREATE TABLE Pacient(idPacient INTEGER PRIMARY KEY, nomPacient,edat,anysEscola);
CREATE TABLE Dia(anymesdia PRIMARY KEY, any, mes, dia, idPacient);
CREATE TABLE Segment(idSegment INTEGER PRIMARY KEY, horaInici, minutInici, segonInici, horaFinal, minutFinal, segonFinal, anymesdia);
CREATE TABLE Pregunta(idPregunta INTEGER PRIMARY KEY, pregunta, resposta, idSegment);
CREATE TABLE Imatge(nomImatge PRIMARY KEY, path, hora, minut, segon, idSegment);
CREATE TABLE DescripcioDia(idDescripcioDia INTEGER PRIMARY KEY, descripcio, anymesdia);
CREATE TABLE DescripcioSegment(idDescripcioSegment INTEGER PRIMARY KEY, descripcio, idSegment);
