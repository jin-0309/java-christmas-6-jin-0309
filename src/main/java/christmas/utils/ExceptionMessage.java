package christmas.utils;

public enum ExceptionMessage {
    ERROR_PREFIX("[ERROR] "),
    INVALID_NUMBER_INPUT("숫자만 입력해 주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
