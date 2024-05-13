package Entity;

public class Airport {
    private int airport_id;
    private String name;
    private String city;
    private String country;
    private String code;

    public Airport( int airport_id,String name,String city,String country, String code){
        this.airport_id=airport_id;
        this.name=name;
        this.city=city;
        this.country=country;
        this.code=code;
    }

    public int getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(int airport_id) {
        this.airport_id = airport_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
