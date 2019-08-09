package at.ac.tuwien.sepm.groupphase.backend.entity;

import java.time.LocalDate;

public class DayFilter {

    private LocalDate dates;

    public LocalDate getDates() {
        return dates;
    }

    public void setDates(LocalDate dates) {
        this.dates = dates;
    }
}
