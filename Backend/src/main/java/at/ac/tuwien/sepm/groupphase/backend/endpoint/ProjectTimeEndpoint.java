package at.ac.tuwien.sepm.groupphase.backend.endpoint;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.projectTime.ProjectTimeDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.ProjectTime;
import at.ac.tuwien.sepm.groupphase.backend.service.ProjectTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/projects")
@Api(value = "projects")
public class ProjectTimeEndpoint {

    private ProjectTimeService projectTimeService;

    public ProjectTimeEndpoint(ProjectTimeService projectTimeService) {
        this.projectTimeService = projectTimeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get ProjectTimes by Day ID")
    public Set<ProjectTimeDTO> getByFilter(@RequestParam Long dayid){
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add ProjectTime")
    public ProjectTimeDTO add(@RequestBody ProjectTime projectTime, @RequestParam Long dayId){
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "Change ProjectTime")
    public ProjectTimeDTO change(@RequestBody ProjectTime projectTime){
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete ProjectTime")
    public void delete(Long id){
        projectTimeService.delete(id);
    }
}
