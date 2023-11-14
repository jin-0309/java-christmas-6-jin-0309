package christmas.utils;

public enum OrderConstants {
    DIVING_POINT(","),
    DELIMITER("-"),
    ORDER_PATTERN("([a-zA-Z]+-[0-9]+)(,[a-zA-Z]+-[0-9]+)*"),
    MENU_NAME(0),
    MENU_QUANTITY(1),
    QUANTITY_MIN(1);

    private final String value;

    private final int index;

    OrderConstants(String value) {
        this.value = value;
        this.index = -1;
    }

    OrderConstants(int index) {
        this.index = index;
        this.value = null;
    }

    public String getValue() {
        return this.value;
    }

    public int getIndex() {
        return this.index;
    }
}
