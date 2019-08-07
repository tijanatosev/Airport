package Airport;

public class Ticket {

    private int id_ticket;
    private String company;
    private int id_plane;

    public Ticket() { }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setId_plane(int id_plane) {
        this.id_plane = id_plane;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public String getCompany() {
        return company;
    }

    public int getId_plane() { return id_plane; }
}
