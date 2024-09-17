package LMS;

import java.util.ArrayList;
import java.util.List;

public class Library implements loanableItems {
    private List<Book> books;
    private List<user> users;
    private static final double LATE_FEE_PER_DAY = 5.0; // Flat rate for late return

    // Constructor
    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Book Management Methods (same as before)
    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isLoaned()) {
                System.out.println("ID: " + book.getBookID() + ", Title: " + book.getTitle() +" , Author :"+ book.getAuthor());
            }
        }
    }

    public void removeBook(int bookID) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getBookID() == bookID && !book.isLoaned()) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book with ID " + bookID + " has been removed.");
        } else {
            System.out.println("Book either doesn't exist or is currently loaned.");
        }
    }

    // user Management
    public void adduser(user user) {
        users.add(user);
    }

    public void displayusers() {
        System.out.println("users in Library:");
        for (user user : users) {
            System.out.println("ID: " + user.getusersID() + ", Name: " + user.getName() + ", Email: " + user.getEmail());
        }
    }

    // Loan Transactions
    public void loanBook(int userID, int bookID, int loanDuration) {
        user user = finduser(userID);
        Book book = findBook(bookID);

        if (user != null && book != null && !book.isLoaned()) {
            if (user.getLoanedBooks().size() < user.getMaxLoanLimit()) {
                double loanFee = book.calculateLoanFee(loanDuration);
                if (user instanceof PublicMember) {
                    loanFee *= ((PublicMember) user).getHigherBaseFee();
                }
                book.setLoanStatus(true); // Mark the book as loaned
                user.addLoanedBook(book, loanFee);
                System.out.println("Book '" + book.getTitle() + "' has been loaned to " + user.getName());
                System.out.println("Total loan fee: $" + loanFee);
            } else {
                System.out.println(user.getName() + " has already reached the loan limit.");
            }
        } else {
            System.out.println("Book is already loaned or not found.");
        }
    }

    public void returnBook(int userID, int bookID, int daysLate) {
        user user = finduser(userID);
        Book book = findBook(bookID);

        if (user != null && book != null && book.isLoaned()) {
            user.returnBook(book);
            if (daysLate > 0) {
                double lateFee = daysLate * LATE_FEE_PER_DAY;
                System.out.println("Late fee for returning book '" + book.getTitle() + "': $" + lateFee);
            }
            System.out.println("Book '" + book.getTitle() + "' has been returned by " + user.getName());
        } else {
            System.out.println("Book is not currently loaned or user not found.");
        }
    }

    public void displayLoanDetails(int userID) {
        user user = finduser(userID);
        if (user != null) {
            System.out.println("Loan Details for " + user.getName() + ":");
            user.displayLoanedBooks();
            System.out.println("Total Loan Fees: $" + user.getTotalLoanFees());
        } else {
            System.out.println("user not found.");
        }
    }

    // Helper methods
    private user finduser(int userID) {
        for (user user : users) {
            if (user.getusersID() == userID) {
                return user;
            }
        }
        return null;
    }

    private Book findBook(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null;
    }

	@Override
	public void displayLoanBooks() {
		// TODO Auto-generated method stub
		 System.out.println("Loaned Books:");
	        for (Book book : books) {
	            if (book.isLoaned()) {
	                System.out.println("ID: " + book.getBookID() + ", Title: " + book.getTitle() +" , Author :"+ book.getAuthor());
	            }
	        }
		
		
	}

	@Override
	public double calculateLoanFee1(int duration) {
		return 25.5;
	}

	@Override
	public boolean isExtendable1() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
