package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

@ApiModel(value = "SimpleDayDTO", description = "DTO to save a day")
public class DayDTO {

    @ApiModelProperty(readOnly = true, name = "The automatically generated database id")
    private Long id;

    private LocalDateTime date;

    private LocalTime start;

    private LocalTime finish;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
}
