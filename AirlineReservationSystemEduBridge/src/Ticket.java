public class Ticket {
    private String flightNumber;
    private String departure;
    private String destination;
    private String price;

    public Ticket(String flightNumber, String departure, String destination) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.price = "500 Rs.";
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getPrice() {
        return price;
    }
}

