package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.InvalidNumberInputException;
import christmas.utils.PlannerMessage;

public class InputView {

    public int readDate() {
        System.out.println(PlannerMessage.HELLO.getMessage());
        return validateNumber(Console.readLine());
    }

    private int validateNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberInputException();
        }
        return number;
    }
}
