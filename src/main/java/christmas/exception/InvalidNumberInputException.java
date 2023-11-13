package christmas.exception;

import christmas.utils.ExceptionMessage;

public class InvalidNumberInputException extends CustomException {
    public InvalidNumberInputException() {
        super(ExceptionMessage.INVALID_NUMBER_INPUT.getMessage());
    }
}
