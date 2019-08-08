package com.example.demo.entity.mapper;


import com.example.demo.DTO.projectTimeDTO;
import com.example.demo.entity.projectTimeEntity;
import org.springframework.stereotype.Component;

@Component
public class TimeMapperImpl implements TimeMapper {


    @Override
    public projectTimeEntity projectTimeDTOToProjectTime(projectTimeDTO projectTimeDTO) {
        return null;
    }

    @Override
    public projectTimeDTO projectTimeToProjectTimeDTO(projectTimeEntity projectTimeEntity) {
        return null;
    }
}
