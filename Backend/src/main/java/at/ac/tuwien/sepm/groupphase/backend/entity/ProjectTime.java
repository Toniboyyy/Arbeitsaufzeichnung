package at.ac.tuwien.sepm.groupphase.backend.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class ProjectTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_projectTime_id")
    @SequenceGenerator(name = "seq_projectTime_id", sequenceName = "seq_projectTime_id")
    private Long id;

    @Column(nullable = false)
    private LocalTime start_time;

    @Column(nullable = false)
    private LocalTime finish_time;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Day day;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(LocalTime finish_time) {
        this.finish_time = finish_time;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectTime that = (ProjectTime) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(start_time, that.start_time) &&
            Objects.equals(finish_time, that.finish_time) &&
            Objects.equals(project, that.project) &&
            Objects.equals(day, that.day);
    }

    @Override
    public String toString() {
        return "ProjectTime{" +
            "id=" + id +
            ", start_time=" + start_time +
            ", finish_time=" + finish_time +
            ", project=" + project +
            ", day=" + day +
            '}';
    }
}
