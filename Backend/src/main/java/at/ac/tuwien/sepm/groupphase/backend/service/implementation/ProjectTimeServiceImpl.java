package at.ac.tuwien.sepm.groupphase.backend.service.implementation;

import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import at.ac.tuwien.sepm.groupphase.backend.service.ProjectTimeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTimeServiceImpl implements ProjectTimeService {
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
    public List<Day> getByDayId(Long id) {
        return null;
    }
}
