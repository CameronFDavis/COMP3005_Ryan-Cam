import javax.swing.*;
import java.awt.*;

public class SignIn extends JFrame {

    private final JPanel framePanel;
    private final JLabel labelUsername;
    private final JLabel labelPassword;
    private final JTextField textFieldUser;
    private final JPasswordField textFieldPass;
    private final JButton btnSignIn;
    private final JLabel labelError;

    public SignIn(Controller controller) {

        labelUsername = new JLabel("Username");
        textFieldUser = new JTextField();
        textFieldUser.setPreferredSize(new Dimension(200, 50));

        labelPassword = new JLabel("Password");
        textFieldPass = new JPasswordField();
        textFieldPass.setPreferredSize(new Dimension(200, 50));

        btnSignIn = new JButton("Sign In");

        labelError = new JLabel("");

        framePanel = new JPanel();
        framePanel.setLayout(new BoxLayout(framePanel, BoxLayout.Y_AXIS));

        this.add(framePanel);
        this.pack();
        this.setPreferredSize(new Dimension(300, 200));
        this.setLocation(null);
        this.setVisible(true);
    }

    public void setError(String error) {
        labelError.setText(error);
    }
}
