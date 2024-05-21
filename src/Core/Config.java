package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Author: gunes
 * Project: AirportOrganizationAutomation
 * E-mail: gunesserkan883@gmail.com
 * Creation Date: 4/2/2024 9:32 PM
 */
public class Config {

    private static Config instance = null;
    private Connection connection = null;
    private final String DB_URL = "jdbc:postgresql://localhost:5432/AirportOrganizationAutomation";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "12345";

    private Config() {
        try {
            this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    private Connection getConnection() {
        return connection;
    }

    public static Connection getIntance() {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new Config();
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return instance.getConnection();

    }
}