package LMS;

public class Students extends user {
   
	private static final int MAX_LOAN_LIMIT = 5; // Student can borrow up to 5 books

    public Students(int userID, String name, String email, String phoneNumber, String address) {
        super(userID, name, email, phoneNumber, address);
    }

    @Override
    public int getMaxLoanLimit() {
        return MAX_LOAN_LIMIT;
    }
}
