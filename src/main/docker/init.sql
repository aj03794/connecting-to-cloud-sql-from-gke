DROP TABLE IF EXISTS todos;

CREATE TABLE todos (
id char(36) NOT NULL,
name varchar(32) NOT NULL,
description text,
PRIMARY KEY (id));