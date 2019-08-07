package Airport;

public class Passenger {

    private int id_passenger;
    private String name;
    private int seat;
    private int id_ticket;
    private int id_plane;

    public Passenger() { }

    public void setId_passenger(int id_passenger) {
        this.id_passenger = id_passenger;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public void setId_plane(int id_plane) {
        this.id_plane = id_plane;
    }

    public int getId_passenger() {
        return id_passenger;
    }

    public String getName() {
        return name;
    }

    public int getSeat() {
        return seat;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public int getId_plane() {
        return id_plane;
    }
}
