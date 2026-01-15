package model;

public class Todo {

    private int todo_id;
    private int user_id;
    private String todo;
    private String todo_status;
    private String description;

    public Todo(int todo_id, int user_id, String todo, String todo_status, String description) {
        this.todo_id = todo_id;
        this.user_id = user_id;
        this.todo = todo;
        this.todo_status = todo_status;
        this.description = description;
    }

    public Todo(int user_id, String todo, String todo_status, String description) {
        this.todo_id = todo_id;
        this.user_id = user_id;
        this.todo = todo;
        this.todo_status = todo_status;
        this.description = description;
    }

    public int getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(int todo_id) {
        this.todo_id = todo_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getTodo_status() {
        return todo_status;
    }

    public void setTodo_status(String todo_status) {
        this.todo_status = todo_status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
