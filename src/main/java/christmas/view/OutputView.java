package christmas.view;

import christmas.utils.PlannerMessage;

public class OutputView {

    public void printHello() {
        System.out.println(PlannerMessage.HELLO.getMessage());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
