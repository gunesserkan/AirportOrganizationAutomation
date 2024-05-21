package Dao;

import Core.Config;
import Entity.AirlineCompany;

import java.sql.Connection;

public class AirlineCompanyDao {
    private Connection connection;

    public AirlineCompanyDao(){
        this.connection= Config.getIntance();
    }
}