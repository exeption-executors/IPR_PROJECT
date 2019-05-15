--DROP TABLE Client, Plan, Plan_Tasks_List,plantaskslist, Task;

CREATE TABLE IF NOT EXISTS Client (
    id INT PRIMARY KEY NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    email VARCHAR(50) NOT NULL,
    vacation_date_from date NOT NULL ,
    vacation_date_to date NOT NULL,
    CONSTRAINT Client CHECK (TRIM(name) != '' or
                             TRIM(surname) != '' or
                             TRIM(email) != '')
);

CREATE TABLE  IF NOT EXISTS Plan (
    id INT PRIMARY KEY NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    client_id INT NOT NULL UNIQUE references Client(id) ON DELETE CASCADE,
    plan_description varchar(256) NOT NULL
    CONSTRAINT Plan CHECK (TRIM(plan_description) != '')
);

CREATE TABLE IF NOT EXISTS Plan_Tasks_List (
    id INT PRIMARY KEY NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    plan_id INT NOT NULL references Plan(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Task (
    id INT PRIMARY KEY NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    plan_tasks_list_id INT NOT NULL references Plan_Tasks_List(id) ON DELETE CASCADE,
    task_description VARCHAR(512) NOT NULL
    CONSTRAINT Task CHECK (TRIM(task_description) != '')
);

--TRUNCATE Client CASCADE;




