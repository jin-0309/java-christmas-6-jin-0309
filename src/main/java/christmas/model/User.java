package christmas.model;

public class User {
    private int userId;

    private String name;

    private Badge badge;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.badge = null;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public Badge getBadge() {
        return this.badge;
    }
}
