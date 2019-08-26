package at.ac.tuwien.sepm.groupphase.backend.entity;

import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
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

    @OneToMany(mappedBy = "day", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProjectTime> project_times = new HashSet<>();


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


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return Objects.equals(id, day.id) &&
            Objects.equals(user, day.user) &&
            Objects.equals(work_date, day.work_date) &&
            Objects.equals(project_times, day.project_times);
    }

    @Override
    public String toString() {
        return "Day{" +
            "id=" + id +
            ", user=" + user +
            ", work_date=" + work_date +
            ", project_times=" + project_times +
            '}';
    }
}
