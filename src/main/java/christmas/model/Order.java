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

}
