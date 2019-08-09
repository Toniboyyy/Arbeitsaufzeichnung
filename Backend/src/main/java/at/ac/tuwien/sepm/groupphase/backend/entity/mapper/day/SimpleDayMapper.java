package at.ac.tuwien.sepm.groupphase.backend.entity.mapper.day;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayDTO;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayFilterDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import at.ac.tuwien.sepm.groupphase.backend.entity.DayFilter;

import java.util.List;
import java.util.Set;

public class SimpleDayMapper implements DayMapper {
    @Override
    public Day DayDtoToDay(DayDTO dayDTO) {
        return null;
    }

    @Override
    public DayDTO DayToDayDto(Day day) {
        return null;
    }

    @Override
    public Set<DayDTO> DayListToDayDtoSet(List<Day> dayList) {
        return null;
    }

    @Override
    public DayFilter DayFilterDtoToDayFilter(DayFilterDTO dayFilterDTO) {
        return null;
    }
}
