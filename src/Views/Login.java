import javax.swing.*;
import java.awt.event.*;

public class Login extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private Boolean LoggedIn = false;
    private String userType;


    public Login() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(txtUsername.getText(),txtPassword.getPassword());
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

    private void onOK(String username,char[] password) {
        // add your code here
        String sql = "SELECT 'user_type' FROM user WHERE username = ? and password = ?";
        if (!sql.isEmpty()){
            userType = "C";
        }
        LoggedIn = true;
        if (LoggedIn){
            dispose();
        } else if (!LoggedIn){
            JOptionPane.showMessageDialog(contentPane, "Login Failed. Please retry.");
        }

    }

    public Boolean getLoggedIn(){return LoggedIn;}
    public String getUserType(){return userType;}

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        Login dialog = new Login();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
