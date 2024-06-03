package Business;

import Dao.AirlineCompanyDao;
import Entity.AirlineCompany;
import java.util.ArrayList;
import Exception.AirlineCompanyNotExists;

public class AirlineCompanyManager {

    private final AirlineCompanyDao airlineCompanyDao = new AirlineCompanyDao();

    public AirlineCompany findById(int companyId) throws Exception {
        AirlineCompany company = null;
        company=airlineCompanyDao.findById(companyId);
        if (company == null) {
            throw new AirlineCompanyNotExists(companyId);
        }
        return company;
    }

    public ArrayList<AirlineCompany> findByCountry(String country) throws Exception {
        ArrayList<AirlineCompany> companyList = airlineCompanyDao.findByCountry(country);
        if (companyList.size() == 0) {
            throw new RuntimeException("Airline companies not found");
        }
        return companyList;
    }

    public void insert(AirlineCompany company) throws Exception {
        airlineCompanyDao.insert(company);
    }

    public void update(AirlineCompany company) throws Exception {
        airlineCompanyDao.update(company);
    }

    public void delete(int companyId) throws Exception {
        AirlineCompany company = airlineCompanyDao.findById(companyId);
        if (company == null) {
            throw new AirlineCompanyNotExists(companyId);
        }
        airlineCompanyDao.delete(companyId);
    }
}