package at.ac.tuwien.sepm.groupphase.backend.entity.mapper.project;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.project.ProjectDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.Project;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface ProjectMapper {

    Project ProjectDtoToProject(ProjectDTO projectDTO);

    ProjectDTO ProjectToProjectDto(Project project);

    Set<ProjectDTO> ProjectListToProjectDtoSet(List<Project> list);
}
