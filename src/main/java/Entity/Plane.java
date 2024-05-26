package Entity;

public class Plane {
    private int plane_id;
    private int plane_type_id;
    private String registrtion_number;
    private int airlineCompany_id;

    public Plane(int plane_id, int plane_type_id, String registrtion_number, int airlineCompany_id) {
        this.plane_id = plane_id;
        this.plane_type_id = plane_type_id;
        this.registrtion_number = registrtion_number;
        this.airlineCompany_id = airlineCompany_id;
    }

    public int getPlane_id() {
        return plane_id;
    }

    public void setPlane_id(int plane_id) {
        this.plane_id = plane_id;
    }

    public int getPlane_type_id() {
        return plane_type_id;
    }

    public void setPlane_type_id(int plane_type_id) {
        this.plane_type_id = plane_type_id;
    }

    public String getRegistrtion_number() {
        return registrtion_number;
    }

    public void setRegistrtion_number(String registrtion_number) {
        this.registrtion_number = registrtion_number;
    }

    public int getAirlineCompany_id() {
        return airlineCompany_id;
    }

    public void setAirlineCompany_id(int airlineCompany_id) {
        this.airlineCompany_id = airlineCompany_id;
    }
}
