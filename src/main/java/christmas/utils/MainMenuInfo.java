package christmas.utils;

public enum MainMenuInfo {
    T_BONE_STEAK("티본스테이크", 55000),
    BBQ_RIBS("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000);

    private final String message;

    private final int price;

    MainMenuInfo(String message, int price) {
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
