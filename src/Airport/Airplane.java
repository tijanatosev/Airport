package Airport;

public class Airplane {
    private int id_plane;
    private int numOfSeats;
    private int id_flight;
    private String company;
    private int id_airport;

    public Airplane() { }

    public void setId_plane(int id_plane) {
        this.id_plane = id_plane;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public void setId_flight(int id_flight) {
        this.id_flight = id_flight;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setId_airport(int id_airport) {
        this.id_airport = id_airport;
    }

    public int getId_plane() {
        return id_plane;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public int getId_flight() {
        return id_flight;
    }

    public String getCompany() {
        return company;
    }

    public int getId_airport() {
        return id_airport;
    }
}
