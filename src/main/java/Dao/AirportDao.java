package Dao;

import Core.Database;
import Entity.Airport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AirportDao {
    private Connection connection;

    public AirportDao() {
        this.connection = Database.getIntance();
    }

    public Airport findById(int airportId) throws SQLException {
        Airport airport = null;
        String sql = "SELECT * FROM airport WHERE airport_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, airportId);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            airport = this.match(result);
        }
        return airport;
    }

    public ArrayList<Airport> findAll() throws SQLException {
        ArrayList<Airport> airports = new ArrayList<>();
        String sql = "SELECT * FROM airport";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            airports.add(this.match(result));
        }
        return airports;
    }

    public void insert(Airport airport) throws SQLException {
        String sql = "INSERT INTO airport (name, city, country, code) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, airport.getName());
        preparedStatement.setString(2, airport.getCity());
        preparedStatement.setString(3, airport.getCountry());
        preparedStatement.setString(4, airport.getCode());
        preparedStatement.executeUpdate();
    }

    public void update(Airport airport) throws SQLException {
        String sql = "UPDATE airport SET name=?, city=?, country=?, code=? WHERE airport_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, airport.getName());
        preparedStatement.setString(2, airport.getCity());
        preparedStatement.setString(3, airport.getCountry());
        preparedStatement.setString(4, airport.getCode());
        preparedStatement.setInt(5, airport.getAirport_id());
        preparedStatement.executeUpdate();
    }

    public void delete(int airportId) throws SQLException {
        String sql = "DELETE FROM airport WHERE airport_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, airportId);
        preparedStatement.executeUpdate();
    }

    private Airport match(ResultSet result) throws SQLException {
        Airport airport = new Airport(
                result.getInt("airport_id"),
                result.getString("name"),
                result.getString("city"),
                result.getString("country"),
                result.getString("code"));
        return airport;
    }
}
