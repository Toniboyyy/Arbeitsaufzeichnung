package at.ac.tuwien.sepm.groupphase.backend.entity.mapper.project;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.project.ProjectDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.Project;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SimpleProjectMapper implements ProjectMapper {
    @Override
    public Project ProjectDtoToProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setId(projectDTO.getId());
        project.setProject_id(projectDTO.getProjectId());
        project.setProject_desc(projectDTO.getDesc());
        project.setProject_name(projectDTO.getName());
        return project;
    }

    @Override
    public ProjectDTO ProjectToProjectDto(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setProjectId(project.getProject_id());
        projectDTO.setDesc(project.getProject_desc());
        projectDTO.setName(project.getProject_name());
        return projectDTO;
    }

    @Override
    public Set<ProjectDTO> ProjectListToProjectDtoSet(List<Project> list) {
        Set<ProjectDTO> projectDTOSet = new HashSet<>();
        for (Project project: list){
            projectDTOSet.add(ProjectToProjectDto(project));
        }
        return projectDTOSet;
    }
}
