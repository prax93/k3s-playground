package service;

import model.User;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UserService {

    UserRepository userRepository = new UserRepository();

    public Optional<User> getUserbyUserName(String username) throws  SQLException{
        ArrayList<User> users = userRepository.getUsers();
        return Optional.ofNullable(users.stream()
                .filter(user -> user.getUser_name().equals(username))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("User not found")));
    }


    public Boolean login(String username, String password) throws Exception {
        try{
            User user = userRepository.login(username,password);
            if(user != null){
                return true;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
