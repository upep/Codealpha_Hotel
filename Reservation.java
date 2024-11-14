public class Reservation {
    private Room room;
    private String guestName;
    private String checkInDate;
    private String checkOutDate;
    private double totalPrice;

    public Reservation(Room room, String guestName, String checkInDate, String checkOutDate, double totalPrice) {
        this.room = room;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        room.setAvailability(false);
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    
}
