// package FinalProject;

// import FinalProject.DVD;
// import FinalProject.Borrowable;

public class DVDTester {

    public static void main(String[] args){

        System.out.println("Testing DVD class...");

        // constructor and getter tests
        DVD dvd = new DVD("D001", "Test", 2020, "Director", "Comedy");

        if (!dvd.getItemId().equals("D001")) {
            System.out.println("ItemId getter failed. Expected: D001, Got: " + dvd.getItemId());
        }

        if (!dvd.getTitle().equals("Test")) {
            System.out.println("Title getter failed. Expected: Test, Got: " + dvd.getTitle());
        }

        if (dvd.getPublicationYear() != 2020) {
            System.out.println("PublicationYear getter failed. Expected: 2020, Got: " + dvd.getPublicationYear());
        }
        
        if (!dvd.getDirector().equals("Director")) {
            System.out.println("Director getter failed. Expected: Director, Got: " + dvd.getDirector());
        }

        if (!dvd.getGenre().equals("Comedy")) {
            System.out.println("Genre getter failed. Expected: Comedy, Got: " + dvd.getGenre());
        }

        if (!dvd.isAvailable()) {
            System.out.println("isAvailable failed. New items should be available by default.");
        }

        // testing the setters now 
        dvd.setDirector("New Director");
        if (!dvd.getDirector().equals("New Director")) {
            System.out.println("Director setter failed. Expected: New Director, Got: " + dvd.getDirector());
        }

        dvd.setGenre("Action");
        if (!dvd.getGenre().equals("Action")) {
            System.out.println("Genre setter failed. Expected: Action, Got: " + dvd.getGenre());
        }

        // Test checkOut when available
        boolean checkOutResult = dvd.checkOut();
        if (!checkOutResult) {
            System.out.println("checkOut failed. Should return true when item is available.");
        }
        
        if (dvd.isAvailable()) {
            System.out.println("checkOut failed. Item should be unavailable after checkout.");
        }

        // Test checkOut when already checked out
        checkOutResult = dvd.checkOut();
        if (checkOutResult) {
            System.out.println("checkOut failed. Should return false when item is already checked out.");
        }

        // Test checkIn when checked out
        boolean checkInResult = dvd.checkIn();
        if (!checkInResult) {
            System.out.println("checkIn failed. Should return true when item is checked out.");
        }
        
        if (!dvd.isAvailable()) {
            System.out.println("checkIn failed. Item should be available after check-in.");
        }

        // Test checkIn when already available
        checkInResult = dvd.checkIn();
        if (checkInResult) {
            System.out.println("checkIn failed. Should return false when item is already available.");
        }

        // Test toString
        String dvdString = dvd.toString();
        if (!dvdString.contains("ID: D001") ||
            !dvdString.contains("Title: Test") ||
            !dvdString.contains("Published: 2020") ||
            !dvdString.contains("Director: New Director") ||
            !dvdString.contains("Genre: Action")) {
            System.out.println("toString method failed. Expected all DVD details, but got: " + dvdString);
        }
        
        // Test display (can only verify it doesn't throw exceptions)
        try {
            dvd.display();
        } catch (Exception e) {
            System.out.println("display method threw an exception: " + e.getMessage());
        }
        
        // final message
        System.out.println("DVD tests complete. If there are no error messages above, the class works as expected.\n");

    }
    
}
