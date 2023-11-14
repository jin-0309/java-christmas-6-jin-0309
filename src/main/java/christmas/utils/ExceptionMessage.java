package christmas.utils;

public enum ExceptionMessage {
    ERROR_PREFIX("[ERROR] "),
    INVALID_NUMBER_INPUT("숫자만 입력해 주세요."),
    INVALID_DATE_INPUT("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER_INPUT("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ILLEGAL_STATE("유효하지 않은 상태입니다. 코트를 확인해주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
