CREATE TABLE addresses (
	address_id INT,
	street VARCHAR(255) NOT NULL,
	city VARCHAR(255) NOT NULL,
	province VARCHAR(255) NOT NULL,
	postal_code VARCHAR(255) NOT NULL,
	PRIMARY KEY (address_id)
);

CREATE TABLE publishers (
	publisher_id INT,
	name VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	banking_account BIGINT NOT NULL,
	PRIMARY KEY (publisher_id),
	FOREIGN KEY (address_id) REFERENCES addresses(address_id)
);

CREATE TABLE books (
	ISBN BIGINT,
	name VARCHAR(255),
	page_count INT,
	price NUMERIC(6,2)
	year NUMERIC(4,0),
	binding VARCHAR(20),
	percent_to_publisher NUMERIC(4,2),
	publisher_id INT,
	PRIMARY KEY (ISBN),
	FOREIGN KEY (publisher_id) REFERENCES publishers(publisher_id)
);

CREATE TABLE genres (
	genre VARCHAR(50),
	PRIMARY KEY (genre)
);

CREATE TABLE has_genre (
	ISBN BIGINT REFERENCES books(ISBN),
	genre VARCHAR(50) REFERENCES genres(genre),
	PRIMARY KEY (ISBN, genre)
);

CREATE TABLE authors (
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	PRIMARY KEY (first_name, last_name)
);

CREATE TABLE written_by (
	ISBN BIGINT REFERENCES books(ISBN),
	first_name VARCHAR(255) REFERENCES authors(first_name),
	last_name VARCHAR(255) REFERENCES authors(last_name)
);

INSERT INTO 