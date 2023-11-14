package christmas.utils;

public enum DiscountConstants {
    DISCOUNT_MAIN(2023),
    DISCOUNT_DESSERT(2023),
    DISCOUNT_1000(1000),
    DISCOUNT_100(100),
    DISCOUNT_NONE(0);

    private final int index;

    DiscountConstants(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }
}
