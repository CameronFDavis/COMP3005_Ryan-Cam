public interface IAuthor {
    String getAuthorName();

    default void add(IAuthor author) { };
}