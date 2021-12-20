import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BookDisplayAndCart extends JFrame {
    private JPanel panelControls;
    private JButton btnLogout;
    private JButton btnSignIn;
    private JButton btnRegister;
    private JPanel mainPanel;
    private JComboBox comboBoxSearchBy;
    private JButton btnSearch;
    private JTextField searchTextField;
    private JTable table1;
    private JList bookList;
    private JButton btnCheckout;
    private JButton btnOrders;
    private JButton btnAdmin;
    private JLabel SignInStatus;

    public BookDisplayAndCart() {
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog reg = new Register();
                reg.pack();
                reg.setVisible(true);
            }
        });

        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog log = new Login();
                log.pack();
                log.setVisible(true);
                log.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        System.out.println(((Login) log).getLoggedIn());
                        SignInStatus.setText("Signed In");
                        btnSignIn.setVisible(false);
                        btnLogout.setVisible(true);
                        btnRegister.setVisible(false);
                        if (((Login) log).getUserType() == "E") {
                            btnAdmin.setVisible(true);
                        }
                    }
                });
            }
        });

        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog admin = new AdminView();
                admin.pack();
                admin.setVisible(true);

            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //LoggedIn = false;
                SignInStatus.setText("Not Signed In");
                btnRegister.setVisible(true);
                btnSignIn.setVisible(true);
                btnLogout.setVisible(false);
                btnAdmin.setVisible(false);

            }
        });

        btnCheckout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog checkout = new Checkout();
                checkout.pack();
                checkout.setVisible(true);
            }
        });

        btnOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog tracking = new Tracking();
                tracking.pack();
                tracking.setVisible(true);
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search(comboBoxSearchBy.getSelectedItem().toString(),searchTextField.getText());
            }
        });
    }

    private void Search(String getType,String searchText){

    }

    public static void main(String[] args) {
        JFrame frame = new BookDisplayAndCart();
        frame.setContentPane(new BookDisplayAndCart().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
