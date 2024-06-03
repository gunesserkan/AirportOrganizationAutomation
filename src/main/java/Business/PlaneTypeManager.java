package Business;

import Dao.PlaneTypeDao;
import Entity.PlaneType;

import java.sql.SQLException;

public class PlaneTypeManager {

    private PlaneTypeDao planeTypeDao;

    public PlaneTypeManager() {
        this.planeTypeDao = new PlaneTypeDao();
    }

    public PlaneType findPlaneTypeById(int planeTypeId) throws SQLException {
        return planeTypeDao.findById(planeTypeId);
    }

    public void addPlaneType(PlaneType planeType) throws SQLException {
        planeTypeDao.insert(planeType);
    }

    public void updatePlaneType(PlaneType planeType) throws SQLException {
        planeTypeDao.update(planeType);
    }

    public void deletePlaneType(int planeTypeId) throws SQLException {
        planeTypeDao.delete(planeTypeId);
    }
}
