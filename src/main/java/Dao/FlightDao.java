package Dao;

import Core.Database;
import Entity.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FlightDao {
    private Connection connection;

    public FlightDao() {
        this.connection = Database.getIntance();
    }

    public Flight findById(int flightId) throws SQLException {
        Flight flight = null;
        String sql = "SELECT * FROM flight WHERE flight_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, flightId);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            flight = this.match(result);
        }
        return flight;
    }

    public ArrayList<Flight> findAll() throws SQLException {
        ArrayList<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM flight";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            flights.add(this.match(result));
        }
        return flights;
    }

    public void insert(Flight flight) throws SQLException {
        String sql = "INSERT INTO flight (airline_id, departure_airport_id, destination_airport_id, departure_time, arrival_time, plane_id) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, flight.getAirlineId());
        preparedStatement.setInt(2, flight.getDepartureAirportId());
        preparedStatement.setInt(3, flight.getDestinationAirportId());
        preparedStatement.setString(4, flight.getDepartureTime());
        preparedStatement.setString(5, flight.getArrivalTime());
        preparedStatement.setInt(6, flight.getPlaneId());
        preparedStatement.executeUpdate();
    }

    public void update(Flight flight) throws SQLException {
        String sql = "UPDATE flight SET airline_id=?, departure_airport_id=?, destination_airport_id=?, departure_time=?, arrival_time=?, plane_id=? WHERE flight_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, flight.getAirlineId());
        preparedStatement.setInt(2, flight.getDepartureAirportId());
        preparedStatement.setInt(3, flight.getDestinationAirportId());
        preparedStatement.setString(4, flight.getDepartureTime());
        preparedStatement.setString(5, flight.getArrivalTime());
        preparedStatement.setInt(6, flight.getPlaneId());
        preparedStatement.setInt(7, flight.getFlightId());
        preparedStatement.executeUpdate();
    }

    public void delete(int flightId) throws SQLException {
        String sql = "DELETE FROM flight WHERE flight_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, flightId);
        preparedStatement.executeUpdate();
    }

    private Flight match(ResultSet result) throws SQLException {
        Flight flight = new Flight(
                result.getInt("flight_id"),
                result.getInt("airline_id"),
                result.getInt("departure_airport_id"),
                result.getInt("destination_airport_id"),
                result.getString("departure_time"),
                result.getString("arrival_time"),
                result.getInt("plane_id"));
        return flight;
    }
}
