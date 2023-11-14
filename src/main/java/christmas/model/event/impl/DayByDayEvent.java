package christmas.model.event.impl;

import christmas.model.Reservation;
import christmas.model.event.Event;
import christmas.utils.DiscountConstants;
import java.time.LocalDate;

public class DayByDayEvent implements Event {

    private int discount = DiscountConstants.DISCOUNT_1000.getIndex();

    @Override
    public DayByDayEvent condition(Reservation reservation) {
        if (validateDayByDayDate(reservation.getReservationDate())) {
            int date = reservation.getReservationDate().getDayOfMonth() - 1;
            discount += (date * DiscountConstants.DISCOUNT_100.getIndex());
        }
        return null;
    }

    @Override
    public int getDiscount() {
        return this.discount;
    }

    private boolean validateDayByDayDate(LocalDate date) {
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        if (month == 12 && day <= 25) {
            return true;
        }
        return false;
    }
}
