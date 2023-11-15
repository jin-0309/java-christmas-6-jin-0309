package christmas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import christmas.model.event.Event;
import christmas.model.event.impl.GiftEvent;
import christmas.model.event.impl.WeekDayEvent;
import christmas.utils.BeveragesMenuInfo;
import christmas.utils.DessertMenuInfo;
import christmas.utils.MainMenuInfo;
import christmas.utils.MenuCategoryInfo;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservationTest {

    private Reservation reservation;
    private int reservationId;
    private int userID;
    private Order order;
    private LocalDate reservationDate;

    @BeforeEach
    void setUp() {
        reservationId = 1;
        userID = 1;
        order = new Order();
        order.add(new Menu(MainMenuInfo.T_BONE_STEAK.getMessage(), MainMenuInfo.T_BONE_STEAK.getPrice(),
                MenuCategoryInfo.MAIN.getMessage()), 1);
        order.add(new Menu(DessertMenuInfo.CHOCOLATE_CAKE.getMessage(), DessertMenuInfo.CHOCOLATE_CAKE.getPrice(),
                MenuCategoryInfo.DESSERT.getMessage()), 2);
        reservationDate = LocalDate.of(2023, 12, 12);
        reservation = new Reservation(reservationId, userID, order, reservationDate);
    }

    @Test
    void getReservationDate() {
        assertEquals(reservationDate, reservation.getReservationDate());
    }

    @Test
    void getOrder() {
        assertEquals(order, reservation.getOrder());
    }

    @Test
    void getTotalPrice() {
        assertEquals(85000, reservation.getTotalPrice());
    }

    @Test
    void addEvent() {
        Event event = new GiftEvent();
        reservation.addEvent(event);
        assertEquals(1, reservation.getEvents().size());
        Event nullEvent = null;
        reservation.addEvent(nullEvent);
        assertEquals(1, reservation.getEvents().size());
    }

    @Test
    void getReservationId() {
        assertEquals(reservationId, reservation.getReservationId());
    }

    @Test
    void getEvents() {
        Event weekDayEvent = new WeekDayEvent();
        Event giftEvent = new GiftEvent();
        assertEquals(0, reservation.getEvents().size());
        reservation.addEvent(weekDayEvent);
        reservation.addEvent(giftEvent);
        assertEquals(2, reservation.getEvents().size());
    }

    @Test
    void setGift() {
        Menu gift = new Menu(BeveragesMenuInfo.CHAMPAGNE.getMessage(), BeveragesMenuInfo.CHAMPAGNE.getPrice(),
                MenuCategoryInfo.BEVERAGES.getMessage());
        reservation.setGift(gift);
        assertEquals(gift, reservation.getGift());
    }

    @Test
    void getGift() {
        assertNull(reservation.getGift());
    }

    @Test
    void getTotalDiscount() {
        Event weekDayEvent = new WeekDayEvent();
        Event giftEvent = new GiftEvent();
        reservation.addEvent(weekDayEvent);
        reservation.addEvent(giftEvent);

        assertEquals(25000, reservation.getTotalDiscount());
    }
}