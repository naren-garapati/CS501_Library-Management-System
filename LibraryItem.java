/*creating base class for all items in the library 
 * can't use this class to instantiate directly but helps implementing child classes like book, newspaper etc 
 * 
 * 
*/
// package FinalProject;
import java.util.ArrayList;
import java.util.List;


public abstract class LibraryItem {


    // Common attributes for all library items
    private String itemId;
    private String title;
    
    private int publicationYear;
    private boolean available;
    

    // parameterized constructor 
    public LibraryItem(String itemId, String title, int publicationYear) {
        this.itemId = itemId;
        this.title = title;
        //this.author = author; --> maybe a good idea to move author to book 
        this.publicationYear = publicationYear;
        this.available = true;  // New items are available by default
        
    }

    // getters 
    public String getItemId(){
        return itemId;
    }

    public String getTitle() {
        return title;
    }


    public int getPublicationYear() {
        return publicationYear;
    }


    public boolean isAvailable() {
        return available;
    }

    // setters 
    public void setTitle(String title) {
        this.title = title;
    }


    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    protected void setAvailable(boolean available) {
        this.available = available;
    }

    // methods (to string) 
    public String toString(){
        return "ID: " + itemId + ", Title: " + title  + ", Published: " + publicationYear + ", Availability: " + isAvailable();
    }

    // making sure that subclasses implement the display method 
    public abstract void display();

}
