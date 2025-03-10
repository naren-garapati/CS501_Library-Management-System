// package FinalProject;

// import FinalProject.Book;
// import FinalProject.Borrowable;


public class BookTester {

    public static void main(String[] args){

        System.out.println("LibraryItem Tester....\n");

        // let's start out by testing the objects that inherit from libraryItem

        // book 
        // test the getters first 
        Book book = new Book("B001", "Test Book", 2022, "1234567890", "Fiction", "Test Author");

        if (!book.getItemId().equals("B001")) {
            System.out.println("ItemId getter failed. Expected: B001, Got: " + book.getItemId());
        }

        if (!book.getTitle().equals("Test Book")) {
            System.out.println("Title getter failed. Expected: Test Book, Got: " + book.getTitle());
        }

        if (book.getPublicationYear() != 2022) {
            System.out.println("PublicationYear getter failed. Expected: 2022, Got: " + book.getPublicationYear());
        }

        if (!book.getIsbn().equals("1234567890")) {
            System.out.println("ISBN getter failed. Expected: 1234567890, Got: " + book.getIsbn());
        }

        if (!book.getGenre().equals("Fiction")) {
            System.out.println("Genre getter failed. Expected: Fiction, Got: " + book.getGenre());
        }

        if (!book.getAuthor().equals("Test Author")) {
            System.out.println("Author getter failed. Expected: Test Author, Got: " + book.getAuthor());
        }

        if (!book.isAvailable()) {
            System.out.println("isAvailable failed. New items should be available by default.");
        }


        // testing the setters now 
        book.setIsbn("0987654321");
        if (!book.getIsbn().equals("0987654321")) {
            System.out.println("ISBN setter failed. Expected: 0987654321, Got: " + book.getIsbn());
        }

        book.setGenre("Non-Fiction");
        if (!book.getGenre().equals("Non-Fiction")) {
            System.out.println("Genre setter failed. Expected: Non-Fiction, Got: " + book.getGenre());
        }

        book.setAuthor("New Author");
        if (!book.getAuthor().equals("New Author")) {
            System.out.println("Author setter failed. Expected: New Author, Got: " + book.getAuthor());
        }

        // testing the methods 
        // checkout 
        boolean checkOutResult = book.checkOut();
        if (!checkOutResult) {
            System.out.println("checkOut failed. Should return true when item is available.");
        }


        if (book.isAvailable()) {
            System.out.println("checkOut failed. Item should be unavailable after checkout.");
        }

        checkOutResult = book.checkOut();
        if (checkOutResult) {
            System.out.println("checkOut failed. Should return false when item is already checked out.");
        }


        // test checkIn when checked out
        boolean checkInResult = book.checkIn();
        if (!checkInResult) {
            System.out.println("checkIn failed. Should return true when item is checked out.");
        }

        if (!book.isAvailable()) {
            System.out.println("checkIn failed. Item should be available after check-in.");
        }
        
        // test checkIn when already available
        checkInResult = book.checkIn();
        if (checkInResult) {
            System.out.println("checkIn failed. Should return false when item is already available.");
        }

        // testing the toString method 
        String bookString = book.toString();
        if (!bookString.contains("ID: B001") ||
            !bookString.contains("Title: Test Book") ||
            !bookString.contains("Published: 2022") ||
            !bookString.contains("ISBN: 0987654321") ||
            !bookString.contains("Genre: Non-Fiction")) {
            System.out.println("toString method failed. Expected all Book details, but got: " + bookString);
        }


        // should have gotten no error messages if all the tests passed 
        System.out.println("Book testing done! Everything works as expected if there are no error messages above\n");



    }
    
}
