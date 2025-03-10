// package FinalProject;

// import FinalProject.Borrowable;
// import FinalProject.LibraryItem;


public class NewsPaper extends LibraryItem implements Borrowable {
    // attributes specific to a newspaper
    private String publicationDate;
    private String editor; 
    private String publisher; 

    // parameterized constructor
    public NewsPaper(String itemId, String title, int publicationYear, 
                    String publicationDate, String editor, String publisher) {
        super(itemId, title, publicationYear);
        this.editor = editor;
        this.publicationDate = publicationDate;
        this.publisher = publisher;
    }

    // getters
    public String getPublicationDate() {
        return publicationDate;
    }

    public String getEditor() {
        return editor;
    }

    public String getPublisher() {
        return publisher;
    }

    // setters
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // implement interface methods
    @Override
    public boolean checkOut() {
        if (isAvailable()) {
            setAvailable(false);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkIn() {
        if (!isAvailable()) {
            setAvailable(true);
            return true;
        }
        return false;
    }

    // implement to string method
    @Override
    public String toString() {
        return super.toString() + 
               ", Publication Date: " + publicationDate + 
               ", Editor: " + editor + 
               ", Publisher: " + publisher;
    }

    // implement display method
    @Override
    public void display() {
        System.out.println("----NEWSPAPER DETAILS-------");
        System.out.println(super.toString());
        System.out.println("Publication Date: " + publicationDate);
        System.out.println("Editor: " + editor);
        System.out.println("Publisher: " + publisher);
        System.out.println("-----------------------------");
    }
}