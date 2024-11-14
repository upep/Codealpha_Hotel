import java.util.ArrayList;
import java.util.List;

public class HotelReservationSystem {

    private static List<Room> rooms = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        initializeRooms();

        
        Room availableRoom = searchAvailableRoom("Standard");
        if (availableRoom != null) {
            double totalPrice = availableRoom.getPrice() * 3; //3 days stay
            makeReservation(availableRoom, "Alice", "2024-11-15", "2024-11-18", totalPrice);
        }

        displayBookingDetails();
    }

    public static void initializeRooms() {
        rooms.add(new Room("101", "Standard", 100.0));
        rooms.add(new Room("201", "Suite", 200.0));
        rooms.add(new Room("301", "Standard", 120.0));
    }

    public static Room searchAvailableRoom(String category) {
        for (Room room : rooms) {
            if (room.getCategory().equals(category) && room.isAvailable()) {
                return room;
            }
        }
        return null;
    }

    public static void makeReservation(Room room, String guestName, String checkInDate, String checkOutDate, double totalPrice) {
        boolean paymentStatus = Payment.processPayment(totalPrice);
        if (paymentStatus) {
            Reservation reservation = new Reservation(room, guestName, checkInDate, checkOutDate, totalPrice);
            reservations.add(reservation);
        } else {
            System.out.println("Payment processing failed. Reservation not made.");
        }
    }

    public static void displayBookingDetails() {
        for (Reservation reservation : reservations) {
            System.out.println("Room Number: " + reservation.getRoom().getRoomNumber());
            System.out.println("Guest Name: " + reservation.getGuestName());
            System.out.println("Check-in Date: " + reservation.getCheckInDate());
            System.out.println("Check-out Date: " + reservation.getCheckOutDate());
            System.out.println("Total Price: $" + reservation.getTotalPrice());
            System.out.println("----------------------");
        }
    }
    
}
