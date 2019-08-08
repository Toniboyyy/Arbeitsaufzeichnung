package com.example.demo.entity.mapper;


import com.example.demo.DTO.dayDTO;
import com.example.demo.entity.dayEntity;
import org.springframework.stereotype.Component;

@Component
public class DayMapperImpl implements DayMapper {
    @Override
    public dayDTO DayToDayDTO(dayEntity dayEntity) {
        return null;
    }

    @Override
    public dayEntity DayDTOToDay(dayDTO dayDTO) {
        return null;
    }
}
