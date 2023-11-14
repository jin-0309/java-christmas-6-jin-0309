package christmas.view;

import christmas.model.Badge;
import christmas.model.Menu;
import christmas.model.Reservation;
import christmas.model.event.impl.BadgeEvent;
import christmas.utils.PlannerMessage;
import christmas.utils.PlannerNumber;
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
        reservation.getOrder().getOrders().forEach((this::printOrderInfo));
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
        System.out.println();
    }

    public void printBenefitHistory(Reservation reservation) {
        System.out.println(PlannerMessage.BENEFIT_HISTORY.getMessage());
        if (reservation.getEvents() == null || reservation.getTotalDiscount() == PlannerNumber.ZERO.getNumber()) {
            System.out.println(PlannerMessage.NONE.getMessage() + PlannerMessage.NEWLINE.getMessage());
            return;
        }
        reservation.getEvents().stream()
                .filter(event -> !(event instanceof BadgeEvent)).forEach(
                        event -> System.out.println(event.getEventName() + PlannerMessage.COLON.getMessage() + converterMoney(
                                Math.negateExact(event.getDiscount()))));
        System.out.println();
    }

    public void printTotalBenefitPrice(Reservation reservation) {
        System.out.println(PlannerMessage.TOTAL_BENEFIT_AMOUNT.getMessage());
        if (reservation.getTotalDiscount() == PlannerNumber.ZERO.getNumber()) {
            System.out.println(PlannerMessage.NONE.getMessage() + PlannerMessage.NEWLINE.getMessage());
            return;
        }
        System.out.println(
                converterMoney(Math.negateExact(reservation.getTotalDiscount())) + PlannerMessage.NEWLINE.getMessage());
    }

    public void printAfterTotalPrice(Reservation reservation) {
        System.out.println(PlannerMessage.TOTAL_AMOUNT_AFTER_DISCOUNT.getMessage());
        System.out.println(converterMoney(reservation.getTotalPrice() - reservation.getTotalDiscount())
                + PlannerMessage.NEWLINE.getMessage());
    }

    public void printDecemberBadge(Badge badge) {
        System.out.println(PlannerMessage.DECEMBER_EVENT_BADGE.getMessage());
        if (badge == null) {
            System.out.println(PlannerMessage.NONE.getMessage());
        }
        if (badge != null) {
            System.out.println(badge.name());
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
