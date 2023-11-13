package christmas.model;

public class Menu {

    private int menuId;

    private String name;

    private int price;

    public Menu(int menuId, String name, int price) {
        this.menuId = menuId;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

}
