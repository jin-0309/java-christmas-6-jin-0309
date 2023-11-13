package christmas.repository;

import christmas.model.User;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static UserRepository userRepository = null;
    private final Map<Integer, User> users = new HashMap<>();

    private UserRepository() {
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public void addUser(int userId, User user) {
        users.put(userId, user);
    }

    public User findById(int id) {
        return users.get(id);
    }
}
