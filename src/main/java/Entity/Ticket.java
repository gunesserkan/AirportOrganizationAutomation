package Entity;

public class Ticket {
    private int id;
    private int flightId;
    private int accountId;
    private String seatNumber;

    public Ticket(int id, int flightId, int accountId, String seatNumber) {
        this.id = id;
        this.flightId = flightId;
        this.accountId = accountId;
        this.seatNumber = seatNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}
