import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions.*;

public class BookRecommenderTest {

    @Test
    public void testRecommendations_BasicCoOccurrence() {
        // 1. Setup - Create sample data
        Book mlBook = new Book("Machine Learning Basics", 450);
        Book javaBook = new Book("Effective Java", 416);
        Book pythonBook = new Book("Python Crash Course", 578);

        List<Book> order1Books = Arrays.asList(mlBook, javaBook);
        List<Book> order2Books = Arrays.asList(mlBook, pythonBook);

        Order order1 = new Order(order1Books, "Alice");
        Order order2 = new Order(order2Books, "Bob");

        List<Order> allOrders = Arrays.asList(order1, order2);

        // 2. Execute - Create recommender and get recommendations
        BookRecommender recommender = new BookRecommender(allOrders);
        List<Book> recommendations = recommender.recommend("Machine Learning Basics");

        // 3. Verify - Check the results
        assertEquals(2, recommendations.size(), "Should recommend 2 books");
        assertTrue(recommendations.stream().anyMatch(b -> b.getTitle().equals("Effective Java")), "Should recommend Java book");
        assertTrue(recommendations.stream().anyMatch(b -> b.getTitle().equals("Python Crash Course")), "Should recommend Python book");
    }

    @Test
    public void testRecommendations_NoCoOccurrence() {
        // Test for a book that was never borrowed with others
        Book mlBook = new Book("Machine Learning Basics", 300);
        Book historyBook = new Book("History of Rome", 500); // Standalone book

        List<Book> order1Books = Arrays.asList(mlBook);
        List<Book> order2Books = Arrays.asList(historyBook); // This order only has one book

        Order order1 = new Order(order1Books, "Alice");
        Order order2 = new Order(order2Books, "Bob");

        List<Order> allOrders = Arrays.asList(order1, order2);

        BookRecommender recommender = new BookRecommender(allOrders);
        List<Book> recommendations = recommender.recommend("History of Rome");

        assertTrue(recommendations.isEmpty(), "Should have no recommendations for a book that was never borrowed with another");
    }

    @Test
    public void testRecommendations_BookNotInSystem() {
        // Test for a book that doesn't exist in any order
        Book mlBook = new Book("Machine Learning Basics", 300);
        List<Book> order1Books = Arrays.asList(mlBook);
        Order order1 = new Order(order1Books, "Alice");
        List<Order> allOrders = Arrays.asList(order1);

        BookRecommender recommender = new BookRecommender(allOrders);
        List<Book> recommendations = recommender.recommend("A Book That Doesn't Exist");

        assertTrue(recommendations.isEmpty(), "Should have no recommendations for an unknown book");
    }
}