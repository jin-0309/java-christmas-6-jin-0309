package christmas.utils;

public enum AppetizerMenuInfo {
    MUSHROOM_SOUP("양송이 수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000);

    private final String message;

    private final int price;

    AppetizerMenuInfo(String message, int price) {
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
