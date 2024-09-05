package reservationSystem;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {
    List<String> passengerNames;
    int busNo;
    Date date;
    int numberOfTickets;

    Scanner ab = new Scanner(System.in);

    public Booking() {
        passengerNames = new ArrayList<>();

        System.out.println("Enter number of tickets to book: ");
        this.numberOfTickets = ab.nextInt();
        ab.nextLine(); 

        for (int i = 1; i <= numberOfTickets; i++) {
            System.out.println("Enter name of passenger " + i + ": ");
            passengerNames.add(ab.nextLine());
        }

        System.out.println("Enter Bus number: ");
        this.busNo = ab.nextInt();

        boolean validDate = false;
        while (!validDate) {
            System.out.println("Enter date (dd-MM-yyyy): ");
            String dateInput = ab.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            try {
                date = dateFormat.parse(dateInput);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format or invalid date. Please enter a valid date.");
            }
        }
    }

    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity = 0;
        for (Bus bus : buses) {
            if (bus.getBusNo() == busNo) {
                capacity = bus.getCapacity();
            }
        }
        int booked = 0;
        for (Booking b : bookings) {
            if (b.busNo == busNo && b.date.equals(date)) {
                booked += b.numberOfTickets;
            }
        }
        return (booked + numberOfTickets) <= capacity;
    }

    public void displayBookingDetails() {
        System.out.println("Bus Number: " + busNo);
        System.out.println("Date: " + date);
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.println("Passenger Names: ");
        for (String name : passengerNames) {
            System.out.println("- " + name);
        }
    }
}

