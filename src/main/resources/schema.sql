CREATE TABLE IF NOT EXISTS client(
  id integer not null auto_increment,
  name varchar(255) not null,
  email varchar (255) not null,
  surname varchar(255),
  primary key (id)
);