public class Genre implements IGenre {
    private final String genre;

    public Genre(String genre) { this.genre = genre; }

    @Override
    public String getGenre() { return genre; }
}