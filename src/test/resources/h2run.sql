CREATE TABLE IF NOT EXISTS client (
    id INT PRIMARY KEY NOT NULL auto_increment,
    name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    email VARCHAR(50) NOT NULL,
    fired BOOLEAN NOT NULL DEFAULT (FALSE),
    CONSTRAINT client CHECK (TRIM(name) != '' AND
                             TRIM(surname) != '' AND
                             TRIM(email) != '')
);