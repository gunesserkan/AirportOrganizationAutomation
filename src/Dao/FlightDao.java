package Dao;

import Core.Config;
import Entity.Flight;
import java.sql.Connection;

public class FlightDao {
    private Connection connection;

    public FlightDao(){
        this.connection=Config.getIntance();
    }
}

