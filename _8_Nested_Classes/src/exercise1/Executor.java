package exercise1;

class Executor {
    public static Book createBook(String title) {
        return new Book(title);
    }

    public static Book.Author createAuthor(Book book, String name) {
        return book.new Author(name);
    }
}
