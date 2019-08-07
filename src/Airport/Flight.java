package Airport;

public class Flight {

    private int id_flight;
    private String fromCity;
    private String toCity;
    private String timeExp;
    private int pDay;
    private int pMonth;
    private int pYear;
    private int ind;
    private Object status;
    private int gate;
    private int id_airport;

    public Flight() { }

    public int getId_flight() { return id_flight; }

    public void setId_flight(int id_flight) {
        this.id_flight = id_flight;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getTimeExp() {
        return timeExp;
    }

    public void setTimeExp(String timeExp) {
        this.timeExp = timeExp;
    }

    public int getpDay() {
        return pDay;
    }

    public void setpDay(int pDay) {
        this.pDay = pDay;
    }

    public int getpMonth() {
        return pMonth;
    }

    public void setpMonth(int pMonth) {
        this.pMonth = pMonth;
    }

    public int getpYear() {
        return pYear;
    }

    public void setpYear(int pYear) {
        this.pYear = pYear;
    }

    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }

    public int getId_airport() {
        return id_airport;
    }

    public void setId_airport(int id_airport) {
        this.id_airport = id_airport;
    }
}
