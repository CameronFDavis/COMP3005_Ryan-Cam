import java.math.BigDecimal;

public record Book(long ISBN, String name, int pageCount, BigDecimal price,
                   BigDecimal year, String binding, BigDecimal percentToPublisher,
                   int stock, IGenre genre, IAuthor author, Publisher publisher) {

    public long getISBN() {
        return ISBN;
    }

    public String getName() {
        return name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getYear() {
        return year;
    }

    public String getBinding() {
        return binding;
    }

    public BigDecimal getPercentToPublisher() {
        return percentToPublisher;
    }

    public String getGenres() {
        return genre.getGenre();
    }

    public String getAuthor() {
        return author.getAuthorName();
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public String getStock() {
        return Integer.toString(stock);
    }
}