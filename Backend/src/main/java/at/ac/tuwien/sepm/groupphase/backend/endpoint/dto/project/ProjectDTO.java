package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.project;

import io.swagger.annotations.ApiModelProperty;

public class ProjectDTO {

    @ApiModelProperty(readOnly = true, name = "The automatically generated database id")
    private Long id;

    private Long projectId;

    private String name;

    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
