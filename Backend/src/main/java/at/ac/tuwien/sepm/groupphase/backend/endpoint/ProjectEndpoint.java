package at.ac.tuwien.sepm.groupphase.backend.endpoint;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.project.ProjectDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.Project;
import at.ac.tuwien.sepm.groupphase.backend.entity.mapper.project.ProjectMapper;
import at.ac.tuwien.sepm.groupphase.backend.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@RestController
@RequestMapping(value = "/project")
@Api(value = "project")
public class ProjectEndpoint {

    private final ProjectService projectService;
    private final ProjectMapper projectMapper;

    public ProjectEndpoint(ProjectService projectService, ProjectMapper projectMapper) {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get Days by Month and Year", authorizations = {@Authorization(value = "apiKey")})
    public Set<ProjectDTO> getAll(){
        try {
            return projectMapper.ProjectListToProjectDtoSet(projectService.getAll());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
