package src.exercise1;

class Book {
    private final String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public class Author {
        private final String name;

        public Author(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}

class Executor {
    public static Book createBook(String title) {
        return new Book(title);
    }

    public static Book.Author createAuthor(Book book, String name) {
        return book.new Author(name);
    }
}
