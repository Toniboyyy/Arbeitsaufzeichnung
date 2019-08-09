package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day;

import java.time.LocalDate;
import java.util.Date;

public class DayFilterDTO {

    private Date dates;

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
}
