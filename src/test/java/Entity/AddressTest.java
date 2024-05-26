package Entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {

    private Address address;

    @Before
    public void setUp() throws Exception {
        address = new Address(1, "123 Main St", "Test State", "12345", "Test Country", 1);
    }

    @After
    public void tearDown() throws Exception {
        address = null;
    }

    @Test
    public void getAddress_id() {
        assertEquals(1, address.getAddress_id());
    }

    @Test
    public void setAddress_id() {
        address.setAddress_id(2);
        assertEquals(2, address.getAddress_id());
    }

    @Test
    public void getStreet() {
        assertEquals("123 Main St", address.getStreet());
    }

    @Test
    public void setStreet() {
        address.setStreet("456 Elm St");
        assertEquals("456 Elm St", address.getStreet());
    }

    @Test
    public void getState() {
        assertEquals("Test State", address.getState());
    }

    @Test
    public void setState() {
        address.setState("New State");
        assertEquals("New State", address.getState());
    }

    @Test
    public void getPostal_code() {
        assertEquals("12345", address.getPostal_code());
    }

    @Test
    public void setPostal_code() {
        address.setPostal_code("67890");
        assertEquals("67890", address.getPostal_code());
    }

    @Test
    public void getCountry() {
        assertEquals("Test Country", address.getCountry());
    }

    @Test
    public void setCountry() {
        address.setCountry("New Country");
        assertEquals("New Country", address.getCountry());
    }

    @Test
    public void getAccount_id() {
        assertEquals(1, address.getAccount_id());
    }

    @Test
    public void setAccount_id() {
        address.setAccount_id(2);
        assertEquals(2, address.getAccount_id());
    }
}
