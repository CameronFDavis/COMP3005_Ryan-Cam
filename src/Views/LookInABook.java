import javax.swing.*;

public class LookInABook extends JFrame {

    private Register register;
    //private SignIn signIn;

    private JPanel framePanel;

    private JPanel userActions;
    private JLabel signInStatus;
    private JButton btnRegister;
    private JButton btnSignin;
    private JButton btnLogout;

    private JPanel table;

    public LookInABook (Controller controller){

        //signIn = new SignIn(this, controller);

        userActions = new JPanel();
        signInStatus = new JLabel("Not Signed In");
        btnRegister = new JButton("Register");
        //btnRegister.addActionListener(e -> new Register(controller));
        btnSignin = new JButton("Sign In");
        //btnSignin.addActionListener(e -> new SignIn(this, controller));
        btnLogout = new JButton("Logout");
        btnLogout.addActionListener(e -> {
            signInStatus.setText("Not Signed In");
            btnRegister.setVisible(true);
            btnSignin.setVisible(true);
            btnLogout.setVisible(false);
        });
        btnLogout.setVisible(false);

        framePanel.add(table);
        framePanel.add(userActions);
        this.add(framePanel);
    }

    public void userSignedIn () {
        signInStatus.setText("Signed In");
        btnRegister.setVisible(false);
        btnSignin.setVisible(false);
        btnLogout.setVisible(true);
    }

    public void userLoggedOut () {

    }
}
