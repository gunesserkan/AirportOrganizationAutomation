package Business;

import Dao.AccountDao;
import Entity.Account;

import java.sql.SQLException;

public class AccountManager {
    private  final AccountDao accountDao = new AccountDao();

    public Account findByLogin(String username,String password,int accountType){
        Account account=null;
        try {
           account = accountDao.findByLogin(username,password,accountType);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return account;
    }
}
