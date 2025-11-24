import model.User;
import repository.Repository;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    static void main() throws SQLException {
        System.out.println("Hello World");

        Repository repository = new Repository();

        ArrayList<User> users = repository.getUsers();

        System.out.print(users);

    }
}
