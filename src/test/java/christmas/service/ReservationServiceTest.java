package christmas.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.exception.InvalidDateException;
import christmas.model.Order;
import christmas.model.Reservation;
import christmas.repository.ReservationRepository;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservationServiceTest {

    private ReservationService reservationService;

    @BeforeEach
    void setUp() {
        this.reservationService = new ReservationService(ReservationRepository.getInstance());
    }

    @Test
    void createReservation() {
        int userId = 2;
        Order order = new Order();
        LocalDate date = LocalDate.of(2023, 12, 10);
        Reservation reservation = reservationService.createReservation(userId, order, date);
        assertEquals(order, reservation.getOrder());
        assertEquals(date, reservation.getReservationDate());
    }

    @Test
    void findById() {
        int userId = 1;
        Order order = new Order();
        LocalDate date = LocalDate.of(2023, 1, 1);
        Reservation reservation = reservationService.createReservation(userId, order, date);
        reservationService.add(reservation);

        Reservation testReservation = reservationService.findById(userId);

        assertEquals(reservation, testReservation);
    }

    @Test
    void validateDecemberDate() {
        int date = 32;

        assertThatThrownBy(() -> reservationService.validateDecemberDate(date)).isInstanceOf(InvalidDateException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    void add() {
        int userId = 1;
        Order order = new Order();
        LocalDate date = LocalDate.of(2023, 1, 1);
        Reservation reservation = reservationService.createReservation(userId, order, date);
        int reservationId = reservation.getReservationId();
        reservationService.add(reservation);
        assertEquals(reservation, reservationService.findById(reservationId));
    }
}