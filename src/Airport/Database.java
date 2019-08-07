package Airport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private Database() { }

    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:database/Aerodrom";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
