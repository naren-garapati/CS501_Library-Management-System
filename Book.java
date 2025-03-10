// package FinalProject;

// import FinalProject.Borrowable;
// import FinalProject.LibraryItem;


public class Book extends LibraryItem implements Borrowable{

    // attributes specific to books
    private String isbn;
    private String genre;
    private String author; 

    // constructor 
    public Book(String itemId, String title, int publicationYear, String isbn, String genre, String author) {
        super(itemId, title, publicationYear);
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
    }

    // getters 
    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    // setters 
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // methods 
    // implement interface methods 
    @Override
    public boolean checkIn() {
        if (!isAvailable()) {
            setAvailable(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkOut() {
        if (isAvailable()) {
            setAvailable(false);
            return true;
        }
        return false;
    }

    // display method 
    @Override
    public void display() {
        System.out.println("------- BOOK DETAILS ----------");
        System.out.println(super.toString());
        System.out.println("ISBN: " + isbn);
        System.out.println("Genre: " + genre);
        System.out.println("--------------------------------");
    }

    // to string method
    @Override
    public String toString() {
        return super.toString() + ", ISBN: " + isbn + ", Genre: " + genre;
    }




}
