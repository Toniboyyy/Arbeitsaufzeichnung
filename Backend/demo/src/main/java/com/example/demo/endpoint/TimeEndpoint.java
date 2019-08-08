package com.example.demo.endpoint;

import com.example.demo.DTO.dayDTO;
import com.example.demo.DTO.projectTimeDTO;
import com.example.demo.entity.mapper.TimeMapper;
import com.example.demo.service.TimeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/time")
public class TimeEndpoint {


    private final TimeServiceInterface timeServiceInterface;
    private final TimeMapper timeMapper;

    @Autowired
    public TimeEndpoint(TimeServiceInterface timeServiceInterface, TimeMapper timeMapper) {
        this.timeServiceInterface = timeServiceInterface;
        this.timeMapper = timeMapper;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public projectTimeDTO createTime(@RequestBody projectTimeDTO projectTimeDTO){
        return timeMapper.projectTimeToProjectTimeDTO(timeServiceInterface.create(timeMapper.projectTimeDTOToProjectTime(projectTimeDTO)));
    }

    @RequestMapping(value = "/change", method = RequestMethod.PUT)
    public projectTimeDTO changeTime(@RequestBody projectTimeDTO projectTimeDTO){
        return timeMapper.projectTimeToProjectTimeDTO(timeServiceInterface.change(timeMapper.projectTimeDTOToProjectTime(projectTimeDTO)));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteTime(@RequestParam Long id){
        timeServiceInterface.delete(id);
    }

}
