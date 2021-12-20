-- All inserts here are used when the program begins to load from the .json --
INSERT IGNORE INTO books (ISBN, name, page_count, price, year, binding, percent_to_pub, stock, publisher_id) VALUES (?, ?, ?, 10, ?, 'Paperback' , 3.5, 10, LAST_INSERT_ID());

INSERT IGNORE INTO genres (genre) VALUES (?);

INSERT IGNORE INTO publishers (name, email, banking_account, address_id) VALUES (?, 'publisher@email.com', 10001, 1);

INSERT IGNORE INTO authors (first_name, last_name) VALUES (?, ?);

INSERT IGNORE INTO has_genre (ISBN, genre) VALUES (?, ?);

INSERT IGNORE INTO written_by (first_name, last_name, ISBN) VALUES (?, ?, ?);
--- FINISH ---


-- These inserts are used for when the prompts appear in admin view (add book, add publisher ,etc)--
INSERT IGNORE INTO addresses (street, city, province, postal_code) VALUES ('248 Bell St. North', 'Ottawa', 'ON', 'K1R 7E6');

INSERT IGNORE INTO addresses (street, city, province,postal_code) VALUES (?, ?, ?, ?);

SELECT LAST_INSERT_ID(); -- Used to get the last auto_incremented id, to add to foreign keys

INSERT IGNORE INTO publishers (name, email, banking_account, address_id) VALUES (?, ?, ?, ?);

INSERT IGNORE INTO publishers_phone_number (phone_number, publisher_id) VALUES (?, ?);

