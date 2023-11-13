package christmas.service;

import christmas.model.Reservation;
import christmas.repository.ReservationRepository;
import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationService {

    private final AtomicInteger nextReservationId = new AtomicInteger(1);

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(int userId, Map<Integer, Integer> orders, LocalDate reservationDate) {
        Reservation reservation = new Reservation(nextReservationId.getAndIncrement(), userId, orders, reservationDate);
        reservationRepository.add(reservation);
        return reservation;
    }

    public Reservation findById(int reservationId) {
        return reservationRepository.findById(reservationId);
    }
}
