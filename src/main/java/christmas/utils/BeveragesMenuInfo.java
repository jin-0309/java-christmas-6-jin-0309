package christmas.utils;

public enum BeveragesMenuInfo {
    ZERO_COLA("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000);

    private final String message;

    private final int price;

    BeveragesMenuInfo(String message, int price) {
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
