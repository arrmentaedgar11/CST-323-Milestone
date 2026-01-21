-- Drop tables if they already exist
DROP TABLE IF EXISTS "checkout";
DROP TABLE IF EXISTS "movie";
DROP TABLE IF EXISTS "users";

-- Users table
CREATE TABLE "users" (
    "id" INT PRIMARY KEY,
    "USERNAME" VARCHAR(45) NOT NULL,
    "PASSWORD" VARCHAR(100) NOT NULL,
    "NAME" VARCHAR(45) NOT NULL
);

-- Movie table
CREATE TABLE "movie" (
    "id" BIGINT PRIMARY KEY,
    "GENRE" VARCHAR(255) NOT NULL,
    "PRICE" DECIMAL(10,2) NOT NULL,
    "IMAGE" VARCHAR(255),
    "STATUS" VARCHAR(50) NOT NULL,
    "TITLE" VARCHAR(255) NOT NULL,
    "current_user_id" BIGINT
);

-- Checkout table
CREATE TABLE "checkout" (
    "id" INT PRIMARY KEY,
    "MOVIE_ID" BIGINT NOT NULL,
    "USER_ID" INT NOT NULL,
    CONSTRAINT fk_checkout_movie
        FOREIGN KEY ("MOVIE_ID") REFERENCES "movie"("id"),
    CONSTRAINT fk_checkout_user
        FOREIGN KEY ("USER_ID") REFERENCES "users"("id")
);
