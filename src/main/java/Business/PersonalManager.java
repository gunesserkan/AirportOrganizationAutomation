package Business;

import Dao.PersonalDao;
import Entity.Personal;

import java.sql.SQLException;
import java.util.ArrayList;

public class PersonalManager {

    private PersonalDao personalDao;

    public PersonalManager() {
        this.personalDao = new PersonalDao();
    }

    public Personal findPersonalById(int personalId) throws SQLException {
        return personalDao.findById(personalId);
    }

    public ArrayList<Personal> findPersonalByPersonalId(int personalId) throws SQLException {
        return personalDao.findByPersonalId(personalId);
    }

    public void addPersonal(Personal personal) throws SQLException {
        personalDao.insert(personal);
    }

    public void updatePersonal(Personal personal) throws SQLException {
        personalDao.update(personal);
    }

    public void deletePersonal(int personalId) throws SQLException {
        personalDao.delete(personalId);
    }
}
