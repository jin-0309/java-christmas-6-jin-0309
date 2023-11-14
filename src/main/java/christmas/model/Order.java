package christmas.model;

import java.util.HashMap;
import java.util.Map;

public class Order {

    Map<Menu, Integer> orders;

    public Order() {
        this.orders = new HashMap<>();
    }

    public void add(Menu menu, int quantity) {
        this.orders.put(menu, quantity);
    }

    public int size() {
        return this.orders.size();
    }

    public int getCountByCategory(String category) {
        return orders.keySet().stream()
                .filter(menu -> category.equals(menu.category()))
                .mapToInt(orders::get)
                .sum();
    }

    public int getTotalPrice() {
        return this.orders.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public Map<Menu, Integer> getOrders() {
        return this.orders;
    }

}
