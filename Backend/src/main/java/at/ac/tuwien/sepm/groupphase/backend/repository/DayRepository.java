package at.ac.tuwien.sepm.groupphase.backend.repository;

import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import at.ac.tuwien.sepm.groupphase.backend.entity.DayFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

    /**
     *
     * @param id to search in Database
     * @return day with id
     */
    Optional<Day> findOneById(Long id);


    @Transactional
    @Modifying
    @Query("DELETE FROM Day d WHERE d.id = ?1")
    void deleteById(Long id, String username);


    @Query("SELECT d from Day d JOIN User u ON d.user.id = u.id WHERE d.work_date >= ?1 AND d.work_date < ?2 AND u.username = ?3")
    List<Day> getAllByMonthAndYear(LocalDate start_date, LocalDate end_date, String username);

    @Query("SELECT d FROM Day d JOIN User u ON d.user.id = u.id WHERE d.id = ?1 AND u.username = ?2")
    Optional<Day> getByIdAndUser(Long id, String username);
}
