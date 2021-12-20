import javax.swing.*;
import java.awt.event.*;

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
                onOK(txtPubID.getText());
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

    private void onOK(String pubID) {
        // add your code here
        String sql1 = "SELECT * FROM publishers WHERE publisher_id = '" + pubID + "'";
        if (sql1.isEmpty()){
            JOptionPane.showMessageDialog(contentPane, "This publisher doesn't exist in the database please try another ID");
        } else {
            String sql2 = "DELETE FROM publishers WHERE publisher_id = '" + pubID + "'";
            dispose();
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
