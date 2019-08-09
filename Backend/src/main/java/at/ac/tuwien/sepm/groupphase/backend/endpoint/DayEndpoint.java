package at.ac.tuwien.sepm.groupphase.backend.endpoint;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayDTO;
import at.ac.tuwien.sepm.groupphase.backend.service.DayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/day")
@Api(value = "day")
public class DayEndpoint {

    private DayService dayService;

    public DayEndpoint(DayService dayService) {
        this.dayService = dayService;
    }
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get Days by Month and Year")
    public Set<DayDTO> getByFilter(@RequestParam Long month, @RequestParam Long year){
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add Day")
    public DayDTO add(@RequestBody DayDTO dayDTO){
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "Change Day")
    public DayDTO change(@RequestBody DayDTO dayDTO){
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete Day")
    public void delete(Long id){
        dayService.delete(id);
    }
}
