CREATE TABLE tb_user (
    id BIGINT PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    email VARCHAR(64) NOT NULL UNIQUE,
    avatar TEXT
);