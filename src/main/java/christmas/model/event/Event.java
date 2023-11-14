package christmas.model.event;

import christmas.model.Reservation;

public interface Event {
    int getDiscount();

    Event condition(Reservation reservation);

    String getEventName();
}
