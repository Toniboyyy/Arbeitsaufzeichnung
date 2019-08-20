package at.ac.tuwien.sepm.groupphase.backend.service.implementation;

import at.ac.tuwien.sepm.groupphase.backend.entity.Project;
import at.ac.tuwien.sepm.groupphase.backend.exception.ValidationException;
import at.ac.tuwien.sepm.groupphase.backend.service.ProjectService;
import at.ac.tuwien.sepm.groupphase.backend.repository.ProjectRepository;
import at.ac.tuwien.sepm.groupphase.backend.validator.Implementation.Validator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final Validator<Project> projectValidator;

    public ProjectServiceImpl(ProjectRepository projectRepository, Validator<Project> projectValidator) {
        this.projectRepository = projectRepository;
        this.projectValidator = projectValidator;
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    @Override
    public List<Project> getByFilter(Long projectNr) {
        if(projectNr < 0){
            throw new ValidationException("Project number can't be negativ");
        }
        return projectRepository.getByFilter(projectNr);
    }

    @Override
    public Project create(Project project) {
        projectValidator.validate(project);
        return projectRepository.save(project);
    }
}
