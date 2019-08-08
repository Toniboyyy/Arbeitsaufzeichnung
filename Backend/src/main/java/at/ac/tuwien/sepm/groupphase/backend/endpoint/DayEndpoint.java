package at.ac.tuwien.sepm.groupphase.backend.endpoint;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/day")
@Api(value = "day")
public class DayEndpoint {

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add Day")
    public DayDTO add(@RequestBody DayDTO dayDTO){
        return dayDTO;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "Change Day")
    public DayDTO change(@RequestBody DayDTO dayDTO){
        return dayDTO;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete Day")
    public void delete(Long id){

    }
}
