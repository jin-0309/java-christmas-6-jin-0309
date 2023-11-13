package christmas.exception;

import christmas.utils.ExceptionMessage;

public abstract class CustomException extends IllegalArgumentException {
    public CustomException(String exceptionMessage) {
        super(ExceptionMessage.ERROR_PREFIX.getMessage() + exceptionMessage);
    }
}
