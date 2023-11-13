package christmas.service;

import christmas.model.User;
import christmas.repository.UserRepository;
import java.util.concurrent.atomic.AtomicInteger;

public class UserService {

    private final AtomicInteger nextUserId = new AtomicInteger(1);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name) {
        int id = nextUserId.getAndIncrement();
        User user = new User(id, name);
        userRepository.addUser(user.userId(), user);
        return user;
    }


    public User findById(int userId) {
        return userRepository.findById(userId);
    }
}
