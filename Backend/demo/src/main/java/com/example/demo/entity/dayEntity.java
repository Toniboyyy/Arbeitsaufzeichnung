package com.example.demo.entity;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class dayEntity {

    private Long id;

    private LocalDateTime date;

    private Timestamp start;

    private Timestamp finish;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        dayEntity day = (dayEntity) o;
        return id == day.id &&
                Objects.equals(date, day.date) &&
                Objects.equals(start, day.start) &&
                Objects.equals(finish, day.finish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, start, finish);
    }

    @Override
    public String toString() {
        return "day{" +
                "id=" + id +
                ", date=" + date +
                ", start=" + start +
                ", finish=" + finish +
                '}';
    }
}
