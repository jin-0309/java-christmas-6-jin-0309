package christmas.model;

public record Menu(String name, int price, String category) {
    public int getPrice() {
        return this.price;
    }
}
