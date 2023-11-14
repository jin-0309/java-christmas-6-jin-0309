package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.InvalidDateException;
import christmas.utils.PlannerMessage;

public class InputView {

    public int readDate() {
        System.out.println(PlannerMessage.REQUEST_RESERVATION_DATE.getMessage());
        return validateNumber(Console.readLine());
    }

    public String readOrder() {
        System.out.println(PlannerMessage.REQUEST_MENU_QUANTITY.getMessage());
        return Console.readLine();
    }

    private int validateNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidDateException();
        }
        return number;
    }
}
