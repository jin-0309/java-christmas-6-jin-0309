package christmas.model;

import java.time.LocalDate;
import java.util.Map;

public record Reservation(int reservationId, int userId, Map<Integer, Integer> orders,
                          LocalDate reservationDate) {
}
