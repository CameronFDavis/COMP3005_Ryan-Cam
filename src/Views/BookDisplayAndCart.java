import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookDisplayAndCart extends JFrame {
    private JPanel panelControls;
    private JButton btnLogout;
    private JButton btnSignIn;
    private JButton btnRegister;
    private JPanel mainPanel;
    private JComboBox comboBoxSearchBy;
    private JButton searchButton;
    private JTextField searchTextField;
    private JTable table1;
    private JList bookList;

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
    }

    public static void main(String[] args) {
        JFrame frame = new BookDisplayAndCart();
        frame.setContentPane(new BookDisplayAndCart().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
