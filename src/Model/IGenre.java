public interface IGenre {
    String getGenre();

    default void add(IGenre genre) { };
}