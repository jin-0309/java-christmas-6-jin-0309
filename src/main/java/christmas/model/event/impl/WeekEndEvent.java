package christmas.model.event.impl;

import christmas.model.Order;
import christmas.model.Reservation;
import christmas.model.event.Event;
import christmas.utils.DiscountConstants;
import christmas.utils.EventInfo;
import christmas.utils.MenuCategoryInfo;
import java.time.DayOfWeek;

public class WeekEndEvent implements Event {

    private int discount;

    @Override
    public WeekEndEvent condition(Reservation reservation) {
        DayOfWeek dayOfWeek = reservation.getReservationDate().getDayOfWeek();
        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            Order order = reservation.getOrder();
            int count = order.getCountByCategory(MenuCategoryInfo.MAIN.getMessage());
            discount = count * DiscountConstants.DISCOUNT_MAIN.getIndex();
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
        return EventInfo.WEEKEND_EVENT.getMessage();
    }
}
