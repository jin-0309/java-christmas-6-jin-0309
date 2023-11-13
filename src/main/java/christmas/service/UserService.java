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
        User user = new User(nextUserId.getAndIncrement(), name);
        userRepository.add(user);
        return user;
    }


    public User findById(int userId) {
        return userRepository.findById(userId);
    }
}
