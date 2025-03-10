// package FinalProject;

// import FinalProject.Borrowable;
// import FinalProject.LibraryItem;

public class DVD extends LibraryItem implements Borrowable{

    // specific attributes for DVD
    private String director;
    private String genre;

    // constructor 
    public DVD(String itemId, String title, int publicationYear, 
               String director, String genre) {
        super(itemId, title, publicationYear);
        this.director = director;
        this.genre = genre;
    }

    // getters
    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    // setters
    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // methods 
    // methods from the interface:
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

    // implement display
    @Override
    public void display() {
        System.out.println("------------ DVD DETAILS -----------");
        System.out.println(super.toString());
        System.out.println("Director: " + director);
        System.out.println("Genre: " + genre);
        System.out.println("-------------------------------------");
    }


    // implement the toString method 
    @Override
    public String toString() {
        return super.toString() + 
               ", Director: " + director + 
               ", Genre: " + genre;
    }



}
