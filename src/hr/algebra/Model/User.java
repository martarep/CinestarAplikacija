package hr.algebra.Model;

/**
 *
 * @author Marta
 */
public class User {

    private int id;
    private String username;
    private String name;
    private String password;
    private UserRole userRole;

    public User() {
    }

    public User(String name, String username, String password, UserRole userRole) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.userRole = userRole;
    }

    public User(int id, String name, String username, String password, UserRole userRole) {
        this(name, username, password, userRole);
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return name;
    }

}
