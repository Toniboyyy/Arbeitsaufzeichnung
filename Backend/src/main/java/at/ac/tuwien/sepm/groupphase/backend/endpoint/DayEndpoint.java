package at.ac.tuwien.sepm.groupphase.backend.endpoint;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayDTO;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayFilterDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.mapper.day.DayMapper;
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
    private DayMapper dayMapper;

    public DayEndpoint(DayService dayService) {
        this.dayService = dayService;
    }
    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    @ApiOperation(value = "Get Days by Month and Year", authorizations = {@Authorization(value = "apiKey")})
    public Set<DayDTO> getByFilter(@RequestBody DayFilterDTO dayFilterDTO){
        return dayMapper.DayListToDayDtoSet(dayService.getByMonthAndYear(dayMapper.DayFilterDtoToDayFilter(dayFilterDTO)));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add Day", authorizations = {@Authorization(value = "apiKey")})
    public DayDTO add(@RequestBody DayDTO dayDTO){
        return dayMapper.DayToDayDto(dayService.add(dayMapper.DayDtoToDay(dayDTO)));
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "Change Day", authorizations = {@Authorization(value = "apiKey")})
    public DayDTO change(@RequestBody DayDTO dayDTO){
        return dayMapper.DayToDayDto(dayService.change(dayMapper.DayDtoToDay(dayDTO)));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete Day", authorizations = {@Authorization(value = "apiKey")})
    public void delete(Long id){
        dayService.delete(id);
    }
}
