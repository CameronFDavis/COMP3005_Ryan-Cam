import javax.swing.*;
import java.awt.event.*;

public class AddBook extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel addBookMainPanel;
    private JPanel bookDetailsPanel;
    private JPanel bookPubPanel;
    private JPanel bookAuthorPanel;
    private JPanel bookGenresPanels;
    private JTextField txtISBN;
    private JTextField txtBookName;
    private JTextField txtPages;
    private JTextField txtPrice;
    private JTextField txtYear;
    private JTextField txtBinding;
    private JTextField txtStock;
    private JTextField txtPubID;
    private JTextField txtAuthorFirstName;
    private JTextField txtAuthorLastName;
    private JTextField txtGenres;
    private JTextField txtPubCut;

    public AddBook() {
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
        AddBook dialog = new AddBook();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
