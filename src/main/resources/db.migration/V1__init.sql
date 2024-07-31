CREATE TABLE IF NOT EXISTS users(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE
);

CREATE TABLE IF NOT EXISTS products(
    id BIGSERIAL PRIMARY KEY,
    account_number VARCHAR(25) UNIQUE,
    balance DECIMAL,
    type VARCHAR(10),
    user_id BIGINT REFERENCES users (id)
);

INSERT INTO users (username)
VALUES ('Alex'), ('John'), ('Mike');

INSERT INTO products(account_number, balance, type, user_id)
VALUES ('40702810501', 105.02, 'card', 1),
       ('40702810502', 302.25, 'card', 2),
       ('40702810503', 415.75, 'account', 2),
       ('40702810504', 186.94, 'card', 3),
       ('40702810505', 720.20, 'account', 3),
       ('40702810506', 137.45, 'account', 3);