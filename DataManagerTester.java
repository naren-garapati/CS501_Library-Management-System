// package FinalProject;

// import FinalProject.DataManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataManagerTester {
    
    public static void main(String[] args) {
        System.out.println("===== Testing DataManager class =====");
        
        
        // Initialize and test constructor
        DataManager manager = new DataManager();
        if (manager.getAllItems().size() != 0) {
            System.out.println("Constructor failed: collection not empty");
        }
        
        // Test loading methods
        manager.loadBooks("books.csv");
        manager.loadDVDs("dvds.csv");
        manager.loadNewspapers("newspapers.csv");
        
        // Verify counts
        if (manager.getBooks().size() != 1) {
            System.out.println("Book loading failed. Expected 1, got: " + manager.getBooks().size());
        }
        
        if (manager.getDVDs().size() != 1) {
            System.out.println("DVD loading failed. Expected 1, got: " + manager.getDVDs().size());
        }
        
        if (manager.getNewspapers().size() != 1) {
            System.out.println("Newspaper loading failed. Expected 1, got: " + manager.getNewspapers().size());
        }
        
        if (manager.getAllItems().size() != 3) {
            System.out.println("getAllItems failed. Expected 3, got: " + manager.getAllItems().size());
        }
        
        // Test displayAllItems
        try {
            manager.displayAllItems();
        } catch (Exception e) {
            System.out.println("displayAllItems threw an exception: " + e.getMessage());
        }
        
        System.out.println("DataManager tests complete. Everything works as expected if there are no error messages above. You should be able to see the data sets being displayed\n");
    }

}
