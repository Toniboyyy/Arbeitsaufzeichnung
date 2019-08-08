package com.example.demo.entity.mapper;

import com.example.demo.DTO.dayDTO;
import com.example.demo.entity.dayEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DayMapper {

    dayDTO DayToDayDTO(dayEntity dayEntity);

    dayEntity DayDTOToDay(dayDTO dayDTO);
}
