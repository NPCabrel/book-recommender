import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args){
        //1.  create a some sample Books
        Book mlBook = new Book("Machine Learning Basics", 450);
        Book javaBook = new Book("Effective java", 416);
        Book pythonBook = new Book("Python Crash Course", 578);
        Book algoDatBook = new Book("Data Structures and Algorithms", 479);

        //2. create sample Orders (which are lists of books + a reader)
        List<Book> order1Books = Arrays.asList(mlBook, javaBook);
        List<Book> order2Books = Arrays.asList(mlBook, pythonBook);
        List<Book> order3Books = Arrays.asList(javaBook, algoDatBook);


        Order order1 = new Order(order1Books, "Pascal");
        Order order2 = new Order(order2Books, "Cabrel");
        Order order3 = new Order(order3Books, "Bob");

        //3. create a list of all orders 
        List<Order> allOrders = Arrays.asList(order1, order2, order3);

        //4. create and train the bookRecommender
        BookRecommender recommender = new BookRecommender(allOrders);

        //5. get a recommendation
        String inputBook = "Machine Learning Basics";
        List<Book> recommendations = recommender.recommend(inputBook);

        //6. result printing
        System.out.println("Books frequently borrowed with '" + inputBook + "':" );
        for(Book b : recommendations){
            System.out.println(" - " + b.getTitle());
        }


    }
}