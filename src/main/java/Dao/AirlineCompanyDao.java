package Dao;

import Core.Database;
import Entity.AirlineCompany;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AirlineCompanyDao {
    private Connection connection;

    public AirlineCompanyDao() {
        this.connection = Database.getIntance();
    }

    public AirlineCompany findById(int companyId) throws SQLException {
        AirlineCompany airlineCompany = null;
        String sql = "SELECT * FROM airlinecompany WHERE id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, companyId);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            airlineCompany = this.match(result);
        }
        return airlineCompany;
    }

    public ArrayList<AirlineCompany> findByCountry(String country) throws SQLException {
        ArrayList<AirlineCompany> companies = new ArrayList<>();
        String sql = "SELECT * FROM airlinecompany WHERE country=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, country);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            companies.add(this.match(result));
        }
        return companies;
    }

    public void insert(AirlineCompany airlineCompany) throws SQLException {
        String sql = "INSERT INTO airlinecompany (name, country, established_date) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, airlineCompany.getName());
        preparedStatement.setString(2, airlineCompany.getCountry());
        preparedStatement.setDate(3, new Date(airlineCompany.getEstablishedDate().getTime()));
        preparedStatement.executeUpdate();
    }

    public void update(AirlineCompany airlineCompany) throws SQLException {
        String sql = "UPDATE airlinecompany SET name=?, country=?, established_date=? WHERE id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, airlineCompany.getName());
        preparedStatement.setString(2, airlineCompany.getCountry());
        preparedStatement.setDate(3, new Date(airlineCompany.getEstablishedDate().getTime()));
        preparedStatement.setInt(4, airlineCompany.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(int companyId) throws SQLException {
        String sql = "DELETE FROM airline_company WHERE id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, companyId);
        preparedStatement.executeUpdate();
    }

    private AirlineCompany match(ResultSet result) throws SQLException {
        AirlineCompany airlineCompany = new AirlineCompany(
                result.getInt("id"),
                result.getString("name"),
                result.getString("country"),
                result.getDate("established_date"));
        return airlineCompany;
    }
}