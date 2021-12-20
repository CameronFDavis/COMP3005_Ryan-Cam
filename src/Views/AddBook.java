import javax.swing.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddBook extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel addBookMainPanel;
    private JPanel bookDetailsPanel;
    private JPanel bookPubPanel;
    private JPanel bookAuthorPanel;
    private JPanel bookGenresPanels;
    private JTextField txtISBN;
    private JTextField txtBookName;
    private JTextField txtPages;
    private JTextField txtPrice;
    private JTextField txtYear;
    private JTextField txtBinding;
    private JTextField txtStock;
    private JTextField txtPubID;
    private JTextField txtAuthorFirstName;
    private JTextField txtAuthorLastName;
    private JTextField txtGenres;
    private JTextField txtPubCut;

    public AddBook() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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

    private void onOK() {
    //    // add your code here
    //    String InsertToBookSQL = "INSERT IGNORE INTO books (ISBN, name, page_count,price,year,binding,percent_to_pub,stock,publisher_id) VALUES (?, ?, ?, ?,?,?,?,?,?)";
    //    String InsertToAuthors = "INSERT IGNORE INTO authors (first_name, last_name) VALUES (?, ?)";
    //    String InsertToWrittenBy = "INSERT IGNORE INTO written_by (first_name, last_name,ISBN) VALUES (?, ?,?)";
    //    String InsertToGenres = "INSERT IGNORE INTO genres (genre) VALUES (?)";
    //    String InsertToHasGenre = "INSERT IGNORE INTO has_genre (ISBN, genre) VALUES (?, ?)";
    //    String InsertToPublishersSQL = "INSERT IGNORE INTO publishers (name, email, banking_account, address_id) VALUES (?, ?, ?, ?)";
    //    String InsertToPublisherPhoneNumberSQL = "INSERT IGNORE INTO publishers_phone_number (phone_number, publisher_id) VALUES (?, ?)";
    //    try (PreparedStatement InsertToAddresses = con.prepareStatement(InsertToAddressesSQL);
    //         PreparedStatement GetLastInsert = con.prepareStatement(GetLastInsertSQL);
    //         PreparedStatement InsertToPublishers = con.prepareStatement(InsertToPublishersSQL);
    //         PreparedStatement InsertToPublisherPhoneNumber = con.prepareStatement(InsertToPublisherPhoneNumberSQL)) {
    //        InsertToAddresses.setString(1, txtStreet.getText());
    //        InsertToAddresses.setString(2, txtCity.getText());
    //        InsertToAddresses.setString(3, txtProvince.getText());
    //        InsertToAddresses.setString(4, txtPostalCode.getText());
//
    //        InsertToAddresses.executeQuery();
    //        ResultSet resultSet = GetLastInsert.executeQuery();
//
    //        InsertToPublishers.setString(1, txtName.getText());
    //        InsertToPublishers.setString(2, txtEmail.getText());
    //        InsertToPublishers.setString(3, txtBanking.getText());
    //        InsertToPublishers.setString(4, resultSet.getLong("address_id"));
    //        InsertToPublishers.executeQuery();
//
    //        resultSet = GetLastInsert.executeQuery();
//
    //        InsertToPublisherPhoneNumber.setString(1, txtPhone.getText());
    //        InsertToPublisherPhoneNumber.setString(2, resultSet.getLong("publisher_id"));
    //        InsertToPublisherPhoneNumber.executeQuery();
//
    //        dispose();
    //    }
    //    dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AddBook dialog = new AddBook();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
