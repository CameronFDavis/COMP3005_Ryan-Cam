import java.sql.Connection;

public class Controller  {

    public static boolean signedIn = false;
    private static Connection connection;

    public static void main(String[] args) {
        DatabaseConnection.populateDatabase(DatabaseConnection.openConnection());
        DatabaseConnection.closeConnection();
    }
}
