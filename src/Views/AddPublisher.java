import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddPublisher extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel mainPanel;
    private JPanel detailsPanel;
    private JPanel addressPanel;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtBanking;
    private JTextField txtStreet;
    private JTextField txtCity;
    private JTextField txtProvince;
    private JTextField txtPostalCode;
    private JTextField txtPhone;

    public AddPublisher() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws SQLException {
        // add your code here

        Connection con = DatabaseConnection.openConnection();
        String InsertToAddressesSQL = "INSERT IGNORE INTO addresses (street, city, province,postal_code) VALUES (?, ?, ?, ?)";
        String GetLastInsertSQL = "SELECT LAST_INSERT_ID()";
        String InsertToPublishersSQL = "INSERT IGNORE INTO publishers (name, email, banking_account, address_id) VALUES (?, ?, ?, ?)";
        String InsertToPublisherPhoneNumberSQL = "INSERT IGNORE INTO publishers_phone_number (phone_number, publisher_id) VALUES (?, ?)";
        try (PreparedStatement InsertToAddresses = con.prepareStatement(InsertToAddressesSQL);
             PreparedStatement GetLastInsert = con.prepareStatement(GetLastInsertSQL);
             PreparedStatement InsertToPublishers = con.prepareStatement(InsertToPublishersSQL);
             PreparedStatement InsertToPublisherPhoneNumber = con.prepareStatement(InsertToPublisherPhoneNumberSQL)) {
            InsertToAddresses.setString(1, txtStreet.getText());
            InsertToAddresses.setString(2, txtCity.getText());
            InsertToAddresses.setString(3, txtProvince.getText());
            InsertToAddresses.setString(4, txtPostalCode.getText());

            InsertToAddresses.executeQuery();
            ResultSet resultSet = GetLastInsert.executeQuery();

            InsertToPublishers.setString(1, txtName.getText());
            InsertToPublishers.setString(2, txtEmail.getText());
            InsertToPublishers.setString(3, txtBanking.getText());
            InsertToPublishers.setString(4, resultSet.getString("address_id"));
            InsertToPublishers.executeQuery();

            resultSet = GetLastInsert.executeQuery();

            InsertToPublisherPhoneNumber.setString(1, txtPhone.getText());
            InsertToPublisherPhoneNumber.setString(2, resultSet.getString("publisher_id"));
            InsertToPublisherPhoneNumber.executeQuery();

            dispose();
        }
        DatabaseConnection.closeConnection();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AddPublisher dialog = new AddPublisher();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
