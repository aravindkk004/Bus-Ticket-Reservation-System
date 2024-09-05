package reservationSystem;
import java.util.*;

public class BusDemo {
    public static void main(String[] args) {
        ArrayList<Bus> buses = new ArrayList<Bus>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();

        buses.add(new Bus(1, true, 1));
        buses.add(new Bus(2, false, 20));
        buses.add(new Bus(3, true, 30));

        Scanner ab = new Scanner(System.in);
        int userOption = 1;
        while (userOption == 1) {
            System.out.println("-------------------------------------------");
            System.out.println("|    BusNo    |    AC    |    Capacity    |");
            for (Bus bus : buses) {
                bus.displayBusInfo();
            }
            System.out.println("Enter 1 to book and 2 to exit:");
            userOption = ab.nextInt();
            if (userOption == 1) {
                Booking booking = new Booking();
                if (booking.isAvailable(bookings, buses)) {
                    System.out.println("Your details:");
                    booking.displayBookingDetails();
                    System.out.println("Enter yes to confirm booking, No to cancel: ");
                    String result = ab.next();
                    if (result.equalsIgnoreCase("yes")) {
                        bookings.add(booking);
                        System.out.println("Booking is confirmed.");
                    } else {
                        System.out.println("Your booking is cancelled.");
                    }
                } else {
                    System.out.println("Sorry. Not enough tickets available. Try another bus or date...");
                }
            }
        }
    }
}
