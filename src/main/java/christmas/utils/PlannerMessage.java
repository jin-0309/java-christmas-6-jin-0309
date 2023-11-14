package christmas.utils;

public enum PlannerMessage {
    HELLO("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    REQUEST_RESERVATION_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    REQUEST_MENU_QUANTITY("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    PREVIEW_BENEFITS_DECEMBER_EVENT("우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    ORDER_MENU("<주문 메뉴>"),
    TOTAL_AMOUNT_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    GIFT_MENU("<증정 메뉴>"),
    BENEFIT_HISTORY("<혜택 내역>"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>"),
    TOTAL_AMOUNT_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    DECEMBER_EVENT_BADGE("<12월 이벤트 배지>"),
    FORMAT_UNIT("#,###원"),
    NONE("없음"),
    COLON(": ");

    private final String message;

    PlannerMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
