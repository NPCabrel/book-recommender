public class Book{
    private final String title;
    private final long pages;

     //Constructor to create new empty elements
    public  Book(String title, long pages){
        this.pages = pages;
        this.title = title;
    }


    //getter for accessing to elements
    public String getTitle(){
        return title;
    }

    public long getPages(){
        return pages;
    }

}