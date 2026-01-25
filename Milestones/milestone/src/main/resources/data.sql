-- Users
INSERT INTO "users" ("id", "USERNAME", "PASSWORD", "NAME") VALUES
    (1, 'J.Smith',  'pass123',  'John Smith'),
    (2, 'janeDoe',  'password', 'Jane Doe'),
    (3, 'roknRoll', 'password', 'Mark Carol');

-- Movies
INSERT INTO "movie" ("id", "GENRE", "PRICE", "STATUS", "TITLE", "current_user_id") VALUES
    (1, 'Science Fiction', 6.00, 'Checked Out', 'Star Wars: A New Hope', 1),
    (2, 'Science Fiction', 6.99, 'Available',   'Star Wars: The Empire Strikes Back', NULL),
    (3, 'Science Fiction', 4.99, 'Available',   'Star Wars: Return of the Jedi',      NULL),
    (4, 'Comedy',          4.99, 'Checked Out', 'Groundhog Day',                      2),
    (5, 'Comedy',          6.99, 'Available',   'Princess Bride',                     NULL),
    (6, 'Action',          6.99, 'Available',   'Die Hard',                           NULL),
    (7, 'Horror',          5.00, 'Checked Out', 'Alien',                              3);

-- Checkout
INSERT INTO "checkout" ("id", "MOVIE_ID", "USER_ID") VALUES
    (1, 1, 1),
    (2, 4, 2),
    (3, 7, 3);
