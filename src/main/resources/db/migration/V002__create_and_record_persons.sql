CREATE TABLE person (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    street VARCHAR(30),
    number VARCHAR(30),
    complement VARCHAR(30),
    district VARCHAR(30),
    zip VARCHAR(30),
    city VARCHAR(30),
    state VARCHAR(30),
    active BOOLEAN NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO person (name, street, number, complement, district, zip, city, state, active)
VALUES ('Ana Arantes', 'Rua do Cachorro', '1000', null, 'Ferro', '99100-100', 'Porto Alegre', 'RS', true);
INSERT INTO person (name, street, number, complement, district, zip, city, state, active)
VALUES ('Beatriz Bolivar', 'Rua do Gato', '1005', null, 'Mercurio', '99100-200', 'Porto Alegre', 'RS', true);
INSERT INTO person (name, street, number, complement, district, zip, city, state, active)
VALUES ('Carlos Cervantes', 'Rua da Capivara', '1040', null, 'Prata', '99100-300', 'Porto Alegre', 'RS', true);
INSERT INTO person (name, street, number, complement, district, zip, city, state, active)
VALUES ('Diana Dorneles', 'Rua da Cobra', '1023', null, 'Ouro', '99100-400', 'Porto Alegre', 'RS', true);
INSERT INTO person (name, street, number, complement, district, zip, city, state, active)
VALUES ('Everton Arantes', 'Rua do Lagarto', '1700', null, 'Cromo', '99100-500', 'Porto Alegre', 'RS', true);
INSERT INTO person (name, street, number, complement, district, zip, city, state, active)
VALUES ('Felicia Fonceca', 'Rua do Urso', '1251', 'Apto 15', 'Vanadio', '99100-600', 'Porto Alegre', 'RS', true);
INSERT INTO person (name, street, number, complement, district, zip, city, state, active)
VALUES ('Giovane Giacono', 'Rua da Raposa', '1900', null, 'Aluminio', '99100-700', 'Porto Alegre', 'RS', true);
INSERT INTO person (name, street, number, complement, district, zip, city, state, active)
VALUES ('Heloisa Herculea', 'Rua do Sapo', '1850', null, 'Titanio', '99100-800', 'Porto Alegre', 'RS', true);
INSERT INTO person (name, street, number, complement, district, zip, city, state, active)
VALUES ('Igor Iorik', 'Rua do Camelo', '1340', null, 'Vanadio', '99100-900', 'Porto Alegre', 'RS', true);
INSERT INTO person (name, street, number, complement, district, zip, city, state, active)
VALUES ('Julia Junqueira', 'Rua do Rato', '1012', 'Apto 10', 'Chumbo', '99100-150', 'Porto Alegre', 'RS', true);
