import javax.swing.*;
import java.awt.*;

public class BookListRenderer extends JLabel implements ListCellRenderer<Book> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Book> list, Book book,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        String builder = "ISBN: " + book.getISBN() + "\n" +
                "Name: " + book.getName() + "\n" +
                "Author(s): " + book.getAuthor() + "\n" +
                "Genre(s): " + book.getGenres() + "\n" +
                "Publisher: " + book.getPublisher();

        setText(builder);

        return this;
    }
}
