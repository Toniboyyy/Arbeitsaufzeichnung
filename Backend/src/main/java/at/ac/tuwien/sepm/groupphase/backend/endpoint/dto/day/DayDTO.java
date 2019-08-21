package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@ApiModel(value = "SimpleDayDTO", description = "DTO to save a day")
public class DayDTO {

    @ApiModelProperty(readOnly = true, name = "The automatically generated database id")
    private Long id;

    private LocalDate dates;

    private Float project_hours;

    private int project_amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDates() {
        return dates;
    }

    public void setDates(LocalDate dates) {
        this.dates = dates;
    }


    public Float getProject_hours() {
        return project_hours;
    }

    public void setProject_hours(Float project_hours) {
        this.project_hours = project_hours;
    }

    public int getProject_amount() {
        return project_amount;
    }

    public void setProject_amount(int project_amount) {
        this.project_amount = project_amount;
    }
}
