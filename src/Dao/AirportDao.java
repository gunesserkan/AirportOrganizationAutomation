package Dao;

import Core.Config;
import Entity.Airport;

import java.sql.Connection;

public class AirportDao {
    private Connection connection;

    public AirportDao() {
        this.connection = Config.getIntance();
    }
}