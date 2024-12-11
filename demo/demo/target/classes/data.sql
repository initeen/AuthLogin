CREATE TABLE "USERS" (id BIGINT AUTO_INCREMENT Primary key, username VARCHAR(20) NOT NULL UNIQUE, password VARCHAR(20) NOT NULL);
INSERT INTO "USERS" (username, password) values ('user1', '1234');
INSERT INTO "USERS" (username, password) values ('user2', '12345');