package Business;

import Dao.PlaneDao;
import Entity.Plane;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlaneManager {

    private PlaneDao planeDao;

    public PlaneManager() {
        this.planeDao = new PlaneDao();
    }

    public Plane findPlaneById(int planeId) throws SQLException {
        return planeDao.findById(planeId);
    }

    public ArrayList<Plane> findPlanesByAirlineCompanyId(int airlineCompanyId) throws SQLException {
        return planeDao.findByAirlineCompanyId(airlineCompanyId);
    }

    public void addPlane(Plane plane) throws SQLException {
        planeDao.insert(plane);
    }

    public void updatePlane(Plane plane) throws SQLException {
        planeDao.update(plane);
    }

    public void deletePlane(int planeId) throws SQLException {
        planeDao.delete(planeId);
    }
}
