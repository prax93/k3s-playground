package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;

public class Repository {

    private final String dbUser = System.getenv("dbUser");
    private final String dbPassword = System.getenv("dbPassword");
    private final String dbUrl = System.getenv("dbUrl");


    private Connection dbConnect() throws SQLException {
        Connection conn;
        conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        return conn;
    }

    public ArrayList<User> getUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<>();

        try (
                Connection conn = dbConnect();
                Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT user_id, user_name, admin FROM users");

                while(rs.next()){
                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getBoolean("admin"));

                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

    }

}
