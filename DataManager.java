// package FinalProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/* this class is meant to take in a finite number of library items from a dataset (file) and store them
 * it also will sort and filter library items depending on what the users want to see 
 */


public class DataManager {

    // attributes
    private List<Book> books;
    private List<DVD> dvds;
    private List<NewsPaper> newspapers;
    private List<LibraryItem> allItems;

    // constructor
    public DataManager() {
        books = new ArrayList<>();
        dvds = new ArrayList<>();
        newspapers = new ArrayList<>();
        allItems = new ArrayList<>();
    }

    // load in the data from the csv files (using CSVReader library)

    // loading books 
    public void loadBooks(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header line
            br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6) {
                    String itemId = data[0].trim();
                    String title = data[1].trim();
                    int publicationYear = Integer.parseInt(data[2].trim());
                    String isbn = data[3].trim();
                    String genre = data[4].trim();
                    String author = data[5].trim();
                    
                    Book book = new Book(itemId, title, publicationYear, isbn, genre, author);
                    books.add(book);
                    allItems.add(book);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading books: " + e.getMessage());
        }
    }

    // load newspapers
    public void loadNewspapers(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header line
            br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6) {
                    String itemId = data[0].trim();
                    String title = data[1].trim();
                    int publicationYear = Integer.parseInt(data[2].trim());
                    String publicationDate = data[3].trim();
                    String editor = data[4].trim();
                    String publisher = data[5].trim();
                    
                    NewsPaper newspaper = new NewsPaper(itemId, title, publicationYear, 
                                                        publicationDate, editor, publisher);
                    newspapers.add(newspaper);
                    allItems.add(newspaper);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading newspapers: " + e.getMessage());
        }
    }


    // load dvds
    public void loadDVDs(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header line
            br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    String itemId = data[0].trim();
                    String title = data[1].trim();
                    int publicationYear = Integer.parseInt(data[2].trim());
                    String director = data[3].trim();
                    String genre = data[4].trim();
                    
                    DVD dvd = new DVD(itemId, title, publicationYear, director, genre);
                    dvds.add(dvd);
                    allItems.add(dvd);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading DVDs: " + e.getMessage());
        }
    }


    // getters 
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
    
    public List<DVD> getDVDs() {
        return new ArrayList<>(dvds);
    }
    
    public List<NewsPaper> getNewspapers() {
        return new ArrayList<>(newspapers);
    }
    
    public List<LibraryItem> getAllItems() {
        return new ArrayList<>(allItems);
    }


    // dislay collection 
    public void displayAllItems() {
        System.out.println("\n===== LIBRARY INVENTORY =====");
        System.out.println("Total items: " + allItems.size());
        System.out.println("Books: " + books.size());
        System.out.println("DVDs: " + dvds.size());
        System.out.println("Newspapers: " + newspapers.size());
        
        for (LibraryItem item : allItems) {
            item.display();
            System.out.println();
        }


    }

}
