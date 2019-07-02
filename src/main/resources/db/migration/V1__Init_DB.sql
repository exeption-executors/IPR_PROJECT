CREATE TABLE IF NOT EXISTS client (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role varchar(32),
    fired BOOLEAN NOT NULL DEFAULT (FALSE),
    CONSTRAINT client CHECK (TRIM(name) != '' AND
                             TRIM(surname) != '' AND
                             TRIM(email) != '' AND
                             TRIM(password) != '')
);

CREATE TABLE  IF NOT EXISTS plan (
     id BIGSERIAL PRIMARY KEY NOT NULL,
     client_id BIGSERIAL NOT NULL references client(id) ON DELETE CASCADE,
     plan_date_start DATE NOT NULL,
     plan_date_end DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS section (
     id BIGSERIAL PRIMARY KEY NOT NULL,
     plan_id BIGSERIAL NOT NULL references plan(id) ON DELETE CASCADE,
     section_date_end DATE NOT NULL,
     section_description VARCHAR(512) NOT NULL,
     priority VARCHAR(32) NOT NULL,
     CONSTRAINT section CHECK ((TRIM(priority) != '') AND TRIM(section_description) != '')
);

CREATE TABLE IF NOT EXISTS point (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    section_id BIGSERIAL  NOT NULL references section(id) ON DELETE CASCADE,
    point_is_done BOOLEAN NOT NULL DEFAULT (FALSE),
    point_description VARCHAR(512) NOT NULL,
    CONSTRAINT point CHECK (TRIM(point_description) != '')
);

CREATE TABLE IF NOT EXISTS partner(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    section_id BIGSERIAL references section(id) ON DELETE CASCADE,
    client_id BIGSERIAL references client(id) ON DELETE CASCADE,
    requirements VARCHAR(512) NOT NULL,
    CONSTRAINT partner CHECK (TRIM(requirements) != '')
);
