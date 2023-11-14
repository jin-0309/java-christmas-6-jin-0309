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
    private Menu gift;

    public Reservation(int reservationId, int userId, Order order, LocalDate reservationDate) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.order = order;
        this.reservationDate = reservationDate;
        this.events = new ArrayList<>();
        this.gift = null;
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

    public void addEvent(Event event) {
        if (event != null) {
            this.events.add(event);
        }
    }

    public int getReservationId() {
        return this.reservationId;
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public void setGift(Menu gift) {
        this.gift = gift;
    }

    public Menu getGift() {
        return this.gift;
    }

}
