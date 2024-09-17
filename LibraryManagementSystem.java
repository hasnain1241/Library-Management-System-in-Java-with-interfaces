package LMS;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        
        Scanner scanner = new Scanner(System.in);
        

        // Pre-populate some books
        
        // Below can be taken as an example of polymorphism, one book many types....
        Book textbook = new Textbook(1, "SDA BY ABR", "ABR USMAN", "ISBN12345", 2022, "Education", 50.0);
        
        Book novel = new Novel(2, "The Great Grizzly", "F. Ferrari King", "ISBN54321", 1990, "Fiction", 20.0);
        
        Book referenceBook = new ReferenceBook(3, "Numerical Computing", "Imran Ashraf", "ISBN67890", 2015, "Reference", 0);
        
        library.addBook(textbook);
        
        library.addBook(novel);
        
        library.addBook(referenceBook);
        

        // Pre-populate some users
        user Students = new Students(1, "Hasnain", "Hasnain@gmail.com", "123456789", "123 F-10 St13");
        
        user faculty = new Faculty(2, "Dr. Jawad", "djawad@nu.edu.com", "987654321", "456 G13 St");
        
        user publicMember = new PublicMember(3, "Bilal Raza P", "P.Bilal.B@gmailPublic.com", "555555555", "789 D-12 St");
        
        library.adduser(Students);
        
        library.adduser(faculty);
        
        library.adduser(publicMember);

        while (true) 
        {
        	
            System.out.println("\n--- Library Management System ---");
            
            System.out.println("1. Add new book");
            
            System.out.println("2. Display available books");
            
            System.out.println("3. Remove a book");
            
            System.out.println("4. Add new user");
            
            System.out.println("5. Display users");
            
            System.out.println("6. Loan a book");
            
            System.out.println("7. Return a book");
            
            System.out.println("8. Display loan details");
            
            System.out.println("9. Exit");
            
            System.out.println("10. Display loan books");
            
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            

            switch (choice) {
                case 1:
                    // Add new book
                    System.out.println("Enter Book Type (1 for Textbook, 2 for Novel, 3 for ReferenceBook): ");
                    int bookType = scanner.nextInt();
                    System.out.println("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.println("Enter Publication Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.println("Enter Base Loan Fee: ");
                    double fee = scanner.nextDouble();

                    Book newBook;
                    if (bookType == 1) {
                        newBook = new Textbook(bookID, title, author, isbn, year, genre, fee);
                    } else if (bookType == 2) {
                        newBook = new Novel(bookID, title, author, isbn, year, genre, fee);
                    } else {
                        newBook = new ReferenceBook(bookID, title, author, isbn, year, genre, fee);
                    }
                    library.addBook(newBook);
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    // Display available books
                    library.displayAvailableBooks();
                    break;

                case 3:
                    // Remove a book
                    System.out.println("Enter Book ID to remove: ");
                    int removeBookID = scanner.nextInt();
                    library.removeBook(removeBookID);
                    break;

                case 4:
                    // Add new user
                    System.out.println("Enter user Type (1 for Students, 2 for Faculty, 3 for Public Member): ");
                    int userType = scanner.nextInt();
                    System.out.println("Enter user ID: ");
                    int userID = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.println("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Enter Address: ");
                    String address = scanner.nextLine();

                    user newuser;
                    if (userType == 1) {
                        newuser = new Students(userID, name, email, phoneNumber, address);
                    } else if (userType == 2) {
                        newuser = new Faculty(userID, name, email, phoneNumber, address);
                    } else {
                        newuser = new PublicMember(userID, name, email, phoneNumber, address);
                    }
                    library.adduser(newuser);
                    System.out.println("user added successfully.");
                    break;

                case 5:
                    // Display users
                    library.displayusers();
                    break;

                case 6:
                    // Loan a book
                    System.out.println("Enter user ID: ");
                    int loanuserID = scanner.nextInt();
                    System.out.println("Enter Book ID: ");
                    int loanBookID = scanner.nextInt();
                    System.out.println("Enter Loan Duration (in days): ");
                    int loanDuration = scanner.nextInt();
                    library.loanBook(loanuserID, loanBookID, loanDuration);
                    break;

                case 7:
                    // Return a book
                    System.out.println("Enter user ID: ");
                    int returnuserID = scanner.nextInt();
                    System.out.println("Enter Book ID: ");
                    int returnBookID = scanner.nextInt();
                    System.out.println("Enter Number of Days Late (if any): ");
                    int daysLate = scanner.nextInt();
                    library.returnBook(returnuserID, returnBookID, daysLate);
                    break;

                case 8:
                    // Display loan details
                    System.out.println("Enter user ID: ");
                    int loanDetailsuserID = scanner.nextInt();
                    library.displayLoanDetails(loanDetailsuserID);
                    break;
                    
                case 10:
                	library.displayLoanBooks();
                	break;

                case 9:
                    // Exit
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
