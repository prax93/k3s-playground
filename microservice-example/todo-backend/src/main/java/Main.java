import service.UserService;

public class Main {

    static void main() throws Exception{

        UserService userService = new UserService();

        Boolean loggedIn = userService.login("testuser","testpassword");

    }
}
