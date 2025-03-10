// package FinalProject;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class LibraryMain {
    private static Scanner scanner = new Scanner(System.in);
    private static DataManager catalog = new DataManager();
    
    public static void main(String[] args) {
        // Load all data from CSV files
        System.out.println("Loading library catalog...");
        try {
            catalog.loadBooks("books.csv");
            catalog.loadDVDs("dvds.csv");
            catalog.loadNewspapers("newspapers.csv");
            System.out.println("Catalog loaded successfully!");
        } catch (Exception e) {
            System.err.println("Error loading catalog: " + e.getMessage());
            System.exit(1);
        }
        
        boolean running = true;
        
        while (running) {
            // Display menu
            System.out.println("\n===== LIBRARY CATALOG SYSTEM =====");
            System.out.println("1. View all items");
            System.out.println("2. View books only");
            System.out.println("3. View DVDs only");
            System.out.println("4. View newspapers only");
            System.out.println("5. Check out an item");
            System.out.println("6. Return an item");
            System.out.println("7. Exit");
            System.out.print("Enter your choice 1-7: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                
                switch (choice) {
                    case 1:
                        displayItems(catalog.getAllItems(), "ALL LIBRARY ITEMS");
                        break;
                    case 2:
                        displayItems(catalog.getBooks(), "BOOKS");
                        break;
                    case 3:
                        displayItems(catalog.getDVDs(), "DVDs");
                        break;
                    case 4:
                        displayItems(catalog.getNewspapers(), "NEWSPAPERS");
                        break;
                
                    case 5:
                        checkOutItem();
                        break;
                    case 6:
                        returnItem();
                        break;
                    case 7:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7 inclusive.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid number.");
            } catch (Exception e) {
                System.out.println("\nAn error occurred: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
    
    // Helper method to display items
    private static void displayItems(List<?> items, String title) {
        System.out.println("\n******** " + title + " ********");
        System.out.println("Total items: " + items.size());
        
        if (items.isEmpty()) {
            System.out.println("No items to display.");
        } else {
            for (Object item : items) {
                if (item instanceof LibraryItem) {
                    ((LibraryItem) item).display();
                    System.out.println();
                }
            }
        }
    }
    
    
    // Check out an item
    private static void checkOutItem() {
        System.out.print("Enter the ID of the item you want to check out: ");
        String itemId = scanner.nextLine().trim();
        
        if (itemId.isEmpty()) {
            System.out.println("Operation cancelled.");
            return;
        }
        
        LibraryItem itemToCheckOut = findItemById(itemId);
        
        if (itemToCheckOut == null) {
            System.out.println("Item with ID \"" + itemId + "\" not found.");
            return;
        }
        
        if (itemToCheckOut instanceof Borrowable) {
            Borrowable borrowable = (Borrowable) itemToCheckOut;
            if (borrowable.isAvailable()) {
                if (borrowable.checkOut()) {
                    System.out.println("Item checked out successfully!");
                } else {
                    System.out.println("Failed to check out the item.");
                }
            } else {
                System.out.println("\nThis item is not available for checkout.");
            }
        } else {
            System.out.println("\nThis item cannot be borrowed.");
        }
    }
    
    // Return an item
    private static void returnItem() {
        System.out.print("Enter the ID of the item you want to return: ");
        String itemId = scanner.nextLine().trim();
        
        if (itemId.isEmpty()) {
            System.out.println("Operation cancelled.");
            return;
        }
        
        LibraryItem itemToReturn = findItemById(itemId);
        
        if (itemToReturn == null) {
            System.out.println("Item with ID \"" + itemId + "\" not found.");
            return;
        }
        
        if (itemToReturn instanceof Borrowable) {
            Borrowable borrowable = (Borrowable) itemToReturn;
            if (!borrowable.isAvailable()) {
                if (borrowable.checkIn()) {
                    System.out.println("\nItem returned successfully!");
                } else {
                    System.out.println("\nFailed to return the item.");
                }
            } else {
                System.out.println("\nThis item is already available in the library.");
            }
        } else {
            System.out.println("\nThis item cannot be borrowed or returned.");
        }
    }
    
    // Helper method to find an item by ID
    private static LibraryItem findItemById(String itemId) {
        for (LibraryItem item : catalog.getAllItems()) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }
}