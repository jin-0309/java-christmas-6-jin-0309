package christmas.utils;

public enum PlannerNumber {
    DECEMBER_MIN_DATE(1),
    DECEMBER_MAX_DATE(31);

    private final int number;

    PlannerNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
