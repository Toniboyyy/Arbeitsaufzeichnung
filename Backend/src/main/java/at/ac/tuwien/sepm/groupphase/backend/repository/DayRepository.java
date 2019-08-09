package at.ac.tuwien.sepm.groupphase.backend.repository;

import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface DayRepository extends JpaRepository<Day, Long> {

    /**
     *
     * @param id to search in Database
     * @return day with id
     */
    Optional<Day> findOneById(Long id);




}
