package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Repository {

    private final String dbUser = System.getenv("dbUser");
    private final String dbPassword = System.getenv("dbPassword");
    private final String dbUrl = System.getenv("dbUrl");


    private final Connection dbConnect() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        return conn;
    }

    public ArrayList<User> getUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<>();

        try (Statement stmt = dbConnect().createStatement()) {
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
