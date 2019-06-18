CREATE TABLE  client (
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(16) NOT NULL,
    fired BOOLEAN NOT NULL,
);

CREATE TABLE  plan (
     id BIGINT PRIMARY KEY NOT NULL,
     client_id BIGINT NOT NULL references client(id) ON DELETE CASCADE,
     plan_date_start DATE NOT NULL,
     plan_date_end DATE NOT NULL
);

CREATE TABLE section (
     id BIGINT PRIMARY KEY NOT NULL,
     plan_id BIGINT NOT NULL references plan(id) ON DELETE CASCADE,
     section_date_end DATE NOT NULL,
     section_description VARCHAR(512) NOT NULL,
     priority VARCHAR(32) NOT NULL,
);

CREATE TABLE  point (
    id BIGINT PRIMARY KEY NOT NULL,
    section_id BIGINT  NOT NULL references section(id) ON DELETE CASCADE,
    point_is_done BOOLEAN NOT NULL,
    point_description VARCHAR(512) NOT NULL,
);

CREATE TABLE  partner(
    id BIGINT PRIMARY KEY NOT NULL,
    section_id BIGINT UNIQUE references section(id) ON DELETE CASCADE,
    requirements VARCHAR(512) NOT NULL,
);

CREATE TABLE support(
    id BIGINT PRIMARY KEY NOT NULL,
    client_id BIGINT NOT NULL UNIQUE references client(id) ON DELETE CASCADE,
    partner_id BIGINT NOT NULL UNIQUE references partner(id) ON DELETE CASCADE
);