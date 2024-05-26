package Business;

import Dao.AccountDao;
import Entity.Account;

import java.sql.SQLException;
import java.util.ArrayList;

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
    public ArrayList<Account> findAll(){
        ArrayList<Account> accounts=new ArrayList<>();
        try {
            accounts=accountDao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }
}
