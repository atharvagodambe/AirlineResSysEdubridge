import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String userPassword;
    private String userEmail;
    private List<Ticket> bookingHistory;

    public User(String userName, String userPassword, String userEmail) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.bookingHistory = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserEmail() {
        return getUserEmail();
    }

    public List<Ticket> getBookingHistory() {
        return bookingHistory;
    }

    public void addTicketToBookingHistory(Ticket ticket) {
        bookingHistory.add(ticket);
    }

}
