package christmas.model;

import java.time.LocalDate;
import java.util.Map;

public record Reservation(int userId, Map<Integer, Integer> menuWithQuantities, LocalDate reservationDate) {
}
