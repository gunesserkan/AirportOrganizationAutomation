package Dao;
import Core.Config;
import Entity.Account;
import java.sql.Connection;
public class AccountDao {
    private Connection connection;

    public AccountDao(){
        this.connection=Config.getIntance();
    }
}
