package christmas.model;

public class Menu {

    private final int menuId;

    private final String name;

    private final int price;

    public Menu(int menuId, String name, int price) {
        this.menuId = menuId;
        this.name = name;
        this.price = price;
    }

    public int getMenuId() {
        return this.menuId;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

}
