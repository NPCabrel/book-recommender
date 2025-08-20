import java.util.*;
import java.util.stream.Collectors;

public class BookRecommender {
    private final Map<String, Set<String>> coOccurrences; // Maps book titles to co-borrowed books

    public BookRecommender(List<Order> orders) {
        this.coOccurrences = new HashMap<>();
        buildCoOccurrences(orders);
    }

    private void buildCoOccurrences(List<Order> orders) {
        for (Order order : orders) {
            List<Book> books = order.getBooks();
            for (int i = 0; i < books.size(); i++) {
                String title1 = books.get(i).getTitle();
                coOccurrences.putIfAbsent(title1, new HashSet<>());
                for (int j = i + 1; j < books.size(); j++) {
                    String title2 = books.get(j).getTitle();
                    coOccurrences.get(title1).add(title2);
                    coOccurrences.putIfAbsent(title2, new HashSet<>());
                    coOccurrences.get(title2).add(title1);
                }
            }
        }
    }

    public List<Book> recommend(String bookTitle) {
        return coOccurrences.getOrDefault(bookTitle, Collections.emptySet())
                .stream()
                .map(title -> new Book(title, 0)) // Assume pages=0 for simplicity
                .collect(Collectors.toList());
    }
}