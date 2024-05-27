package Dao;

import Core.Database;
import Entity.Address;
import Entity.Plane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaneDao {
    private Connection connection;

    public PlaneDao() {
        this.connection = Database.getIntance();
    }

    public Plane findById(int planeId) throws SQLException {
        Plane plane = null;
        String sql = "SELECT * FROM plane WHERE plane_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, planeId);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            plane = this.match(result);
        }
        return plane;
    }

    public ArrayList<Plane> findByAirlineCompanyId(int airlineCompanyId) throws SQLException {
        ArrayList<Plane> planes = new ArrayList<>();
        String sql = "SELECT * FROM plane WHERE airline_company_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, airlineCompanyId);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            planes.add(this.match(result));
        }
        return planes;
    }

    public void insert(Plane plane) throws SQLException {
        String sql = "INSERT INTO plane (plane_type_id, registration_number, airline_company_id) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, plane.getPlane_type_id());
        preparedStatement.setString(2, plane.getRegistrtion_number());
        preparedStatement.setInt(3, plane.getAirlineCompany_id());
        preparedStatement.executeUpdate();
    }
    public void update(Plane plane) throws SQLException {
        String sql = "UPDATE plane SET plane_type_id=?, registration_number=?, airline_company_id=? WHERE plane_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1,plane.getPlane_type_id());
        preparedStatement.setString(2, plane.getRegistrtion_number());
        preparedStatement.setInt(3, plane.getAirlineCompany_id());
        preparedStatement.executeUpdate();
    }

    public void delete(int planeId) throws SQLException {
        String sql = "DELETE FROM plane WHERE plane_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, planeId);
        preparedStatement.executeUpdate();
    }

    private Plane match(ResultSet result) throws SQLException {
        Plane plane = new Plane(
                result.getInt("plane_id"),
                result.getInt("plane_type_id"),
                result.getString("registration_number"),
                result.getInt("airline_company_id"));
        return plane;
    }
}
