package Entity;

public class PlaneType {
    private int plane_type_id;
    private String model;
    private String capacity;

    public PlaneType(int plane_type_id, String capacity, String model) {
        this.plane_type_id = plane_type_id;
        this.capacity = capacity;
        this.model = model;
    }

    public int getPlane_type_id() {
        return plane_type_id;
    }

    public void setPlane_type_id(int plane_type_id) {
        this.plane_type_id = plane_type_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}

