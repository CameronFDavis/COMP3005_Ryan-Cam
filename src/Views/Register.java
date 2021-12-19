import javax.swing.*;
import java.awt.event.*;

public class Register extends JDialog {
    private JPanel contentPane;
    private JButton buttonRegister;
    private JButton buttonCancel;
    private JPanel billingPanel;
    private JPanel shippingPanel;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtCityShip;
    private JComboBox cbProvinceShip;
    private JTextField txtPostalShip;
    private JTextField txtStreetShip;
    private JTextField txtStreetBill;
    private JTextField txtPostalBill;
    private JTextField txtCityBill;
    private JComboBox cbProvinceBill;
    private JCheckBox chkBilling;
    private JPanel mainPanel;

    public Register() {
        this.setTitle("Registration");
        this.setResizable(false);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonRegister);

        buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRegister();
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
        chkBilling.addActionListener(e -> {
            billingPanel.setVisible(!chkBilling.isSelected());
            this.pack();
        });
    }

    private void onRegister() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Register dialog = new Register();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
