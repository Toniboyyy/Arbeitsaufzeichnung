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

    private LocalTime start;

    private LocalTime finish;

    private Float working_hours;

    private Float project_hours;

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

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getFinish() {
        return finish;
    }

    public void setFinish(LocalTime finish) {
        this.finish = finish;
    }

    public Float getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(Float working_hours) {
        this.working_hours = working_hours;
    }

    public Float getProject_hours() {
        return project_hours;
    }

    public void setProject_hours(Float project_hours) {
        this.project_hours = project_hours;
    }
}
