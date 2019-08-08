package com.example.demo.entity;


import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class projectEntity {

    private Long id;

    private Long projectId;

    private String projectName;

    private String projectDesc;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        projectEntity projectEntity = (projectEntity) o;
        return Objects.equals(id, projectEntity.id) &&
                Objects.equals(projectId, projectEntity.projectId) &&
                Objects.equals(projectName, projectEntity.projectName) &&
                Objects.equals(projectDesc, projectEntity.projectDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, projectName, projectDesc);
    }

    @Override
    public String toString() {
        return "project{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectDesc='" + projectDesc + '\'' +
                '}';
    }
}
