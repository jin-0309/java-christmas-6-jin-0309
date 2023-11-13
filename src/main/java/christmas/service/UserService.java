package christmas.service;

import christmas.model.User;
import christmas.repository.UserRepository;

public class UserService {

    private static int nextUserId = 1;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser() {
        return new User(nextUserId++);
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public User findById(int userId) {
        return userRepository.findById(userId).orElseThrow();
    }
}
