package model;

public class User {

    private int user_id;
    private String user_name;
    private String password;
    private Boolean admin;

    public User(int user_id, String user_name, String password, Boolean admin) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.admin = admin;
    }

    public User(int user_id, String user_name,Boolean admin) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.admin = admin;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }


}
