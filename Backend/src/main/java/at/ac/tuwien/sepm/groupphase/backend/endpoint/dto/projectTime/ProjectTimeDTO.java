package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.projectTime;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayDTO;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.project.ProjectDTO;
import io.swagger.annotations.ApiModelProperty;

import java.security.Timestamp;
import java.time.LocalTime;

public class ProjectTimeDTO {

    @ApiModelProperty(readOnly = true, name = "The automatically generated database id")
    private Long id;

    private DayDTO day;

    private ProjectDTO project;

    private LocalTime start;

    private LocalTime finish;

    private Float working_hours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayDTO getDay() {
        return day;
    }

    public void setDay(DayDTO day) {
        this.day = day;
    }

    public ProjectDTO getProjectEntity() {
        return project;
    }

    public void setProjectEntity(ProjectDTO projectEntity) {
        this.project = projectEntity;
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
}
