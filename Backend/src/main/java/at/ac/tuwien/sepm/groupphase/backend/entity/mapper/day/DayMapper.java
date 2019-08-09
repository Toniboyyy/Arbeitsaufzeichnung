package at.ac.tuwien.sepm.groupphase.backend.entity.mapper.day;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface DayMapper {

    Day DayDtoToDay (DayDTO dayDTO);

    DayDTO DayToDayDto (Day day);

    Set<DayDTO> DaySetToDayDto (List<Day> dayList);
}
