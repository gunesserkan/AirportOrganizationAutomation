package Entity;

import java.util.Date;

public class AirlineCompany {
    private int id;
    private String name;
    private String country;
    private Date establishedDate;

    public AirlineCompany(int id, String name, String country, Date establishedDate) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.establishedDate = establishedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(Date establishedDate) {
        this.establishedDate = establishedDate;
    }
}
