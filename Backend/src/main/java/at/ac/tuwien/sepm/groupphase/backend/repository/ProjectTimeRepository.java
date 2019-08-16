package at.ac.tuwien.sepm.groupphase.backend.repository;

import at.ac.tuwien.sepm.groupphase.backend.entity.ProjectTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProjectTimeRepository extends JpaRepository<ProjectTime, Long> {

    @Query("SELECT p FROM ProjectTime p JOIN Day d ON p.day.id = d.id JOIN User u ON u.id = d.user.id WHERE d.id = ?1 AND u.username = ?2")
    List<ProjectTime> getProjectsByDayId(Long id, String user);
}
