package christmas.utils;

public enum MenuCategoryInfo {
    APPETIZER("에피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    BEVERAGES("음료");

    private final String message;

    MenuCategoryInfo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
