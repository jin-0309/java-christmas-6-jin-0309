package christmas.repository;

import christmas.model.Reservation;
import java.util.HashMap;
import java.util.Map;

public class ReservationRepository {
    private static ReservationRepository reservationRepository = null;

    private final Map<Integer, Reservation> reservations = new HashMap<>();

    private ReservationRepository() {
    }

    public static ReservationRepository getInstance() {
        if (reservationRepository == null) {
            reservationRepository = new ReservationRepository();
        }
        return reservationRepository;
    }

    public void add(Reservation reservation) {
        reservations.put(reservation.getReservationId(), reservation);
    }

    public Reservation findById(int reservationId) {
        return reservations.get(reservationId);
    }
}
