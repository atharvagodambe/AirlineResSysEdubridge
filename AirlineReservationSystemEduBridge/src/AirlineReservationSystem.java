import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AirlineReservationSystem {

    private List<User> users;
    private List<Flight> flights;
    private User currentUser;

    public AirlineReservationSystem() {
        this.users = new ArrayList<>();
        this.flights = new ArrayList<>();
    }

    //method for user registration
    public void register(String userName, String userPassword, String userEmail) {
        User newUser = new User(userName, userPassword, userEmail);
        users.add(newUser);
        System.out.println("User Registration Successful!");
    }

    //method for user login
    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getUserPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    //method for adding new flight
    public void addFlight(String flightNumber, String departure, String destination, int capacity) {
        Flight newFlight = new Flight(flightNumber, departure, destination, capacity);
        flights.add(newFlight);
        System.out.println("Flight " + flightNumber + " added Successfully!");
    }

    //method for searching the flight
    public List<String> searchFlights(String departure, String destination) {
        List<String> result = new ArrayList<>();

        for (Flight flight : flights) {
            if (flight.getDepart().equals(departure) && flight.getDestination().equals(destination)) {
                result.add(flight.getFlightNum());
            }
        }
        return result;
    }

    //method for booking ticket
    public boolean bookTicket(String flightNumber) {
        String currentFlightDepart = null;
        String currentFlightDestination = null;
        for (Flight flight : flights) {
            if (flight.getFlightNum().equals(flightNumber)) {
                currentFlightDepart = flight.getDepart();
                currentFlightDestination = flight.getDestination();
                flight.addTicket();
            }
        }
        Ticket ticket = new Ticket(flightNumber, currentFlightDepart, currentFlightDestination);
        currentUser.addTicketToBookingHistory(ticket);
        System.out.println("Ticket Booked Successfully!");
        return true;
    }

    public void showTickets() {
        List<Ticket> bookingHistoryCurrent = currentUser.getBookingHistory();
        System.out.println(Arrays.toString(bookingHistoryCurrent.toArray()));
        for (Ticket ticket : bookingHistoryCurrent) {
            System.out.println("Flight " + ticket.getFlightNumber() + " travelling from " + ticket.getDeparture() + " to " + ticket.getDestination() + " is booked!");
        }
    }

    public static void main(String[] args) {
        boolean choice = true;
        boolean regFlag = false;
        boolean loginFlag = false;
        int option;
        Scanner sc = new Scanner(System.in);
        AirlineReservationSystem newArs = new AirlineReservationSystem();

        //control loop
        while (choice) {
            System.out.println("Welcome to Airline Reservation System. Please Enter your Choice: ");
            System.out.println("1. Admin 2. User 3. Exit");
            int userChoice = sc.nextInt();

            if (userChoice == 1) {
                boolean adminFlag = true;
                while (adminFlag) {
                    System.out.println("Enter your choice: ");
                    System.out.println("1. Add Flight 2. Back");
                    int adminChoice = sc.nextInt();
                    if (adminChoice == 1) {
                        //input for flight number
                        System.out.println("Enter Flight Number: ");
                        String flightNumber = sc.next();

                        //input for departure location
                        System.out.println("Enter Departure Location: ");
                        String departure = sc.next();

                        //input for destination
                        System.out.println("Enter Destination: ");
                        String destination = sc.next();

                        //input for flight capacity
                        System.out.println("Enter Flight Capacity: ");
                        int capacity = sc.nextInt();

                        newArs.addFlight(flightNumber, departure, destination, capacity);
                    } else if (adminChoice == 2) {
                        adminFlag = false;
                    }
                }

            } else if (userChoice == 2) {
                boolean userFlag = true;
                while (userFlag) {
                    System.out.println("Enter your choice: ");
                    System.out.println("1. Register 2. Login 3. Search Flights 4. Book Ticket 5. Show Tickets 6. Back");
                    option = sc.nextInt();

                    switch (option) {

                        case 1:
                            //input for userName
                            System.out.println("Enter your User Name: ");
                            String userName = sc.next();

                            //input for userPassword
                            System.out.println("Enter your Password: ");
                            String userPassword = sc.next();

                            //input for userEmail (RegEx Pending)
                            System.out.println("Enter your Email-ID: ");
                            String userEmail = sc.next();

                            newArs.register(userName, userPassword, userEmail);
                            regFlag = true;
                            break;

                        case 2:
                            //input for userName
                            if(regFlag) {
                                System.out.println("Enter your User Name: ");
                                String userNameLogin = sc.next();

                                //input for userPassword
                                System.out.println("Enter your Password: ");
                                String userPasswordLogin = sc.next();

                                if (newArs.login(userNameLogin, userPasswordLogin)) {
                                    System.out.println("Login Successful!");
                                    loginFlag = true;
                                } else {
                                    System.out.println("Login Failed!");
                                }

                            } else {
                                System.out.println("Register First!");
                            }
                            break;

                        case 3:
                            if(loginFlag) {
                                //input for departure location
                                System.out.println("Enter your Departure Location: ");
                                String userDepart = sc.next();

                                //input for destination location
                                System.out.println("Enter your Destination Location: ");
                                String userDestination = sc.next();

                                List<String> result = newArs.searchFlights(userDepart, userDestination);

                                //converting result list to an array for printing
                                if (result.isEmpty()) {
                                    System.out.println("No Flights Found!");
                                } else {
                                    System.out.println(Arrays.toString(result.toArray()));
                                }

                            } else {
                                System.out.println("Login First!");
                            }
                            break;

                        case 4:
                            if(loginFlag) {
                                System.out.println("Enter Flight Number: ");
                                String currentFlightNumber = sc.next();
                                newArs.bookTicket(currentFlightNumber);

                            } else {
                                System.out.println("Login First!");
                            }
                            break;

                        case 5:
                            if(loginFlag) {
                                newArs.showTickets();

                            }else {
                                System.out.println("Login First!");
                            }
                            break;

                        case 6:
                            //exit statement
                            userFlag = false;

                    }
                }
            } else {
                System.out.println("Thank You!");
                choice = false;
            }
        }
    }
}
