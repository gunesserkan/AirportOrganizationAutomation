package Business;

import Dao.AirportDao;
import Entity.Airport;

import java.sql.SQLException;
import java.util.ArrayList;

public class AirportManager {

    private AirportDao airportDao;

    public AirportManager() {
        this.airportDao = new AirportDao();
    }

    public Airport findAirportById(int airportId) throws SQLException {
        return airportDao.findById(airportId);
    }

    public ArrayList<Airport> getAllAirports() throws SQLException {
        return airportDao.findAll();
    }

    public void addAirport(Airport airport) throws SQLException {
        airportDao.insert(airport);
    }

    public void updateAirport(Airport airport) throws SQLException {
        airportDao.update(airport);
    }

    public void deleteAirport(int airportId) throws SQLException {
        airportDao.delete(airportId);
    }
}
