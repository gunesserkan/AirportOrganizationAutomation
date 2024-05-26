package Dao;

import Core.Database;

import java.sql.Connection;

public class AddressDao {
    private Connection connection;

    public AddressDao() {
        this.connection = Database.getIntance();
    }
}
