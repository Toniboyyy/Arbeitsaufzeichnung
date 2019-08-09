package at.ac.tuwien.sepm.groupphase.backend.service;

import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import at.ac.tuwien.sepm.groupphase.backend.entity.DayFilter;

import java.util.List;
import java.util.Set;

public interface DayService {

    Day add(Day day);

    Day change(Day day);

    void delete(Long id);

    List<Day> getByMonthAndYear(DayFilter dayFilter);
}
