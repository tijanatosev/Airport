package Airport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportDAO {

    public AirportDAO() {}

    private Airport createAirport(ResultSet rs) {
        Airport ap = new Airport();
        try {
            ap.setId_airport(rs.getInt("id_airport"));
            ap.setCity(rs.getString("city"));
            ap.setName(rs.getString("name"));
            ap.setNumOfGates(rs.getInt("numOfGates"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ap;
    }

    public List<Airport> getAirportByName(String name) {
        String sql = "select * from airport where name = '" + name + "'";
        List<Airport> list = new ArrayList<>();
        try {
            Connection conn = Database.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Airport ap = createAirport(rs);
            list.add(ap);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
