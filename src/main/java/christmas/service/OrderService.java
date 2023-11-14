package christmas.service;

import christmas.exception.InvalidOrderException;
import christmas.model.Order;
import christmas.utils.OrderConstants;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderService {

    private final MenuService menuService;

    public OrderService(MenuService menuService) {
        this.menuService = menuService;
    }

    public Order createOrder(String input) {
        validatePattern(input);
        List<String> orders = Arrays.asList(input.split(OrderConstants.DIVING_POINT.getValue()));
        Order order = new Order();
        orders.forEach(orderDetail -> {
            List<String> details = Arrays.asList(orderDetail.split(OrderConstants.DELIMITER.getValue()));
            order.add(menuService.findById(details.get(OrderConstants.MENU_NAME.getIndex())),
                    validateQuantity(details.get(OrderConstants.MENU_QUANTITY.getIndex())));
        });
        validateDuplicationMenu(order, orders.size());
        return order;
    }

    public int validateQuantity(String inputQuantity) {
        int quantity = Integer.parseInt(inputQuantity);
        if (quantity < OrderConstants.QUANTITY_MIN.getIndex()) {
            throw new InvalidOrderException();
        }
        return quantity;
    }

    public void validatePattern(String input) {
        Pattern pattern = Pattern.compile(OrderConstants.ORDER_PATTERN.getValue());
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            throw new InvalidOrderException();
        }
    }

    public void validateDuplicationMenu(Order order, int count) {
        if (order.size() != count) {
            throw new InvalidOrderException();
        }
    }

}
