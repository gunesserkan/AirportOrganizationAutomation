package Dao;

import Core.Database;
import Entity.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddressDao {
    private Connection connection;

    public AddressDao() {
        this.connection = Database.getIntance();
    }

    public Address findById(int addressId) throws SQLException {
        Address address = null;
        String sql = "SELECT * FROM address WHERE address_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, addressId);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            address = this.match(result);
        }
        return address;
    }

    public ArrayList<Address> findByAccountId(int accountId) throws SQLException {
        ArrayList<Address> addresses = new ArrayList<>();
        String sql = "SELECT * FROM address WHERE account_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, accountId);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            addresses.add(this.match(result));
        }
        return addresses;
    }

    public void insert(Address address) throws SQLException {
        String sql = "INSERT INTO address (street, state, postal_code, country, account_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, address.getStreet());
        preparedStatement.setString(2, address.getState());
        preparedStatement.setString(3, address.getPostal_code());
        preparedStatement.setString(4, address.getCountry());
        preparedStatement.setInt(5, address.getAccount_id());
        preparedStatement.executeUpdate();
    }

    public void update(Address address) throws SQLException {
        String sql = "UPDATE address SET street=?, state=?, postal_code=?, country=?, account_id=? WHERE address_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, address.getStreet());
        preparedStatement.setString(2, address.getState());
        preparedStatement.setString(3, address.getPostal_code());
        preparedStatement.setString(4, address.getCountry());
        preparedStatement.setInt(5, address.getAccount_id());
        preparedStatement.setInt(6, address.getAddress_id());
        preparedStatement.executeUpdate();
    }

    public void delete(int addressId) throws SQLException {
        String sql = "DELETE FROM address WHERE address_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, addressId);
        preparedStatement.executeUpdate();
    }

    private Address match(ResultSet result) throws SQLException {
        Address address = new Address(
                result.getInt("address_id"),
                result.getString("street"),
                result.getString("state"),
                result.getString("postal_code"),
                result.getString("country"),
                result.getInt("account_id")
        );
        return address;
    }
}
