package christmas.utils;

public enum DessertMenuInfo {
    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private final String message;

    private final int price;

    DessertMenuInfo(String message, int price) {
        this.message = message;
        this.price = price;
    }

    public String getMessage() {
        return this.message;
    }

    public int getPrice() {
        return this.price;
    }
}
