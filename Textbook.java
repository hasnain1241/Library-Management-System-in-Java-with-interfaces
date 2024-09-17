package LMS;

public class Textbook extends Book {
    private static final double EXTENSION_FEE = 10.0; // Fee for extending the loan period

    public Textbook(int bookID, String title, String author, String isbn, int publicationYear, String genre, double baseLoanFee) {
        super(bookID, title, author, isbn, publicationYear, genre, baseLoanFee);
    }

    @Override
    public double calculateLoanFee(int duration) {
        return getBaseLoanFee() + (duration * 2); // Example loan fee calculation based on duration
    }

    @Override
    public boolean isExtendable() {
        return true;
    }
}
