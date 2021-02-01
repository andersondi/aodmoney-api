CREATE TABLE entry(
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR( 255 ) NOT NULL,
    expiration_date DATE NOT NULL,
    purchase_date DATE,
    value DECIMAL( 10, 2 ) NOT NULL,
    comment VARCHAR( 100 ),
    type VARCHAR(20) NOT NULL,
    id_category BIGINT( 20 ) NOT NULL,
    id_person BIGINT( 20 ) NOT NULL,
    FOREIGN KEY ( id_category ) REFERENCES category( id ),
    FOREIGN KEY ( id_person ) REFERENCES person( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO entry( description, expiration_date, purchase_date, value, comment, type, id_category, id_person )
VALUES( 'Salary', '2020-01-10', null, 6500.00, 'Monthly salary receipt', 'RECIPE', 5, 1 );

INSERT INTO entry( description, expiration_date, purchase_date, value, comment, type, id_category, id_person )
VALUES( 'Purchase of medicines', '2020-02-15', '2020-02-16', 80.00, 'Purchase of medicine to treat flu', 'EXPENSE', 4, 7 );

INSERT INTO entry( description, expiration_date, purchase_date, value, comment, type, id_category, id_person )
VALUES( 'Chinese food', '2020-05-22', null, 50.00, 'Lunch in restaurant', 'EXPENSE', 2, 3 );

INSERT INTO entry( description, expiration_date, purchase_date, value, comment, type, id_category, id_person )
VALUES( 'Fruits', '2020-03-16', null, 100.00, 'Purchase of some fruits', 'EXPENSE', 3, 5 );

INSERT INTO entry( description, expiration_date, purchase_date, value, comment, type, id_category, id_person )
VALUES( 'Salary', '2020-11-24', null, 4500.00, 'Monthly salary receipt', 'RECIPE', 5, 10 );

INSERT INTO entry( description, expiration_date, purchase_date, value, comment, type, id_category, id_person )
VALUES( 'Cinema', '2020-09-06', null, 20.00, 'I watched a movie', 'EXPENSE', 1, 2 );

INSERT INTO entry( description, expiration_date, purchase_date, value, comment, type, id_category, id_person )
VALUES( 'Italian food', '2020-06-28', null, 50.00, 'Lunch in restaurant', 'EXPENSE', 2, 1 );

INSERT INTO entry( description, expiration_date, purchase_date, value, comment, type, id_category, id_person )
VALUES( 'Salary', '2020-03-16', null, 5000.00, 'Monthly salary receipt', 'RECIPE', 5, 9 );

INSERT INTO entry( description, expiration_date, purchase_date, value, comment, type, id_category, id_person )
VALUES( 'Thai food', '2020-05-26', null, 50.00, 'Lunch in restaurant', 'EXPENSE', 2, 4 );

INSERT INTO entry( description, expiration_date, purchase_date, value, comment, type, id_category, id_person )
VALUES( 'Received loan payment', '2020-09-06', '2020-10-06', 1000.00, 'Received loan payment from Arthur', 'RECIPE', 4, 8 );