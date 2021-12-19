import javax.swing.*;
import java.sql.*;
import java.util.HashMap;

public class BookList extends DefaultListModel {

    private final HashMap<String, HashMap<String, IAuthor>> authors;
    private final HashMap<String, IGenre> genres;
    private final HashMap<Integer, Publisher> publishers;

    public BookList(Connection connection) {
        authors = new HashMap<>();
        genres = new HashMap<>();
        publishers = new HashMap<>();

        String sql = "SELECT ISBN, name, page_count, price, year, binding, percent_to_publisher, stock, publisher_id FROM books";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    long ISBN = resultSet.getLong("ISBN");
                    super.addElement(
                            new Book(
                                    ISBN,
                                    resultSet.getString("name"),
                                    resultSet.getInt("page_count"),
                                    resultSet.getBigDecimal("price"),
                                    resultSet.getBigDecimal("year"),
                                    resultSet.getString("binding"),
                                    resultSet.getBigDecimal("percent_to_publisher"),
                                    resultSet.getInt("stock"),
                                    findGenres(connection, ISBN),
                                    findAuthors(connection, ISBN),
                                    findPublisher(connection, resultSet.getInt("publisher_id"))
                            )
                    );
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private IGenre findGenres(Connection connection, long ISBN) throws SQLException {
        String sql = "SELECT ISBN, genre FROM written_by WHERE ISBN = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, ISBN);
        ResultSet resultSet = preparedStatement.executeQuery();
        IGenre bookGenres = new Genres();
        while (resultSet.next()) {
            String genre = resultSet.getString("genre");
            if (!genres.containsKey(genre)) {
                genres.put(genre, new Genre(genre));
            }
            bookGenres.add(genres.get(genre));
        }
        return bookGenres;
    }

    private IAuthor findAuthors(Connection connection, long ISBN) throws SQLException {
        String sql = "SELECT ISBN, first_name, last_name WHERE ISBN = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, ISBN);
        ResultSet resultSet = preparedStatement.executeQuery();
        IAuthor bookAuthors = new Authors();
        while (resultSet.next()) {
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");

            HashMap<String, IAuthor> secondKey = authors.get(first_name);
            if (secondKey != null) {
                if (secondKey.get(last_name) == null) {
                    secondKey.put(last_name, new Author(first_name, last_name));
                }
            } else {
                HashMap<String, IAuthor> newMap = new HashMap<>();
                newMap.put(last_name, new Author(first_name, last_name));
                authors.put(first_name, newMap);
            }
            bookAuthors.add(authors.get(first_name).get(last_name));
        }
        return bookAuthors;
    }

    private Publisher findPublisher(Connection connection, int publisher_id) throws SQLException{
        if (!publishers.containsKey(publisher_id)) {
            publishers.put(publisher_id, Publisher.createPublisher(connection, publisher_id));
        }
        return publishers.get(publisher_id);
    }
}
