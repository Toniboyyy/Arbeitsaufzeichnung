package at.ac.tuwien.sepm.groupphase.backend.service;

import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import at.ac.tuwien.sepm.groupphase.backend.entity.ProjectTime;

import java.util.List;

public interface ProjectTimeService {

    ProjectTime add(ProjectTime projectTime,Long dayId, String username);

    ProjectTime change(ProjectTime projectTime, String username);

    void delete(Long id, String username);

    List<ProjectTime> getByDayId(Long id, String username);
}
