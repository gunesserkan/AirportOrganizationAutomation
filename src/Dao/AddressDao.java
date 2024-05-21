package Dao;

import Core.Config;
import Entity.Address;

import java.sql.Connection;

public class AddressDao {
    private Connection connection;

    public AddressDao() {
        this.connection = Config.getIntance();
    }
}
