package Dao;

import Core.Database;
import Entity.Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonalDao {
    private Connection connection;

    public PersonalDao() {
        this.connection = Database.getIntance();
    }

    public Personal findById(int personalId) throws SQLException {
        Personal personal = null;
        String sql = "SELECT * FROM personal WHERE persoanl_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, personalId);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            personal = this.match(result);
        }
        return personal;
    }


    public void insert(Personal personal) throws SQLException {
        String sql = "INSERT INTO personal (first_name, last_name, birth_date,gender) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, personal.getFirstname());
        preparedStatement.setString(2, personal.getLastname());
        preparedStatement.setDate(3, new java.sql.Date(personal.getBirthDate().getTime()));
        preparedStatement.setString(4, Character.toString(personal.getGender()));
        preparedStatement.executeUpdate();
    }
    public void update(Personal personal) throws SQLException {
        String sql = "UPDATE personal SET first_name=?, last_name=?, birth_date=?, gender=? WHERE personal_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, personal.getFirstname());
        preparedStatement.setString(2, personal.getLastname());
        preparedStatement.setDate(3, new java.sql.Date(personal.getBirthDate().getTime()));
        preparedStatement.setString(4, Character.toString(personal.getGender()));
        preparedStatement.executeUpdate();
    }

    public void delete(int personalId) throws SQLException {
        String sql = "DELETE FROM personal WHERE personal_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, personalId);
        preparedStatement.executeUpdate();
    }
    private Personal match(ResultSet result) throws SQLException {
        Personal personal = new Personal(
                result.getInt("personal_id"),
                result.getString("first_name"),
                result.getString("last_name"),
                result.getDate("birth_date"),
                result.getString("gender").charAt(0));
        return personal;
    }
}