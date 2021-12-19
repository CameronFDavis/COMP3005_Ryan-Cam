import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                Logout();
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
                Search();
            }
        });
    }

    private void Logout(){

    }

    private void Search(){

    }

    public static void main(String[] args) {
        JFrame frame = new BookDisplayAndCart();
        frame.setContentPane(new BookDisplayAndCart().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
