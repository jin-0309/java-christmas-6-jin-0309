package christmas.view;

import christmas.model.Menu;
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
        System.out.println(PlannerMessage.ORDER_MENU.getMessage());
        reservation.getOrder().getOrders()
                .forEach((this::printOrderInfo));
        System.out.println();
    }

    public void printBeforeTotalPrice(Reservation reservation) {
        System.out.println(PlannerMessage.TOTAL_AMOUNT_BEFORE_DISCOUNT.getMessage());
        System.out.println(converterMoney(reservation.getTotalPrice()));
        System.out.println();
    }

    public void printGift(Reservation reservation) {
        System.out.println(PlannerMessage.GIFT_MENU.getMessage());
        if (reservation.getGift() != null) {
            printOrderInfo(reservation.getGift(), 1);
        }
        if (reservation.getGift() == null) {
            System.out.println(PlannerMessage.NONE.getMessage());
        }
    }

    public String converterMoney(int price) {
        DecimalFormat decimalFormat = new DecimalFormat(PlannerMessage.FORMAT_UNIT.getMessage());
        return decimalFormat.format(price);
    }

    public void printOrderInfo(Menu menu, int quantity) {
        System.out.println(menu.name() + " " + quantity + "개");
    }
}
