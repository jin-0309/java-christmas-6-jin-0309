package christmas.utils;

import java.time.LocalDate;

public enum StarDateInfo {
    DAY_3(LocalDate.of(2023, 12, 3)),
    DAY_10(LocalDate.of(2023, 12, 10)),
    DAY_17(LocalDate.of(2023, 12, 17)),
    DAY_24(LocalDate.of(2023, 12, 24)),
    DAY_25(LocalDate.of(2023, 12, 25)),
    DAY_31(LocalDate.of(2023, 12, 31));

    private final LocalDate date;

    StarDateInfo(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return this.date;
    }
}
