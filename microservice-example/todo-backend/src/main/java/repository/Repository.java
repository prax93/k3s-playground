package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Repository  {

    private final String dbUser = System.getenv("dbUser");
    private final String dbPassword = System.getenv("dbPassword");
    private final String dbUrl = System.getenv("dbUrl");

    public void dbConnect() throws SQLException {
        try (
                Connection con = DriverManager
                        .getConnection(dbUrl, dbUser, dbPassword)) {
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
