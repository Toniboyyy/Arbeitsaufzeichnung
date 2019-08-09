package at.ac.tuwien.sepm.groupphase.backend.repository;

import at.ac.tuwien.sepm.groupphase.backend.entity.ProjectTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectTimeRepository extends JpaRepository<ProjectTime, Long> {
}
