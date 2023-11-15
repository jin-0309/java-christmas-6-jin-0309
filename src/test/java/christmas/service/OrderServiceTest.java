package christmas.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import christmas.exception.InvalidOrderException;
import christmas.model.Order;
import christmas.repository.MenuRepository;
import christmas.utils.BeveragesMenuInfo;
import christmas.utils.ExceptionMessage;
import christmas.utils.MainMenuInfo;
import christmas.utils.MenuCategoryInfo;
import christmas.utils.OrderConstants;
import java.util.Arrays;
import java.util.List;
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
        for (BeveragesMenuInfo beverages : BeveragesMenuInfo.values()) {
            menuService.createMenu(beverages.getMessage(), beverages.getPrice(),
                    MenuCategoryInfo.BEVERAGES.getMessage());
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
                .hasMessage(
                        ExceptionMessage.ERROR_PREFIX.getMessage() + ExceptionMessage.INVALID_ORDER_INPUT.getMessage());
        assertThatThrownBy(() -> orderService.validateQuantity("-1"))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage(
                        ExceptionMessage.ERROR_PREFIX.getMessage() + ExceptionMessage.INVALID_ORDER_INPUT.getMessage());
    }

    @Test
    void validateNumber() {
        assertEquals(2, orderService.validateNumber("2"));
        assertThatThrownBy(() -> orderService.validateNumber("test"))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage(
                        ExceptionMessage.ERROR_PREFIX.getMessage() + ExceptionMessage.INVALID_ORDER_INPUT.getMessage());
    }

    @Test
    void validateMinQuantity() {
        assertThatThrownBy(() -> orderService.validateMinQuantity(0)).isInstanceOf(InvalidOrderException.class)
                .hasMessage(
                        ExceptionMessage.ERROR_PREFIX.getMessage() + ExceptionMessage.INVALID_ORDER_INPUT.getMessage());
    }

    @Test
    void validatePattern() {
        assertThatThrownBy(() -> orderService.validatePattern("티본스테이크-a"))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage(
                        ExceptionMessage.ERROR_PREFIX.getMessage() + ExceptionMessage.INVALID_ORDER_INPUT.getMessage());
        assertThatThrownBy(() -> orderService.validatePattern("티본스테이크--1"))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage(
                        ExceptionMessage.ERROR_PREFIX.getMessage() + ExceptionMessage.INVALID_ORDER_INPUT.getMessage());
        assertThatThrownBy(() -> orderService.validatePattern("티본스테이크"))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage(
                        ExceptionMessage.ERROR_PREFIX.getMessage() + ExceptionMessage.INVALID_ORDER_INPUT.getMessage());
    }

    @Test
    void validateDuplicationMenu() {
        String input = "티본스테이크-1,티본스테이크-10";
        List<String> orders = Arrays.asList(input.split(OrderConstants.DIVING_POINT.getValue()));
        Order order = new Order();
        orders.forEach(orderDetail -> {
            List<String> details = Arrays.asList(orderDetail.split(OrderConstants.DELIMITER.getValue()));
            order.add(menuService.findById(details.get(OrderConstants.MENU_NAME.getIndex())),
                    orderService.validateQuantity(details.get(OrderConstants.MENU_QUANTITY.getIndex())));
        });
        assertThatThrownBy(() -> orderService.validateDuplicationMenu(order, orders.size())).isInstanceOf(
                InvalidOrderException.class).hasMessage(
                ExceptionMessage.ERROR_PREFIX.getMessage() + ExceptionMessage.INVALID_ORDER_INPUT.getMessage());

    }

    @Test
    void validateNotOnlyBeverages() {
        Order orderBeveragesOnly = new Order();
        orderBeveragesOnly.add(menuService.findById("레드와인"), 1);
        orderBeveragesOnly.add(menuService.findById("제로콜라"), 2);

        assertThatThrownBy(() -> orderService.validateNotOnlyBeverages(orderBeveragesOnly)).isInstanceOf(
                InvalidOrderException.class).hasMessage(
                ExceptionMessage.ERROR_PREFIX.getMessage() + ExceptionMessage.INVALID_ORDER_INPUT.getMessage());
    }

    @Test
    void isAllBeverage() {
        Order order = new Order();
        order.add(menuService.findById("해산물파스타"), 1);
        order.add(menuService.findById("레드와인"), 2);
        assertFalse(orderService.isAllBeverage(order.getCategory()));

        Order orderBeveragesOnly = new Order();
        orderBeveragesOnly.add(menuService.findById("레드와인"), 1);
        orderBeveragesOnly.add(menuService.findById("제로콜라"), 2);
        assertTrue(orderService.isAllBeverage(orderBeveragesOnly.getCategory()));

        Order orderOneBeverages = new Order();
        orderOneBeverages.add(menuService.findById("샴페인"), 1);
        assertTrue(orderService.isAllBeverage(orderOneBeverages.getCategory()));
    }

    @Test
    void validateMaxQuantity() {
        assertThatThrownBy(() -> orderService.validateMaxQuantity(21))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage(
                        ExceptionMessage.ERROR_PREFIX.getMessage() + ExceptionMessage.INVALID_ORDER_INPUT.getMessage());
    }
}