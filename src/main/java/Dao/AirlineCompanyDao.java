package Dao;

import Core.Database;

import java.sql.Connection;

public class AirlineCompanyDao {
    private Connection connection;

    public AirlineCompanyDao(){
        this.connection= Database.getIntance();
    }
}