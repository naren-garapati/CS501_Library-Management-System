
// create an interface so that all borrowable items in the library follow a consistent format 
// flags checkOut as True if someone borrows an item 
// flags checkin as true if someone returns an item 
// isAvailable let's you know the status of items 

// package FinalProject;

public interface Borrowable {

    boolean checkOut();
    boolean checkIn();
    boolean isAvailable();
    
}
