// package FinalProject;

// import FinalProject.NewsPaper;
// import FinalProject.Borrowable;


public class NewsPaperTester {
    public static void main(String[] args){

        System.out.println("\nNewspaper tester...");

        // getter and constructor test
        NewsPaper paper = new NewsPaper("N001", "Test Paper", 2023, "2023-03-15", "Test Editor", "Test Publisher");

        if (!paper.getItemId().equals("N001")) {
            System.out.println("ItemId getter failed. Expected: N001, Got: " + paper.getItemId());
        }
        
        if (!paper.getTitle().equals("Test Paper")) {
            System.out.println("Title getter failed. Expected: Test Paper, Got: " + paper.getTitle());
        }

        if (paper.getPublicationYear() != 2023) {
            System.out.println("PublicationYear getter failed. Expected: 2023, Got: " + paper.getPublicationYear());
        }
        
        if (!paper.getPublicationDate().equals("2023-03-15")) {
            System.out.println("PublicationDate getter failed. Expected: 2023-03-15, Got: " + paper.getPublicationDate());
        }

        if (!paper.getEditor().equals("Test Editor")) {
            System.out.println("Editor getter failed. Expected: Test Editor, Got: " + paper.getEditor());
        }
        
        if (!paper.getPublisher().equals("Test Publisher")) {
            System.out.println("Publisher getter failed. Expected: Test Publisher, Got: " + paper.getPublisher());
        }

        if (!paper.isAvailable()) {
            System.out.println("isAvailable failed. New items should be available by default.");
        }
        
        // Test setters
        paper.setPublicationDate("2023-03-16");
        if (!paper.getPublicationDate().equals("2023-03-16")) {
            System.out.println("PublicationDate setter failed. Expected: 2023-03-16, Got: " + paper.getPublicationDate());
        }
        
        paper.setEditor("New Editor");
        if (!paper.getEditor().equals("New Editor")) {
            System.out.println("Editor setter failed. Expected: New Editor, Got: " + paper.getEditor());
        }
        
        paper.setPublisher("New Publisher");
        if (!paper.getPublisher().equals("New Publisher")) {
            System.out.println("Publisher setter failed. Expected: New Publisher, Got: " + paper.getPublisher());
        }

        // Test checkOut when available
        boolean checkOutResult = paper.checkOut();
        if (!checkOutResult) {
            System.out.println("checkOut failed. Should return true when item is available.");
        }
        
        if (paper.isAvailable()) {
            System.out.println("checkOut failed. Item should be unavailable after checkout.");
        }
        
        // Test checkOut when already checked out
        checkOutResult = paper.checkOut();
        if (checkOutResult) {
            System.out.println("checkOut failed. Should return false when item is already checked out.");
        }

        // Test checkIn when checked out
        boolean checkInResult = paper.checkIn();
        if (!checkInResult) {
            System.out.println("checkIn failed. Should return true when item is checked out.");
        }
        
        if (!paper.isAvailable()) {
            System.out.println("checkIn failed. Item should be available after check-in.");
        }
        
        // Test checkIn when already available
        checkInResult = paper.checkIn();
        if (checkInResult) {
            System.out.println("checkIn failed. Should return false when item is already available.");
        }

        // Test toString
        String paperString = paper.toString();
        if (!paperString.contains("ID: N001") ||
            !paperString.contains("Title: Test Paper") ||
            !paperString.contains("Published: 2023") ||
            !paperString.contains("Publication Date: 2023-03-16") ||
            !paperString.contains("Editor: New Editor") ||
            !paperString.contains("Publisher: New Publisher")) {
            System.out.println("toString method failed. Expected all NewsPaper details, but got: " + paperString);
        }
        
        // display method 
        try {
            paper.display();
        } catch (Exception e) {
            System.out.println("display method threw an exception: " + e.getMessage());
        }
        


        System.out.println("NewsPaper tests complete. See on top for any potential errors");
    




    }
    
}
