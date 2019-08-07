package Airport;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TableView<Flight> tvTable;

    @FXML
    private TextField tfFrom;

    @FXML
    private TextField tfTo;

    @FXML
    private TextField tfIdFlight;

    @FXML
    private Button btFind;

    @FXML
    private TextField tfAirport;

    @FXML
    private Button btChoose;

    @FXML
    private Label lblNotification;

    private AirportDAO airportDAO = new AirportDAO();
    private FlightDAO flightDAO = new FlightDAO();
    private ObservableList<Flight> flights;
    private ObservableList<Airport> airports;

    private String[] propertyName = {"id_flight", "fromCity", "toCity", "timeExp", "status", "gate" };
    private String[] propertyLabel = { "Num. flight", "From", "To", "Time", "Status", "Gate" };

    private int ind = 0;

    private String airport;

    private String idFlight;
    private String from;
    private String to;
    private String airline;

    public Controller() { }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < propertyLabel.length; i++) {
            TableColumn<Flight, Object> col = new TableColumn<>(propertyLabel[i]);
            col.setCellValueFactory(new PropertyValueFactory<>(propertyName[i]));
            tvTable.getColumns().add(col);
        }
    }

    @FXML
    protected void onActionBTFind(ActionEvent event) {
        if (tfAirport.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("You have to insert airport!");
            alert.show();
        }

        if (tfIdFlight.getText().isEmpty() && tfFrom.getText().isEmpty() && tfTo.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("You have to insert something in the given fileds!");
            alert.show();
        }

        if (!lblNotification.getText().equals(""))
            lblNotification.setText("");

        if (ind == 1) {
            flights.clear();
            ind = 0;
        }

        String id = tfIdFlight.getText();
        String from = tfFrom.getText();
        String to = tfTo.getText();
        int idap = airports.get(0).getId_airport();
        System.out.println(id);
        System.out.println(from);
        System.out.println(to);

        if (!id.isEmpty() && from.isEmpty() && to.isEmpty()) {
            flights = FXCollections.observableArrayList(flightDAO.getFlightsByID(Integer.parseInt(id), idap));
        } else if (!id.isEmpty() && !from.isEmpty() && to.isEmpty()) {
            flights = FXCollections.observableArrayList(flightDAO.getFlightsByIDFrom(Integer.parseInt(id), from, idap));
        } else if (!id.isEmpty() && !from.isEmpty() && !to.isEmpty()) {
            flights = FXCollections.observableArrayList(flightDAO.getFlightsByIDFromTo(Integer.parseInt(id), from, to, idap));
        } else if (id.isEmpty() && !from.isEmpty() && to.isEmpty()) {
            flights = FXCollections.observableArrayList(flightDAO.getFlightsByFrom(from, idap));
        } else if (id.isEmpty() && !from.isEmpty() && !to.isEmpty()) {
            flights = FXCollections.observableArrayList(flightDAO.getFlightsByFromTo(from, to, idap));
        } else if (id.isEmpty() && from.isEmpty() && !to.isEmpty()) {
            flights = FXCollections.observableArrayList(flightDAO.getFlightsByTo(to, idap));
        }
        if (flights.size() == 0)
            lblNotification.setText("Wanted flight could not be found.");
        else {
            tvTable.setItems(flights);
            ind = 0;
        }
    }

    @FXML
    protected void onActionBTChoose(ActionEvent event) {
        if (tfAirport.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("You have to insert something in the given fileds!");
            alert.show();
        } else {
            if (ind == 1) {
                ind = 0;
                airports.clear();
                flights.clear();
            }

            airport = tfAirport.getText();

            airports = FXCollections.observableArrayList(airportDAO.getAirportByName(airport));
            flights = FXCollections.observableArrayList(flightDAO.getFlights(airports.get(0).getId_airport()));
            tvTable.setItems(flights);
            ind = 1;
        }
    }
}
