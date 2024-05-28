package Dao;

import Entity.Address;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class AddressDaoTest {

    private AddressDao addressDao;

    @Before
    public void setUp() throws Exception {
        addressDao = new AddressDao();
        // You might need to prepare test data or mock the database connection here
    }

    @After
    public void tearDown() throws Exception {
        // Clean up any test data if necessary
    }

    @Test
    public void findById() {
        try {
            // Replace 1 with an existing address_id in your database
            Address address = addressDao.findById(301);
            assertNotNull(address);
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void findByAccountId() {
        try {
            // Replace 1 with an existing account_id in your database
            ArrayList<Address> addresses = addressDao.findByAccountId(100);
            assertFalse(addresses.isEmpty());
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void insert() {
        try {
            // Create a new Address object with appropriate values
            Address address = new Address(300, "Test State", "Test Postal Code", "Test Country", "test country",100);
            addressDao.insert(address);
            // If the insert was successful, no exception would be thrown
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void update() {
        try {
            Address address = new Address(300, "Updated Street", "Updated State", "Updated Postal Code", "Updated Country", 1);
            addressDao.update(address);
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void delete() {
        try {
            addressDao.delete(300);
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
