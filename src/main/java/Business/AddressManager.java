package Business;

import Dao.AddressDao;
import Entity.Address;
import java.util.ArrayList;
import Exception.AddressNotExists;

public class AddressManager {

    private final AddressDao addressDao = new AddressDao();

    public Address findById(int addressId) throws Exception {
        Address address = null;
        address = addressDao.findById(addressId);
        if (address != null) {
            throw new AddressNotExists(addressId);
        }
        return address;
    }

    public ArrayList<Address> findByAccountId(int accountId) throws Exception {
        ArrayList<Address> addressList = new ArrayList<>();
        addressList = addressDao.findByAccountId(accountId);
        if (addressList.size() == 0) {
            throw new RuntimeException("Address' not found");
        }
        return addressList;
    }

    public void insert(Address address) throws Exception {
        addressDao.insert(address);
    }
    public void update(Address address) throws Exception {
        addressDao.update(address);
    }
    public void delete(int addressId) throws Exception {
        Address address=addressDao.findById(addressId);
        if (address==null){
            throw new AddressNotExists(addressId);
        }
        addressDao.delete(addressId);
    }
}
