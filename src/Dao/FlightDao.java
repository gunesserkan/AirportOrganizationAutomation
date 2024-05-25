package Dao;

import Core.Database;

import java.sql.Connection;

public class FlightDao {
    private Connection connection;

    public FlightDao(){
        this.connection= Database.getIntance();
    }
}

