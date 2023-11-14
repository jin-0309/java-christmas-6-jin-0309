package christmas.model;

import christmas.model.event.Event;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private int reservationId;
    private int userId;
    private Order order;
    private LocalDate reservationDate;
    private List<Event> events;

    public Reservation(int reservationId, int userId, Order order, LocalDate reservationDate) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.order = order;
        this.reservationDate = reservationDate;
        this.events = new ArrayList<>();
    }

    public LocalDate getReservationDate() {
        return this.reservationDate;
    }

    public Order getOrder() {
        return this.order;
    }

    public int getTotalPrice() {
        return this.order.getTotalPrice();
    }
}
