package christmas.service;

import christmas.model.Reservation;
import christmas.model.event.Event;
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
        for (Event event : events) {
            reservation.addEvent(event.condition(reservation));
        }
    }
}
