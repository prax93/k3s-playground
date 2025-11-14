
DROP TABLE IF EXISTS todos CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS roles CASCADE;

CREATE TYPE status AS ENUM ('backlog', 'progres', 'done');

CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	user_name VARCHAR (80) NOT NULL UNIQUE,
	password VARCHAR (80) NOT NULL,
	admin BOOLEAN DEFAULT FALSE
);

CREATE TABLE todos (
	todo_id SERIAL PRIMARY KEY,
	user_id INTEGER REFERENCES users(user_id),
	todo VARCHAR (80) NOT NULL,
	todo_status status NOT NULL
);

CREATE TABLE roles (
	role_id SERIAL PRIMARY KEY,
	role VARCHAR (80) UNIQUE NOT NULL
);

CREATE TABLE user_roles (
	PRIMARY KEY (user_id, role_id),
	user_id INTEGER REFERENCES users(user_id),
	role_id INTEGER REFERENCES roles(role_id)
);

INSERT INTO roles (role) VALUES ('basic');
INSERT INTO roles (role) VALUES ('full');

INSERT INTO users (user_name, password, admin) VALUES ('admin', 'admin', TRUE);
INSERT INTO users (user_name, password, admin) VALUES ('shana', 'abkl123!!', TRUE);
INSERT INTO users (user_name, password, admin) VALUES ('alessia', 'alessia', FALSE);

INSERT INTO user_roles (user_id, role_id) VALUES (2,2);
INSERT INTO user_roles (user_id, role_id) VALUES (3,1);
INSERT INTO user_roles (user_id, role_id) VALUES (1,1);

INSERT INTO todos (user_id, todo, todo_status) VALUES (1, 'K3s installieren', 'done');
INSERT INTO todos (user_id, todo, todo_status) VALUES (1, 'CI Installieren', 'backlog');