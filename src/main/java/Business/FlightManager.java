package Business;

import Dao.FlightDao;
import Entity.Flight;

import java.sql.SQLException;
import java.util.ArrayList;

public class FlightManager {

    private FlightDao flightDao;

    public FlightManager() {
        this.flightDao = new FlightDao();
    }

    public Flight findFlightById(int flightId) throws SQLException {
        return flightDao.findById(flightId);
    }

    public ArrayList<Flight> getAllFlights() throws SQLException {
        return flightDao.findAll();
    }

    public void addFlight(Flight flight) throws SQLException {
        flightDao.insert(flight);
    }

    public void updateFlight(Flight flight) throws SQLException {
        flightDao.update(flight);
    }

    public void deleteFlight(int flightId) throws SQLException {
        flightDao.delete(flightId);
    }
}
