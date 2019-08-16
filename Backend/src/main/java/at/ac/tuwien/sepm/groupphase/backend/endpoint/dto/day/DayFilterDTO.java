package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day;

import java.time.LocalDate;
import java.util.Date;

public class DayFilterDTO {

    private LocalDate dates;

    public LocalDate getDates() {
        return dates;
    }

    public void setDates(LocalDate dates) {
        this.dates = dates;
    }
}
