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

    public void add(User user) {
        users.put(user.getUserId(), user);
    }

    public User findById(int id) {
        return users.get(id);
    }
}
