CREATE TABLE users
(
    user_id   VARCHAR(16) PRIMARY KEY,
    password  VARCHAR(32)        NOT NULL,
    user_name VARCHAR(32)        NOT NULL,
    address   VARCHAR(64)        NOT NULL,
    tel       VARCHAR(16) UNIQUE NOT NULL
);

CREATE TABLE accounts
(
    account_id     SERIAL PRIMARY KEY,
    bank_name      VARCHAR(32) NOT NULL,
    branch_name    VARCHAR(32) NOT NULL,
    account_number INTEGER     NOT NULL,
    account_name   VARCHAR(32) NOT NULL
);

CREATE TABLE products
(
    product_id    SERIAL PRIMARY KEY,
    product_name  VARCHAR(64)         NOT NULL,
    product_price INTEGER             NOT NULL,
    comment       VARCHAR(512)        NOT NULL,
    image         VARCHAR(512) UNIQUE NOT NULL,
    exhibitor_id  VARCHAR(16)         NOT NULL REFERENCES users (user_id),
    account_id    INTEGER             NOT NULL REFERENCES accounts (account_id)
);

CREATE TABLE carts
(
    user_id    VARCHAR(16) REFERENCES users (user_id),
    product_id INTEGER REFERENCES products (product_id),
    PRIMARY KEY (user_id, product_id)
);

CREATE TABLE credit_cards
(
    card_id         SERIAL PRIMARY KEY,
    card_number     CHAR(16) UNIQUE NOT NULL,
    security_cord   CHAR(4)         NOT NULL,
    expiration_date CHAR(5)         NOT NULL
);

CREATE TABLE purchases
(
    purchase_id   SERIAL PRIMARY KEY,
    purchase_date CHAR(12)    NOT NULL,
    purchase_user VARCHAR(32) NOT NULL REFERENCES users (user_id),
    card_id       INTEGER     NOT NULL REFERENCES credit_cards (card_id)
);

CREATE TABLE purchased_details
(
    purchase_id       INTEGER REFERENCES purchases (purchase_id),
    product_id        INTEGER REFERENCES products (product_id),
    purchased_details INTEGER NOT NULL,
    PRIMARY KEY (purchase_id, product_id)
);
