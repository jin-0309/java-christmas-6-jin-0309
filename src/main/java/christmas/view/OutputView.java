package christmas.view;

import christmas.model.Reservation;
import christmas.utils.PlannerMessage;
import java.text.DecimalFormat;

public class OutputView {

    public void printHello() {
        System.out.println(PlannerMessage.HELLO.getMessage());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printPreview() {
        System.out.println(PlannerMessage.PREVIEW_BENEFITS_DECEMBER_EVENT.getMessage());
    }

    public void printOrderMenu(Reservation reservation) {
        System.out.println(PlannerMessage.ORDER_MENU);
        reservation.getOrder().getOrders()
                .forEach(((menu, integer) -> System.out.println(menu.name() + " " + integer + "개")));
        System.out.println();
    }

    public void printBeforeTotalPrice(Reservation reservation) {
        System.out.println(PlannerMessage.TOTAL_AMOUNT_BEFORE_DISCOUNT.getMessage());
        System.out.println(converterMoney(reservation.getTotalPrice()));
    }

    public String converterMoney(int price) {
        DecimalFormat decimalFormat = new DecimalFormat(PlannerMessage.FORMAT_UNIT.getMessage());
        return decimalFormat.format(price);
    }
}
