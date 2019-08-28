package at.ac.tuwien.sepm.groupphase.backend.endpoint;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.projectTime.ProjectTimeDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.ProjectTime;
import at.ac.tuwien.sepm.groupphase.backend.entity.mapper.projectTime.ProjectTimeMapper;
import at.ac.tuwien.sepm.groupphase.backend.exception.NotFoundException;
import at.ac.tuwien.sepm.groupphase.backend.exception.ValidationException;
import at.ac.tuwien.sepm.groupphase.backend.service.ProjectTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.Set;

@RestController
@RequestMapping(value = "/projectTime")
@Api(value = "projectTime")
public class ProjectTimeEndpoint {

    private final ProjectTimeService projectTimeService;
    private final ProjectTimeMapper projectTimeMapper;

    public ProjectTimeEndpoint(ProjectTimeService projectTimeService, ProjectTimeMapper projectTimeMapper) {
        this.projectTimeService = projectTimeService;
        this.projectTimeMapper = projectTimeMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get ProjectTimes by Day ID")
    public Set<ProjectTimeDTO> getProjectTimeByDayId(@RequestParam Long dayId, Principal principal){
        try {
            return projectTimeMapper.TimeListToTimeDto(projectTimeService.getByDayId(dayId, principal.getName()));
        }catch (ValidationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add ProjectTime", authorizations = {@Authorization(value = "apiKey")})
    public ProjectTimeDTO add(@RequestBody ProjectTimeDTO projectTimeDTO, Principal principal){
        try{
            return projectTimeMapper.TimeToTimeDto(projectTimeService.add(projectTimeMapper.TimeDtoToTime(projectTimeDTO), principal.getName()));
        }catch (ValidationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete ProjectTime")
    public void delete(@RequestParam Long id, Principal principal) {
        try {
            projectTimeService.delete(id, principal.getName());
        }catch (ValidationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
