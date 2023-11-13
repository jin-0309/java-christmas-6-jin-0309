package christmas.model.repository;

import christmas.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public Optional<User> findById(int id) {
        return users.stream()
                .filter(user -> user.getUserID() == id)
                .findFirst();
    }
}
