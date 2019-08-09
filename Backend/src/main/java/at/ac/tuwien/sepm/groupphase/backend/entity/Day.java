package at.ac.tuwien.sepm.groupphase.backend.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_day_id")
    @SequenceGenerator(name = "seq_day_id", sequenceName = "seq_day_id")
    private Long id;

    @Column(nullable = false, name = "work_date")
    private LocalDateTime work_date;

    @Column(nullable = false)
    private LocalTime start_time;

    @Column(nullable = false)
    private LocalTime finish_time;

    @Column(nullable = false)
    @OneToMany
    private Set<ProjectTime> project_times;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getWork_date() {
        return work_date;
    }

    public void setWork_date(LocalDateTime work_date) {
        this.work_date = work_date;
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
}
