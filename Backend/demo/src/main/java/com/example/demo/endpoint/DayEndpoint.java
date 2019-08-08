package com.example.demo.endpoint;


import com.example.demo.DTO.dayDTO;
import com.example.demo.entity.mapper.DayMapper;
import com.example.demo.service.DayServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/day")
public class DayEndpoint {


    private final DayServiceInterface dayServiceInterface;
    private final DayMapper dayMapper;

    @Autowired
    public DayEndpoint(DayServiceInterface dayServiceInterface, DayMapper dayMapper) {
        this.dayServiceInterface = dayServiceInterface;
        this.dayMapper = dayMapper;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public dayDTO createDay(@RequestBody dayDTO dayDTO){
        return dayMapper.DayToDayDTO(dayServiceInterface.create(dayMapper.DayDTOToDay(dayDTO)));
    }

    @RequestMapping(value = "/change", method = RequestMethod.PUT)
    public dayDTO changeDay(@RequestBody dayDTO dayDTO){
        return dayMapper.DayToDayDTO(dayServiceInterface.change(dayMapper.DayDTOToDay(dayDTO)));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteDay(@RequestParam Long id){
        dayServiceInterface.delete(id);
    }

}
