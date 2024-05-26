package Entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() {
        account = new Account();
    }

    @After
    public void tearDown() {
        account = null;
    }

    @Test
    public void testGetId() {
        // Arrange
        int expectedId = 1;
        account.setId(expectedId);

        // Act
        int actualId = account.getId();

        // Assert
        assertEquals(expectedId, actualId);
    }

    @Test
    public void testSetId() {
        // Arrange
        int expectedId = 1;

        // Act
        account.setId(expectedId);

        // Assert
        assertEquals(expectedId, account.getId());
    }

    @Test
    public void testGetUsername() {
        // Arrange
        String expectedUsername = "username";
        account.setUsername(expectedUsername);

        // Act
        String actualUsername = account.getUsername();

        // Assert
        assertEquals(expectedUsername, actualUsername);
    }

    @Test
    public void testSetUsername() {
        // Arrange
        String expectedUsername = "username";

        // Act
        account.setUsername(expectedUsername);

        // Assert
        assertEquals(expectedUsername, account.getUsername());
    }

    // Similarly, implement test methods for other properties: password, email, createdAt, and accountType

    @Test
    public void testToString() {
        // Arrange
        int id = 1;
        String username = "user";
        String password = "pass";
        String email = "user@example.com";
        String createdAt = "2022-05-26";
        int accountType = 1;

        account.setId(id);
        account.setUsername(username);
        account.setPassword(password);
        account.setEmail(email);
        account.setCreatedAt(createdAt);
        account.setAccountType(accountType);

        String expectedString = "Account{id=1, username='user', password='pass', email='user@example.com', createdAt='2022-05-26', accountType=1}";

        // Act
        String actualString = account.toString();

        // Assert
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testEquals() {
        // Arrange
        Account account1 = new Account();
        account1.setId(1);
        account1.setUsername("user1");

        Account account2 = new Account();
        account2.setId(1);
        account2.setUsername("user1");

        Account account3 = new Account();
        account3.setId(2);
        account3.setUsername("user2");

        // Act & Assert
        assertTrue(account1.equals(account2)); // Same id and username
        assertFalse(account1.equals(account3)); // Different id and username
        assertFalse(account1.equals(null)); // Comparison with null object
        assertFalse(account1.equals("user1")); // Comparison with different class
    }

    @Test
    public void testHashCode() {
        // Arrange
        Account account1 = new Account();
        account1.setId(1);
        account1.setUsername("user1");

        Account account2 = new Account();
        account2.setId(1);
        account2.setUsername("user1");

        Account account3 = new Account();
        account3.setId(2);
        account3.setUsername("user2");

        // Act & Assert
        assertEquals(account1.hashCode(), account2.hashCode()); // Same id and username
        assertNotEquals(account1.hashCode(), account3.hashCode()); // Different id and username
    }
}
