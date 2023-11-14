package christmas.exception;

import christmas.utils.ExceptionMessage;

public class InvalidDateException extends CustomException {
    public InvalidDateException() {
        super(ExceptionMessage.INVALID_DATE_INPUT.getMessage());
    }
}
