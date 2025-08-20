import java.util.List;

public class Order {
    private List<Book> books;
    private String reader;

    // Constructor to create new empty elements
    public Order(List<Book> books, String reader) {
        this.reader = reader;
        this.books = books;
    }

    // getter for accessing to elements
    public List<Book> getBooks() {
        return books;
    }

    public String getReader() {
        return reader;
    }
}