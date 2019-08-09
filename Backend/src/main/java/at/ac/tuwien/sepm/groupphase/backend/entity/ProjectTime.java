package at.ac.tuwien.sepm.groupphase.backend.entity;

import javax.persistence.*;
import java.time.LocalTime;

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

    @OneToOne(cascade = CascadeType.ALL)
    private Project project;

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
}
