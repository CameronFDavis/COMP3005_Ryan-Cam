import javax.swing.*;
import java.awt.event.*;

public class AdminView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton addPublisherButton;
    private JButton addBookButton;
    private JButton removePublisherButton;
    private JButton removeBookButton;
    private JButton reportsButton;

    public AdminView() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onOK();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog addBook = new AddBook();
                addBook.pack();
                addBook.setVisible(true);
            }
        });

        addPublisherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog addPublisher = new AddPublisher();
                addPublisher.pack();
                addPublisher.setVisible(true);

            }
        });
        removeBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog removeBook = new RemoveBook();
                removeBook.pack();
                removeBook.setVisible(true);
            }
        });
        removePublisherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog removePublisher = new RemovePublisher();
                removePublisher.pack();
                removePublisher.setVisible(true);
            }
        });
        reportsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog reportsButton = new Reports();
                reportsButton.pack();
                reportsButton.setVisible(true);
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public static void main(String[] args) {
        AdminView dialog = new AdminView();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
