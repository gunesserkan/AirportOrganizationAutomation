package Entity;

public class Address {
    private int address_id;
    private String street;
    private String state;
    private String postal_code;
    private String country;
    private int account_id;

    public Address(int address_id,String street,String state, String postal_code, String country, int account_id){
        this.address_id=address_id;
        this.street=street;
        this.state=state;
        this.postal_code=postal_code;
        this.country=country;
        this.account_id=account_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
}
