package at.ac.tuwien.sepm.groupphase.backend.service;

import at.ac.tuwien.sepm.groupphase.backend.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAll();

    List<Project> getByFilter(Long projectNr);

    Project create(Project project);
}
