package LMS;

// an abstract class
public abstract class Book {
    private int bookID;
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private String genre;
    private boolean isLoaned;
    private double baseLoanFee;

    // Constructor
    public Book(int bookID, String title, String author, String isbn, int publicationYear, String genre, double baseLoanFee) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.baseLoanFee = baseLoanFee;
        this.isLoaned = false;
    }

    // Getters and Setters
    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isLoaned() {
        return isLoaned;
    }

    public void setLoanStatus(boolean isLoaned) {
        this.isLoaned = isLoaned;
    }

    public double getBaseLoanFee() {
        return baseLoanFee;
    }

    // Abstract method for loan calculation
    public abstract double calculateLoanFee(int duration);

    // Abstract method for extendable status
    public abstract boolean isExtendable();
}

