package at.ac.tuwien.sepm.groupphase.backend.service;

import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import at.ac.tuwien.sepm.groupphase.backend.entity.ProjectTime;

import java.util.List;

public interface ProjectTimeService {

    /**
     * @param projectTime to be added to the db
     * @param username of the user which saves the ProjectTime in the db
     * @return the added ProjectTime with the id set
     */
    ProjectTime add(ProjectTime projectTime, String username);

    /**
     * @param projectTime to change
     * @param username of the user changing the ProjectTime
     * @return the changed projectTime
     */
    ProjectTime change(ProjectTime projectTime, String username);

    /**
     * @param id of the ProjectTime to delete
     * @param username of the user deleting the ProjectTime
     */
    void delete(Long id, String username);

    /**
     * @param id of the day containing the ProjectTime
     * @param username of the user requesting the ProjectTime
     * @return List of ProjectTimes of the specific day
     */
    List<ProjectTime> getByDayId(Long id, String username);
}
