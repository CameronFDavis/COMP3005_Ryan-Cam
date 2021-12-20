import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DatabaseConnection {

    private static final String url = "jdbc:h2:./project;INIT=RUNSCRIPT FROM './src/sql/ddl.sql'";
    private static Connection connection;

    public static void populateDatabase(Connection connection) {
        try {
            Object obj = new JSONParser().parse(new FileReader("./src/sql/bookdata.json"));

            String sqlBooks = "INSERT IGNORE INTO books (ISBN, name, page_count, price, year, binding, percent_to_pub, stock, publisher_id) " +
                    "VALUES (?, ?, ?, 10, ?, 'Paperback' , 3.5, 10, LAST_INSERT_ID())";
            String sqlGenres = "INSERT IGNORE INTO genres (genre) VALUES (?)";
            String sqlPublishers = "INSERT IGNORE INTO publishers (name, email, banking_account, address_id) VALUES " +
                    "(?, 'publisher@email.com', 10001, 1)";
            String sqlAuthors = "INSERT IGNORE INTO authors (first_name, last_name) VALUES (?, ?)";
            String sqlHasGenre = "INSERT IGNORE INTO has_genre (ISBN, genre) VALUES (?, ?)";
            String sqlWrittenBy = "INSERT IGNORE INTO written_by (first_name, last_name, ISBN) VALUES (?, ?, ?)";

            String sqlAddresses = "INSERT IGNORE INTO addresses (street, city, province, postal_code) " +
                    " VALUES ('248 Bell St. North', 'Ottawa', 'ON', 'K1R 7E6')";

            PreparedStatement psAddress = connection.prepareStatement(sqlAddresses);
            psAddress.executeQuery();

            PreparedStatement psBooks = connection.prepareStatement(sqlBooks);
            PreparedStatement psGenres = connection.prepareStatement(sqlGenres);
            PreparedStatement psPublishers = connection.prepareStatement(sqlPublishers);
            PreparedStatement psAuthors = connection.prepareStatement(sqlAuthors);
            PreparedStatement psHasGenre = connection.prepareStatement(sqlHasGenre);
            PreparedStatement psWrittenBy = connection.prepareStatement(sqlWrittenBy);

            ((JSONArray) obj).forEach(jsonArrayObject -> {
                if (jsonArrayObject instanceof JSONObject) {
                    JSONObject object = (JSONObject) jsonArrayObject;
                    try {
                        psBooks.setLong(1, Long.parseLong((String)object.get("isbn10")));
                        psBooks.setString(2, (String)object.get("title"));
                        psBooks.setInt(3, (int)object.get("page_count"));
                        psBooks.setBigDecimal(4, new BigDecimal((String)object.get("year")));

                        JSONArray genres = (JSONArray) object.get("subjects");
                        genres.forEach(jsonObject -> {
                            String genre = (String) jsonObject;
                            String[] genreArr = genre.split("-- ");
                            genre = genreArr[genreArr.length - 1];
                            try {
                                psGenres.setString(1, genre);
                                psHasGenre.setLong(1, Long.parseLong((String)object.get("isbn10")));
                                psHasGenre.setString(2, genre);

                                psGenres.addBatch();
                                psHasGenre.addBatch();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        });

                        String publisher =  ((String)((JSONArray)object.get("publishers")).get(0));
                        psPublishers.setString(1, publisher);
                        psPublishers.execute();

                        psBooks.execute();

                        JSONArray authors = (JSONArray) object.get("authors");
                        authors.forEach(jsonObject -> {
                            String author = (String) jsonObject;
                            String[] author_first_last = author.split(" ");
                            try {
                                psAuthors.setString(1, author_first_last[0]);
                                psAuthors.setString(2, author_first_last[1]);

                                psWrittenBy.setString(1, author_first_last[0]);
                                psWrittenBy.setString(1, author_first_last[0]);
                                psWrittenBy.setLong(1, Long.parseLong((String)object.get("isbn10")));

                                psAuthors.addBatch();
                                psWrittenBy.addBatch();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        });

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });

            psGenres.executeBatch();
            psAuthors.executeBatch();
            psHasGenre.executeBatch();
            psWrittenBy.executeBatch();

        } catch (IOException | ParseException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection openConnection() {
        try {
            Class.forName("org.h2.Driver");
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            connection = DriverManager.getConnection(url);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
