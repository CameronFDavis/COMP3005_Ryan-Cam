import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String url = "jdbc:h2:./project";
    private Connection connection;

    public DatabaseConnection () {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() { return connection; }
}
