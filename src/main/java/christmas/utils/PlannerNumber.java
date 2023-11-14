package christmas.utils;

public enum PlannerNumber {
    DECEMBER_MIN_DATE(1),
    DECEMBER_MAX_DATE(31),
    DECEMBER(12),
    THIS_YEAR(2023),
    GIFT_LINE_PRICE(120000),
    ZERO(0);

    private final int number;

    PlannerNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
