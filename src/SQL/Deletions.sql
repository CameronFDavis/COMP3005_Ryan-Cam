-- Deletes used in admin view for the remove book, and remove publisher dialogs --
DELETE FROM publishers WHERE publisher_id = ?;

DELETE FROM books WHERE ISBN = ?;

DELETE FROM publishers WHERE publisher_id = ?;