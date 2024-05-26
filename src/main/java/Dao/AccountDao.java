package Dao;
import Core.Database;
import Entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountDao {
    private Connection connection;

    public AccountDao(){
        this.connection= Database.getIntance();
    }

    public Account findByLogin(String username,String password,int accountType) throws SQLException {
        Account account=null;
        String sql="SELECT * FROM account WHERE username=? AND password=? AND account_type=?";
        PreparedStatement preparedStatement= this.connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        preparedStatement.setInt(3,accountType);
        ResultSet result=preparedStatement.executeQuery();
        if(result.next()){
            account=this.match(result);
        }
        return account;
    }

    public ArrayList<Account> findAll() throws SQLException {
        ArrayList<Account> accounts=new ArrayList<>();
        Account account=null;
        String sql="SELECT * FROM account";
        PreparedStatement preparedStatement=this.connection.prepareStatement(sql);
        var result=preparedStatement.executeQuery();
        while (result.next()){
            accounts.add(this.match(result));
        }
        return accounts;
    }
    public Account match(ResultSet result) throws SQLException {
        Account account=new Account();
        account.setId(result.getInt("account_id"));
        account.setUsername(result.getString("username"));
        account.setPassword(result.getString("password"));
        account.setEmail(result.getString("e_mail"));
        account.setCreatedAt(result.getString("created_at"));
        account.setAccountType(result.getInt("account_type"));
        return account;
    }
}
