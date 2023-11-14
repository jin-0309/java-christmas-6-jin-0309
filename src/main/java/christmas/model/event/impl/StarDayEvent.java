package christmas.model.event.impl;

import christmas.model.Reservation;
import christmas.model.event.Event;
import christmas.utils.DiscountConstants;
import christmas.utils.EventInfo;
import christmas.utils.StarDateInfo;
import java.util.Arrays;

public class StarDayEvent implements Event {
    private final int discount = DiscountConstants.DISCOUNT_1000.getIndex();

    @Override
    public StarDayEvent condition(Reservation reservation) {
        if (Arrays.stream(StarDateInfo.values())
                .anyMatch(starDate -> reservation.getReservationDate().equals(starDate.getDate()))) {
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
        return EventInfo.SPECIAL_EVENT.getMessage();
    }
}
