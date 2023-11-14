package christmas.utils;

import java.time.LocalDate;

public enum DateInfo {
    DAY_BY_DAY_FIRST_DAY(LocalDate.of(2023, 12, 1)),
    DAY_BY_DAY_LAST_DAY(LocalDate.of(2023, 12, 25));

    private final LocalDate date;

    DateInfo(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return this.date;
    }

}
