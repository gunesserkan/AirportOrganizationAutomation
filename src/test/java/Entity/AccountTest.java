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
        account.setId(1);

        // Act
        int id = account.getId();

        // Assert
        assertEquals(1, id);
    }

    @Test
    public void testSetId() {
        // Arrange & Act
        account.setId(1);

        // Assert
        assertEquals(1, account.getId());
    }

    @Test
    public void testGetUsername() {
        // Arrange
        account.setUsername("username");

        // Act
        String username = account.getUsername();

        // Assert
        assertEquals("username", username);
    }

    @Test
    public void testSetUsername() {
        // Arrange & Act
        account.setUsername("username");

        // Assert
        assertEquals("username", account.getUsername());
    }

    // Similarly, implement test methods for other properties: password, email, createdAt, and accountType
}
