package com.example.demo.entity.mapper;

import com.example.demo.DTO.projectTimeDTO;
import com.example.demo.entity.projectTimeEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeMapper {

    projectTimeEntity projectTimeDTOToProjectTime(projectTimeDTO projectTimeDTO);

    projectTimeDTO projectTimeToProjectTimeDTO(projectTimeEntity projectTimeEntity);
}
