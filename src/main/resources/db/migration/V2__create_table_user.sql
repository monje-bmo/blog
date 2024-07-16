CREATE TABLE "userdb"
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255),
    name     VARCHAR(255),
    lastName VARCHAR(255),
    role     smallint,
    CONSTRAINT username_unique UNIQUE (username)
);
