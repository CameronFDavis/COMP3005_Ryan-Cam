import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Publisher {
    private final String name;
    private final String email;
    private final ArrayList<Integer> phoneNumbers;
    private final long bankingAccount;
    private final Address address;

    public static Publisher createPublisher(Connection connection, int publisher_id) throws SQLException {
        String sql = "SELECT * FROM publishers LEFT JOIN addresses ON publishers.address_id = addresses.address_id WHERE publisher_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, publisher_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return new Publisher(
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getLong("banking_account"),
                new Address(
                        resultSet.getString("street"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("postal_code")
                )
        );
    }

    public Publisher(
            String name,
            String email,
            long bankingAccount,
            Address address
    ) {
        this.name = name;
        this.email = email;
        this.bankingAccount = bankingAccount;
        this.phoneNumbers = new ArrayList<>();
        this.address = address;
    }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public String getPhoneNumbers() {
        StringBuilder strPhoneNumbers = new StringBuilder();
        String separator = "";
        for (Integer phoneNumber: phoneNumbers) {
            strPhoneNumbers.append(separator).append(phoneNumber);
            separator = ", ";
        }
        return strPhoneNumbers.toString();
    }

    public String getBankingAccount() { return Long.toString(bankingAccount); }

    public String getAddress() {
        return address.street() + " " + address.city() + " " + address.province() + " " + address.postalCode();
    }
}