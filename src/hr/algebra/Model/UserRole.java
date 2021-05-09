package hr.algebra.Model;

/**
 *
 * @author Marta
 */
public enum UserRole {
    ADMIN(1),
    USER(2);

    private final int userRoleID;

    private UserRole(int userRoleID) {
        this.userRoleID = userRoleID;
    }

    public static UserRole getUserRoleById(int id) {
        if (id == ADMIN.getUserRoleID()) {
            return ADMIN;
        } else {
            return USER;
        }
    }

    public int getUserRoleID() {
        return userRoleID;
    }

    @Override
    public String toString() {
        return Integer.toString(userRoleID);
    }
}
