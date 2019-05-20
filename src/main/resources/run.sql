DROP TABLE client, plan, tasks_list, members_list,plan_tasks;

CREATE TABLE IF NOT EXISTS client (
    id INT PRIMARY KEY NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    email VARCHAR(50) NOT NULL,
    fired BOOLEAN NOT NULL DEFAULT (FALSE),
    CONSTRAINT client CHECK (TRIM(name) != '' AND
                             TRIM(surname) != '' AND
                             TRIM(email) != '')
);

CREATE TABLE  IF NOT EXISTS plan (
     id INT PRIMARY KEY NOT NULL GENERATED BY DEFAULT AS IDENTITY,
     client_id INT NOT NULL UNIQUE references client(id) ON DELETE CASCADE,
     plan_date_start DATE NOT NULL,
     plan_date_end DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS plan_tasks (
     id INT PRIMARY KEY NOT NULL GENERATED BY DEFAULT AS IDENTITY,
     plan_id INT NOT NULL references plan(id) ON DELETE CASCADE,
     plan_tasks_date_end DATE NOT NULL,
     plan_tasks_description VARCHAR(512) NOT NULL,
     priority VARCHAR(32) NOT NULL,
     CONSTRAINT plan_tasks CHECK ((TRIM(priority) != '') AND TRIM(plan_tasks_description) != '')
);

CREATE TABLE IF NOT EXISTS tasks_list (
    id INT PRIMARY KEY NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    plan_tasks_id INT NOT NULL references plan_tasks(id) ON DELETE CASCADE,
    task_is_done BOOLEAN NOT NULL DEFAULT (FALSE),
    task_description VARCHAR(512) NOT NULL,
    CONSTRAINT tasks_list CHECK (TRIM(task_description) != '')
);

CREATE TABLE IF NOT EXISTS members_list(
    id INT PRIMARY KEY NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    plan_tasks_id INT NOT NULL references plan_tasks(id) ON DELETE CASCADE,
    requirements VARCHAR(512) NOT NULL,
    CONSTRAINT members_list CHECK (TRIM(requirements) != '')
);

--TRUNCATE Client CASCADE;


