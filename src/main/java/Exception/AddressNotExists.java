package Exception;

public class AddressNotExists extends RuntimeException{
    public AddressNotExists(int addressId){
        super("Address is not exists with given id: "+addressId);
    }
}
