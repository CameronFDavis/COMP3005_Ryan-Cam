import javax.swing.*;
import java.awt.event.*;

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
        // add your code here
        dispose();
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
