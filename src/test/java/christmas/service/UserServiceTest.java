package christmas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.User;
import christmas.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        this.userService = new UserService(UserRepository.getInstance());
    }

    @Test
    void createUser() {
        User user = userService.createUser("test");
        int userId = user.getUserId();
        assertEquals(user, userService.findById(userId));
    }

    @Test
    void add() {
        User user = new User(1, "testAdd");
        userService.add(user);
        assertEquals(user, userService.findById(1));
    }

    @Test
    void findById() {
        User user = new User(2, "testFindById");
        userService.add(user);

        User testUser = userService.findById(2);
        assertEquals(user, testUser);
    }
}