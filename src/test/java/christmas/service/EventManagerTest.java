package christmas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.Menu;
import christmas.model.Order;
import christmas.model.Reservation;
import christmas.model.event.Event;
import christmas.model.event.impl.DayByDayEvent;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventManagerTest {

    private EventManager eventManager;
    private Reservation reservation;

    @BeforeEach
    void setUp() {
        this.eventManager = new EventManager();
        Order order = new Order();
        order.add(new Menu("test", 10000, "test"), 1);
        this.reservation =
                new Reservation(1, 1, order, LocalDate.of(2023, 12, 25));
    }

    @Test
    void applyEvent() {
        Event event = new DayByDayEvent();
        eventManager.addEvent(event);

        assertEquals(0, reservation.getEvents().size());

        eventManager.applyEvent(reservation);

        assertEquals(1, reservation.getEvents().size());
    }
}