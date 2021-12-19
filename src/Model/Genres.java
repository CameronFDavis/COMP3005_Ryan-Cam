import java.util.ArrayList;

public class Genres implements IGenre {
    private final ArrayList<IGenre> genres;

    public Genres() { genres = new ArrayList<>(); }

    @Override
    public String getGenre() {
        StringBuilder strGenres = new StringBuilder();
        String separator = "";
        for (IGenre genre: genres) {
            strGenres.append(separator).append(genre.getGenre());
            separator = ", ";
        }
        return strGenres.toString();
    }

    @Override
    public void add(IGenre genre) { genres.add(genre); }
}