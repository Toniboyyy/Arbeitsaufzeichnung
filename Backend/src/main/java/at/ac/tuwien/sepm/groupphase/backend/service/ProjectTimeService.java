package at.ac.tuwien.sepm.groupphase.backend.service;

import at.ac.tuwien.sepm.groupphase.backend.entity.Day;

public interface ProjectTimeService {

    Day add(Day day);

    Day change(Day day);

    void  delete(Long id);
}
