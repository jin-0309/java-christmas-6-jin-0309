package christmas.service;

import christmas.model.Reservation;
import christmas.model.event.Event;
import christmas.utils.PlannerNumber;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private final List<Event> events;

    public EventManager() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    public void applyEvent(Reservation reservation) {
        if (reservation.getTotalPrice() >= PlannerNumber.EVENT_APPLICATION_AMOUNT.getNumber()) {
            for (Event event : events) {
                reservation.addEvent(event.condition(reservation));
            }
        }
    }
}
