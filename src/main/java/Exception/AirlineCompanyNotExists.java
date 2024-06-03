package Exception;

public class AirlineCompanyNotExists extends RuntimeException {
    public AirlineCompanyNotExists(int companyId) {
        super("Airline company with ID " + companyId + " does not exist.");
    }
}