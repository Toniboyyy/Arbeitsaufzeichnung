package at.ac.tuwien.sepm.groupphase.backend.entity;

import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_day_id")
    @SequenceGenerator(name = "seq_day_id", sequenceName = "seq_day_id")
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @Column(nullable = false, name = "work_date")
    private LocalDate work_date;

    @Column(nullable = false)
    private LocalTime start_time;

    @Column(nullable = false)
    private LocalTime finish_time;

    @OneToMany(mappedBy = "day", fetch = FetchType.LAZY)
    private Set<ProjectTime> project_times;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getWork_date() {
        return work_date;
    }

    public void setWork_date(LocalDate work_date) {
        this.work_date = work_date;
    }

    public Set<ProjectTime> getProject_times() {
        return project_times;
    }

    public void setProject_times(Set<ProjectTime> project_times) {
        this.project_times = project_times;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
