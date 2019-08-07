package Airport;

public class Airport {

    private int id_airport;
    private int numOfGates;
    private String name;
    private String city;

    public Airport() { }

    public void setId_airport(int id_airport) {
        this.id_airport = id_airport;
    }

    public void setNumOfGates(int numOfGates) {
        this.numOfGates = numOfGates;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId_airport() {
        return id_airport;
    }

    public int getNumOfGates() {
        return numOfGates;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
