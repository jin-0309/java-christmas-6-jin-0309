package christmas.utils;

public enum BadgeInfo {
    STAR_BADGE(5000, "별"),
    TREE_BADGE(10000, "트리"),
    SANTA_BADGE(20000, "산타");

    private final int price;
    private final String value;

    BadgeInfo(int price, String value) {
        this.price = price;
        this.value = value;
    }

    public int getPrice() {
        return this.price;
    }

    public String getValue() {
        return this.value;
    }
}
