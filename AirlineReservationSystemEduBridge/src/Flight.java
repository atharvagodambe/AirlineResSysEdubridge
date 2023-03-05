public class Flight {
    private String flightNum;
    private String depart;
    private String destination;
    private int capacity;
    private int seatsBooked;

    public Flight(String flightNumber, String departure, String destination, int capacity) {
        this.flightNum = flightNumber;
        this.depart = departure;
        this.destination = destination;
        this.capacity = capacity;
        this.seatsBooked = 0;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public String getDepart() {
        return depart;
    }

    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void addTicket() {
        seatsBooked++;
    }
}
