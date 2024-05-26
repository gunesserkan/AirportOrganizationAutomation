package Dao;

import Entity.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AccountDaoTest {

    private AccountDao accountDao;

    @Before
    public void setUp() throws Exception {
        // Initialize AccountDao instance
        accountDao = new AccountDao();
    }

    @After
    public void tearDown() throws Exception {
        // Clean up resources if needed
    }

    @Test
    public void findByLogin() {
        // Test case for findByLogin method
        try {
            Account account = accountDao.findByLogin("gunes", "12345", 1);
            assertNotNull(account); // Check if account is not null
            assertEquals("gunes", account.getUsername()); // Check if username matches
            assertEquals("12345", account.getPassword()); // Check if password matches
            assertEquals(1, account.getAccountType()); // Check if account type matches
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage()); // Fail the test if an exception is thrown
        }
    }

    @Test
    public void findAll() {
        // Test case for findAll method
        try {
            ArrayList<Account> accounts = accountDao.findAll();
            assertNotNull(accounts); // Check if accounts list is not null
            assertTrue(accounts.size() > 0); // Check if accounts list is not empty
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage()); // Fail the test if an exception is thrown
        }
    }

    @Test
    public void match() {
        // Test case for match method
        try {
            Account account = new Account();
            account.setId(1);
            account.setUsername("testUser");
            account.setPassword("testPassword");
            account.setEmail("test@example.com");
            account.setCreatedAt("2022-05-26");
            account.setAccountType(1);

            // Mock ResultSet with matching data
            java.lang.reflect.Method matchMethod = AccountDao.class.getDeclaredMethod("match", ResultSet.class);
            matchMethod.setAccessible(true);
            ResultSet resultSet = Mockito.mock(ResultSet.class);
            Mockito.when(resultSet.getInt("account_id")).thenReturn(account.getId());
            Mockito.when(resultSet.getString("username")).thenReturn(account.getUsername());
            Mockito.when(resultSet.getString("password")).thenReturn(account.getPassword());
            Mockito.when(resultSet.getString("e_mail")).thenReturn(account.getEmail());
            Mockito.when(resultSet.getString("created_at")).thenReturn(account.getCreatedAt());
            Mockito.when(resultSet.getInt("account_type")).thenReturn(account.getAccountType());

            Account matchedAccount = (Account) matchMethod.invoke(accountDao, resultSet);

            assertNotNull(matchedAccount); // Check if matched account is not null
            assertEquals(account.getId(), matchedAccount.getId()); // Check if IDs match
            assertEquals(account.getUsername(), matchedAccount.getUsername()); // Check if usernames match
            assertEquals(account.getPassword(), matchedAccount.getPassword()); // Check if passwords match
            assertEquals(account.getEmail(), matchedAccount.getEmail()); // Check if emails match
            assertEquals(account.getCreatedAt(), matchedAccount.getCreatedAt()); // Check if creation dates match
            assertEquals(account.getAccountType(), matchedAccount.getAccountType()); // Check if account types match

        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage()); // Fail the test if an exception is thrown
        }
    }
}
