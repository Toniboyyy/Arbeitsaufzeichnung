package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.security.Timestamp;
import java.time.LocalDateTime;

@ApiModel(value = "SimpleDayDTO", description = "DTO to save a day")
public class DayDTO {

    @ApiModelProperty(readOnly = true, name = "The automatically generated database id")
    private Long id;

    private LocalDateTime date;

    private Timestamp start;

    private Timestamp finish;

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

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getFinish() {
        return finish;
    }

    public void setFinish(Timestamp finish) {
        this.finish = finish;
    }
}
