package christmas.exception;

import christmas.utils.ExceptionMessage;

public class InvalidOrderException extends CustomException {
    public InvalidOrderException() {
        super(ExceptionMessage.INVALID_ORDER_INPUT.getMessage());
    }
}
