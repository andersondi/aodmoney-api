CREATE TABLE category (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO category (name) VALUES ('Lazer');
INSERT INTO category (name) VALUES ('Alimenteção');
INSERT INTO category (name) VALUES ('Supermercado');
INSERT INTO category (name) VALUES ('Farmácia');
INSERT INTO category (name) VALUES ('Outros');