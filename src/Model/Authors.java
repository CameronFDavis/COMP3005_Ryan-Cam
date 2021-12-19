import java.util.ArrayList;

public class Authors implements IAuthor {
    private ArrayList<IAuthor> authors;

    public Authors () { authors = new ArrayList<>(); }

    @Override
    public void add(IAuthor author) { authors.add(author); }

    @Override
    public String getAuthorName() {
        StringBuilder strAuthors = new StringBuilder();
        String separator = "";
        for (IAuthor author : authors) {
            strAuthors.append(separator).append(author.getAuthorName());
            separator = ", ";
        }
        return strAuthors.toString();
    }
}