import repository.Repository;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World");

        Repository repository = new Repository();
        repository.dbConnect();



    }
}
