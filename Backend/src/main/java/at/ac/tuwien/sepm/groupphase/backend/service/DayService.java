package at.ac.tuwien.sepm.groupphase.backend.service;

import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import at.ac.tuwien.sepm.groupphase.backend.entity.DayFilter;

import java.util.List;
import java.util.Set;

public interface DayService {

    Day add(Day day, String username);

    Day change(Day day, String username);

    void delete(Long id, String username);

    List<Day> getByMonthAndYear(DayFilter dayFilter, String username);

    Day getById(Long id, String username);
}
