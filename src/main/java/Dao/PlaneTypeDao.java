package Dao;

import Core.Database;
import Entity.PlaneType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PlaneTypeDao {
    private Connection connection;

    public PlaneTypeDao() {
        this.connection = Database.getIntance();
    }

    public PlaneType findById(int planeTypeId) throws SQLException {
        PlaneType planeType = null;
        String sql = "SELECT * FROM planeType WHERE plane_type_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, planeTypeId);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            planeType = this.match(result);
        }
        return planeType;
    }


    public void insert(PlaneType planeType) throws SQLException {
        String sql = "INSERT INTO planeType (model,capacity) VALUES ( ?, ?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, planeType.getModel());
        preparedStatement.setString(2, planeType.getCapacity());
        preparedStatement.executeUpdate();
    }

    public void update(PlaneType planeType) throws SQLException {
        String sql = "UPDATE planeType SET model=?, capacity=? WHERE plane_type_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, planeType.getCapacity());
        preparedStatement.setString(2, planeType.getModel());
        preparedStatement.setInt(3, planeType.getPlane_type_id());
        preparedStatement.executeUpdate();
    }

    public void delete(int planeTypeID) throws SQLException {
        String sql = "DELETE FROM planeType WHERE plane_type_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, planeTypeID);
        preparedStatement.executeUpdate();
    }

    private PlaneType match(ResultSet result) throws SQLException {
        PlaneType planeType = new PlaneType(
                result.getInt("plane_type_id"),
                result.getString("model"),
                result.getString("capacity"));
        return planeType;
    }
}