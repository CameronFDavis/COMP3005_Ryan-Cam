import javax.swing.*;

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
    private JButton btnCheckout;
    private JButton btnOrders;
    private JButton btnAdmin;

    public static void main(String[] args) {
        JFrame frame = new BookDisplayAndCart();
        frame.setContentPane(new BookDisplayAndCart().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
