package christmas.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.exception.InvalidOrderException;
import christmas.model.Order;
import christmas.repository.MenuRepository;
import christmas.utils.MainMenuInfo;
import christmas.utils.MenuCategoryInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    private OrderService orderService;
    private MenuService menuService;

    @BeforeEach
    void setUp() {
        this.menuService = new MenuService(MenuRepository.getInstance());
        this.orderService = new OrderService(menuService);
        for (MainMenuInfo main : MainMenuInfo.values()) {
            menuService.createMenu(main.getMessage(), main.getPrice(), MenuCategoryInfo.MAIN.getMessage());
        }
    }

    @Test
    void createOrder() {
        Order order = orderService.createOrder("티본스테이크-2");
        assertEquals(1, order.size());
        assertEquals(2, order.getOrders().get(menuService.findById("티본스테이크")));
    }

    @Test
    void validateQuantity() {
        assertEquals(3, orderService.validateQuantity("3"));
        assertThatThrownBy(() -> orderService.validateQuantity("test"))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        assertThatThrownBy(() -> orderService.validateQuantity("-1"))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void validateNumber() {
        assertEquals(2, orderService.validateNumber("2"));
        assertThatThrownBy(() -> orderService.validateNumber("test"))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void validateMinQuantity() {
        assertThatThrownBy(() -> orderService.validateMinQuantity(0)).isInstanceOf(InvalidOrderException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void validatePattern() {
        assertThatThrownBy(() -> orderService.validatePattern("티본스테이크-a")).isInstanceOf(InvalidOrderException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        assertThatThrownBy(() -> orderService.validatePattern("티본스테이크--1"))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        assertThatThrownBy(() -> orderService.validatePattern("티본스테이크"))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void validateDuplicationMenu() {
    }

    @Test
    void validateNotOnlyBeverages() {
    }

    @Test
    void isAllBeverage() {
    }

    @Test
    void validateMaxQuantity() {
    }
}