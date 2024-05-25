package Dao;
import Core.Database;

import java.sql.Connection;
public class AccountDao {
    private Connection connection;

    public AccountDao(){
        this.connection= Database.getIntance();
    }
}
