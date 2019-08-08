package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.projectTime;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayDTO;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.project.ProjectDTO;
import io.swagger.annotations.ApiModelProperty;

import java.security.Timestamp;

public class ProjectTimeDTO {

    @ApiModelProperty(readOnly = true, name = "The automatically generated database id")
    private Long id;

    private DayDTO day;

    private ProjectDTO projectEntity;

    private Timestamp start;

    private Timestamp finish;

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
        return projectEntity;
    }

    public void setProjectEntity(ProjectDTO projectEntity) {
        this.projectEntity = projectEntity;
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
