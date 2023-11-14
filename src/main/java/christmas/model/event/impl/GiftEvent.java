package christmas.model.event.impl;

import christmas.model.Reservation;
import christmas.model.event.Event;
import christmas.utils.DiscountConstants;
import christmas.utils.PlannerNumber;

public class GiftEvent implements Event {
    private final int discount = DiscountConstants.DISCOUNT_NONE.getIndex();

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
}
