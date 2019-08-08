package com.example.demo.entity;

import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity
public class projectTimeEntity {

    private Long id;

    private dayEntity day;

    private projectEntity projectEntity;

    private Timestamp start;

    private Timestamp finish;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public dayEntity getDay() {
        return day;
    }

    public void setDay(dayEntity day) {
        this.day = day;
    }

    public projectEntity getProjectEntity() {
        return projectEntity;
    }

    public void setProjectEntity(projectEntity projectEntity) {
        this.projectEntity = projectEntity;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return finish;
    }

    public void setEnd(Timestamp end) {
        this.finish = end;
    }

    @Override
    public String toString() {
        return "projectTimeEntity{" +
                "id=" + id +
                ", day=" + day +
                ", projectEntity=" + projectEntity +
                ", start=" + start +
                ", end=" + finish +
                '}';
    }
}
