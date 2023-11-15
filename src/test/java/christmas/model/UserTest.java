package christmas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    private User user;
    private int userId;

    @BeforeEach
    void setUp() {
        this.userId = 1;
        this.user = new User(userId, "test");
    }

    @Test
    void getUserId() {
        assertEquals(1, user.getUserId());
    }

    @Test
    void setBadge() {
        Badge badge = new Badge("testBadge");
        user.setBadge(badge);
        assertEquals(badge, user.getBadge());
    }

    @Test
    void getBadge() {
        Badge badge = new Badge("tetBadge");
        user.setBadge(badge);

        Badge userBadge = user.getBadge();

        assertEquals(badge, userBadge);
    }
}