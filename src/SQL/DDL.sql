-- Drop tables to ensure no creation conflict
DROP TABLE IF EXISTS users CASCADE;

DROP TABLE IF EXISTS tracking CASCADE;
DROP TABLE IF EXISTS book_orders CASCADE;
DROP TABLE IF EXISTS orders CASCADE;

DROP TABLE IF EXISTS cart CASCADE;

DROP TABLE IF EXISTS cart_item CASCADE;
DROP TABLE IF EXISTS user_orders CASCADE;

DROP TABLE IF EXISTS publishers_phone_number CASCADE;
DROP TABLE IF EXISTS publishers CASCADE;

DROP TABLE IF EXISTS addresses CASCADE;

DROP TABLE IF EXISTS has_genre CASCADE;
DROP TABLE IF EXISTS genres CASCADE;

DROP TABLE IF EXISTS written_by CASCADE;
DROP TABLE IF EXISTS authors CASCADE;

DROP TABLE IF EXISTS books CASCADE;

-- Create all the tables
CREATE TABLE addresses (
	address_id INT AUTO_INCREMENT,
	street VARCHAR(255) NOT NULL,
	city VARCHAR(255) NOT NULL,
	province VARCHAR(255) NOT NULL,
	postal_code VARCHAR(255) NOT NULL,
	PRIMARY KEY (address_id)
);

CREATE TABLE publishers (
	publisher_id INT,
	name VARCHAR(255) NOT NULL UNIQUE,
	email VARCHAR(255) NOT NULL,
	banking_account BIGINT NOT NULL,
	address_id INT,
	PRIMARY KEY (publisher_id),
	FOREIGN KEY (address_id) REFERENCES addresses(address_id)
);

CREATE TABLE publishers_phone_number (
	phone_number BIGINT,
	publisher_id INT, 
	PRIMARY KEY (phone_number),
	FOREIGN KEY (publisher_id) REFERENCES publishers(publisher_id)
);

CREATE TABLE books (
	ISBN BIGINT,
	name VARCHAR(255) NOT NULL,
	page_count INT NOT NULL,
	price NUMERIC(6,2) NOT NULL,
	pub_year NUMERIC(4,0),
	binding VARCHAR(20) NOT NULL,
	percent_to_publisher NUMERIC(4,2),
	stock INT NOT NULL,
	publisher_id INT,
	PRIMARY KEY (ISBN),
	FOREIGN KEY (publisher_id) REFERENCES publishers(publisher_id)
);

CREATE TABLE genres (
	genre VARCHAR(50),
	PRIMARY KEY (genre)
);

CREATE TABLE has_genre (
	ISBN BIGINT,
	genre VARCHAR(50),
	FOREIGN KEY (ISBN) REFERENCES books(ISBN),
	FOREIGN KEY (genre) REFERENCES genres(genre),
	PRIMARY KEY (ISBN, genre)
);

CREATE TABLE authors (
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	PRIMARY KEY (first_name, last_name)
);

CREATE TABLE written_by (
	ISBN BIGINT,
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	FOREIGN KEY (ISBN) REFERENCES books(ISBN),
	FOREIGN KEY (first_name) REFERENCES authors(first_name),
	FOREIGN KEY (last_name) REFERENCES authors(last_name),
	PRIMARY KEY (ISBN, first_name, last_name)
);

CREATE TABLE users (
	username VARCHAR(60),
	password VARCHAR(20) NOT NULL,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	user_type VARCHAR(1) NOT NULL,
	shipping_address INT,
	billing_address INT,
	PRIMARY KEY (username),
	FOREIGN KEY (shipping_address) REFERENCES addresses(address_id),
	FOREIGN KEY (billing_address) REFERENCES addresses(address_id)
);

CREATE TABLE orders (
	order_id INT AUTO_INCREMENT,
	cost NUMERIC(6,2) NOT NULL,
	time_of_order TIMESTAMP,
	shipping_address INT,
	billing_address INT,
	FOREIGN KEY (shipping_address) REFERENCES addresses(address_id),
	FOREIGN KEY (billing_address) REFERENCES addresses(address_id)
);

CREATE TABLE cart (
	cart_id INT AUTO_INCREMENT,
	username VARCHAR(60),
	PRIMARY KEY (cart_id),
	FOREIGN KEY (username) REFERENCES user(username) ON DELETE CASCADE
);

CREATE TABLE tracking (
	order_id INT,
	warehouse VARCHAR(255),
	shipper VARCHAR(255),
	cur_province VARCHAR(255),
	shipping_service VARCHAR(255),
	start_province VARCHAR(255),
	PRIMARY KEY (order_id),
	FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE
);

CREATE TABLE book_orders (
	ISBN BIGINT,
	order_id INT,
	PRIMARY KEY (ISBN, order_id),
	FOREIGN KEY (ISBN) REFERENCES books(ISBN),
	FOREIGN KEY (order_id) REFERENCES orders(order_id)
);

CREATE TABLE cart_item (
	cart_id INT,
	ISBN BIGINT,
	quantity INT NOT NULL,
	PRIMARY KEY (cart_id, ISBN)
	FOREIGN KEY (cart_id) REFERENCES cart(cart_id) ON DELETE CASCADE,
	FOREIGN KEY (ISBN) REFERENCES books(ISBN) ON DELETE CASCADE
);

CREATE TABLE user_orders (
	order_id INT,
	username VARCHAR(60),
	FOREIGN KEY (order_id) REFERENCES orders(order_id),
	FOREIGN KEY (username) REFERENCES user(username),
	PRIMARY KEY (order_id, username)
);
