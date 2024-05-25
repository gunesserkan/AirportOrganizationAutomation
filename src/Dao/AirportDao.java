package Dao;

import Core.Database;

import java.sql.Connection;

public class AirportDao {
    private Connection connection;

    public AirportDao() {
        this.connection = Database.getIntance();
    }
}