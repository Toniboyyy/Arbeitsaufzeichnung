package at.ac.tuwien.sepm.groupphase.backend.service.implementation;

import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import at.ac.tuwien.sepm.groupphase.backend.entity.DayFilter;
import at.ac.tuwien.sepm.groupphase.backend.service.DayService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DayServiceImpl implements DayService {


    @Override
    public Day add(Day day) {
        return null;
    }

    @Override
    public Day change(Day day) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Day> getByMonthAndYear(DayFilter dayFilter) {
        return null;
    }
}
