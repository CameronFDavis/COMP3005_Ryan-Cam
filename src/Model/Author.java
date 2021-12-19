public record Author(String firstName, String lastName) implements IAuthor {

    public String getAuthorName() {
        return firstName + " " + lastName;
    }
}