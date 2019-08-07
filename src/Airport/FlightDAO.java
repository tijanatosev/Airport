package Airport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {

    private String[] status = {"On time", "Delayed", "Boarding", "Cancelled", "Landed", "Took off" };

    public FlightDAO() {}

    private Flight createFlight(ResultSet rs) {
        Flight f = new Flight();
        try {
            f.setId_flight(rs.getInt("id_flight"));
            f.setFromCity(rs.getString("fromCity"));
            f.setToCity(rs.getString("toCity"));
            f.setTimeExp(rs.getString("timeExp"));
            f.setpDay(rs.getInt("pDay"));
            f.setpMonth(rs.getInt("pMonth"));
            f.setpYear(rs.getInt("pYear"));
            f.setInd(rs.getInt("ind"));
            int key = rs.getInt("status");
            f.setStatus(status[key]);
            f.setGate(rs.getInt("gate"));
            f.setId_airport(rs.getInt("id_airport"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return f;
    }

    public List<Flight> getFlights(int id_airport) {
        String sql = "select * from flight where id_airport = " + id_airport + "";
        List<Flight> list = new ArrayList<>();
        try {
            Connection conn = Database.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Flight f = createFlight(rs);
                list.add(f);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Flight> getFlightsByID(int id_flight, int id_airport) {
        String sql = "select * from flight where id_airport = " + id_airport + " " +
                "and id_flight = " + id_flight + "";
        List<Flight> list = new ArrayList<>();
        try {
            Connection conn = Database.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (!rs.isClosed()) {
                Flight f = createFlight(rs);
                list.add(f);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Flight> getFlightsByFrom(String from, int id_airport) {
        String sql = "select * from flight where id_airport = " + id_airport + " and fromCity = '" + from + "'";
        List<Flight> list = new ArrayList<>();
        try {
            Connection conn = Database.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (!rs.isClosed()) {
                Flight f = createFlight(rs);
                list.add(f);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Flight> getFlightsByTo(String to, int id_airport) {
        String sql = "select * from flight where id_airport = " + id_airport + " and toCity = '" + to + "'";
        List<Flight> list = new ArrayList<>();
        try {
            Connection conn = Database.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (!rs.isClosed()) {
                Flight f = createFlight(rs);
                list.add(f);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Flight> getFlightsByIDFrom(int id_flight, String from, int id_airport) {
        String sql = "select * from flight where fromCity = '" + from + "' and id_flight = " + id_flight + " " +
                "and id_airport = " + id_airport + "";
        List<Flight> list = new ArrayList<>();
        try {
            Connection conn = Database.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (!rs.isClosed()) {
                Flight f = createFlight(rs);
                list.add(f);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Flight> getFlightsByIDTo(int id_flight, String to, int id_airport) {
        String sql = "select * from flight where toCity = '" + to + "' and id_flight = " + id_flight + " " +
                "and id_airport = " + id_airport + "";
        List<Flight> list = new ArrayList<>();
        try {
            Connection conn = Database.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (!rs.isClosed()) {
                Flight f = createFlight(rs);
                list.add(f);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Flight> getFlightsByFromTo(String from, String to, int id_airport) {
        String sql = "select * from flight where fromCity = '" + from + "' and toCity = '" + to + "' " +
                "and id_airport = " + id_airport + "";
        List<Flight> list = new ArrayList<>();
        try {
            Connection conn = Database.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (!rs.isClosed()) {
                Flight f = createFlight(rs);
                list.add(f);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Flight> getFlightsByIDFromTo(int id_flight, String from, String to, int id_airport) {
        String sql = "select * from flight where fromCity = '" + from + "' and toCity = '" + to + "' " +
                "and id_flight = " + id_flight + " and id_airport = " + id_airport + "";
        List<Flight> list = new ArrayList<>();
        try {
            Connection conn = Database.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (!rs.isClosed()) {
                Flight f = createFlight(rs);
                list.add(f);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
