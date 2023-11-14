package christmas.model.event.impl;

import christmas.model.Reservation;
import christmas.model.event.Event;
import christmas.utils.BeveragesMenuInfo;
import christmas.utils.EventInfo;
import christmas.utils.PlannerNumber;

public class GiftEvent implements Event {
    private final int discount = BeveragesMenuInfo.CHAMPAGNE.getPrice();
    private static final String GIFT_ID = BeveragesMenuInfo.CHAMPAGNE.getMessage();

    @Override
    public GiftEvent condition(Reservation reservation) {
        if (reservation.getTotalPrice() >= PlannerNumber.GIFT_LINE_PRICE.getNumber()) {
            return this;
        }
        return null;
    }

    @Override
    public int getDiscount() {
        return this.discount;
    }

    @Override
    public String getEventName() {
        return EventInfo.GIFT_EVENT.getMessage();
    }

    public static String getGiftId() {
        return GIFT_ID;
    }
}
