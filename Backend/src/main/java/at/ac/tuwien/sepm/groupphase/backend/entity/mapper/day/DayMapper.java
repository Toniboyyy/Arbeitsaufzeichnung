package at.ac.tuwien.sepm.groupphase.backend.entity.mapper.day;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayDTO;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayFilterDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import at.ac.tuwien.sepm.groupphase.backend.entity.DayFilter;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Mapper
public interface DayMapper {

    Day DayDtoToDay (DayDTO dayDTO);

    DayDTO DayToDayDto (Day day);

    Set<DayDTO> DayListToDayDtoSet (List<Day> dayList);

    DayFilter DayFilterDtoToDayFilter(DayFilterDTO dayFilterDTO);
}
