package at.ac.tuwien.sepm.groupphase.backend.endpoint;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayDTO;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayFilterDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.mapper.day.DayMapper;
import at.ac.tuwien.sepm.groupphase.backend.exception.NotFoundException;
import at.ac.tuwien.sepm.groupphase.backend.exception.ValidationException;
import at.ac.tuwien.sepm.groupphase.backend.service.DayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.PersistenceException;
import java.security.Principal;
import java.util.Set;

@RestController
@RequestMapping(value = "/day")
@Api(value = "day")
public class DayEndpoint {

    private final DayService dayService;
    private final DayMapper dayMapper;

    public DayEndpoint(DayService dayService, DayMapper dayMapper, PasswordEncoder passwordEncoder) {
        this.dayService = dayService;
        this.dayMapper = dayMapper;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    @ApiOperation(value = "Get Days by Month and Year", authorizations = {@Authorization(value = "apiKey")})
    public Set<DayDTO> getByFilter(@RequestBody DayFilterDTO dayFilterDTO, Principal principal){
        try {
            return dayMapper.DayListToDayDtoSet(dayService.getByMonthAndYear(dayMapper.DayFilterDtoToDayFilter(dayFilterDTO), principal.getName()));
        }catch (ValidationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add Day", authorizations = {@Authorization(value = "apiKey")})
    public DayDTO add(@RequestBody DayDTO dayDTO, Principal principal){
        try{
            return dayMapper.DayToDayDto(dayService.add(dayMapper.DayDtoToDay(dayDTO), principal.getName()));
        }catch (ValidationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "Change Day", authorizations = {@Authorization(value = "apiKey")})
    public DayDTO change(@RequestBody DayDTO dayDTO, Principal principal){
        try {
            return dayMapper.DayToDayDto(dayService.change(dayMapper.DayDtoToDay(dayDTO), principal.getName()));
        }catch (ValidationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete Day", authorizations = {@Authorization(value = "apiKey")})
    public void delete(@RequestParam Long id, Principal principal) {
        try {
            dayService.delete(id, principal.getName());
        } catch (ValidationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get Day", authorizations = {@Authorization(value = "apiKey")})
    public DayDTO getById(@RequestParam Long dayId, Principal principal) {
        try {
            return dayMapper.DayToDayDto(dayService.getById(dayId, principal.getName()));
        } catch (ValidationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
