-- These selections are for populating the JList in the customer view --
SELECT ISBN, name, page_count, price, year, binding, percent_to_publisher, stock, publisher_id FROM books;

SELECT ISBN, genre FROM written_by WHERE ISBN = ?;

SELECT ISBN, first_name, last_name WHERE ISBN = ?;

SELECT * FROM publishers LEFT JOIN addresses ON publishers.address_id = addresses.address_id WHERE publisher_id = ?;

SELECT * FROM publishers WHERE publisher_id = ?;
-- FINISH --


SELECT LAST_INSERT_ID();

-- Used for when the user is logging in
SELECT user_type FROM user WHERE username = ? and password = ?;

-- Select all the available books--
SELECT * FROM books WHERE ISBN = ?;

-- Compile and select all information for the report -- 
SELECT time_of_order, sold, income, cost, profit FROM (
	SELECT * FROM orders
	LEFT JOIN book_orders ON book_orders.order_id = orders.order_id
	LEFT JOIN books ON book_orders.ISBN = books.ISBN
	
)

