import javax.swing.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RemovePublisher extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtPubID;

    public RemovePublisher() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK(txtPubID.getText());
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

    private void onOK(String pubID) throws SQLException {
        // add your code here
        String sql1 = "SELECT * FROM publishers WHERE publisher_id = '?'";
        String sql2 = "DELETE FROM publishers WHERE publisher_id = '?'";

        try (PreparedStatement CheckForExistingEntry = con.prepareStatement(sql1);
             PreparedStatement DeleteEntry = con.prepareStatement(sql2)) {

            CheckForExistingEntry.setString(1, pubID);
            ResultSet resultSet = CheckForExisitingEntry.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(contentPane, "This book doesn't exist in the database please try another ISBN");
            } else {
                DeleteEntry.setString(1, pubID);
                DeleteEntry.executeQuery();
                dispose();
            }
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        RemovePublisher dialog = new RemovePublisher();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
