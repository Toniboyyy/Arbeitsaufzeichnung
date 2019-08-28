package at.ac.tuwien.sepm.groupphase.backend.endpoint;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.project.ProjectDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.Project;
import at.ac.tuwien.sepm.groupphase.backend.entity.mapper.project.ProjectMapper;
import at.ac.tuwien.sepm.groupphase.backend.exception.ValidationException;
import at.ac.tuwien.sepm.groupphase.backend.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
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
    @ApiOperation(value = "Get all Projects", authorizations = {@Authorization(value = "apiKey")})
    public Set<ProjectDTO> getAll(){
        try {
            return projectMapper.ProjectListToProjectDtoSet(projectService.getAll());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "Get all Projects by project number", authorizations = {@Authorization(value = "apiKey")})
    public Set<ProjectDTO> getByFilter(@RequestParam Long projectNr){
        try {
            return projectMapper.ProjectListToProjectDtoSet(projectService.getByFilter(projectNr));
        } catch (ValidationException e){
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Create a Project", authorizations = {@Authorization(value = "apiKey")})
    public ProjectDTO create(@RequestBody ProjectDTO projectDTO){
        try {
            return projectMapper.ProjectToProjectDto(projectService.create(projectMapper.ProjectDtoToProject(projectDTO)));
        }catch (ValidationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
