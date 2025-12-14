package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class UserRepository {

    private final String dbUser = System.getenv("dbUser");
    private final String dbPassword = System.getenv("dbPassword");
    private final String dbUrl = System.getenv("dbUrl");

    private final String USER_QUERY = "SELECT user_id, user_name, admin FROM users";
    private final String LOGIN_QUERY = "SELECT user_id, user_name, admin FROM users WHERE user_name = ? AND password = ?";

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
            ResultSet rs = stmt.executeQuery(USER_QUERY);

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

    public User login(String username, String password) throws SQLException {
        try {
            Connection conn = dbConnect();
            PreparedStatement stmt = conn.prepareStatement(LOGIN_QUERY);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getBoolean("admin"));
            } else {
                throw new NoSuchElementException("No User Found");
            }

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

    }
}
