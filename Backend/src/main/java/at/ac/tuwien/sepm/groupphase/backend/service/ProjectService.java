package at.ac.tuwien.sepm.groupphase.backend.service;

import at.ac.tuwien.sepm.groupphase.backend.entity.Project;

import java.util.List;

public interface ProjectService {

    /**
     * @return List of all Projects
     */
    List<Project> getAll();

    /**
     * @param projectNr get a specific project by projectNr
     * @return the specific project
     */
    List<Project> getByFilter(Long projectNr);

    /**
     * @param project to be added to the db
     * @return the project with a set id
     */
    Project create(Project project);
}
