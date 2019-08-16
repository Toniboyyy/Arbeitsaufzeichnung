package at.ac.tuwien.sepm.groupphase.backend.entity.mapper.day;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayDTO;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayFilterDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import at.ac.tuwien.sepm.groupphase.backend.entity.DayFilter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SimpleDayMapper implements DayMapper {
    @Override
    public Day DayDtoToDay(DayDTO dayDTO) {
        Day day = new Day();
        day.setId(dayDTO.getId());
        day.setStart_time(dayDTO.getStart());
        day.setFinish_time(dayDTO.getFinish());
        day.setWork_date(dayDTO.getDates());
        return day;
    }

    @Override
    public DayDTO DayToDayDto(Day day) {
        DayDTO dayDTO = new DayDTO();
        dayDTO.setId(day.getId());
        dayDTO.setDates(day.getWork_date());
        dayDTO.setStart(day.getStart_time());
        dayDTO.setFinish(day.getFinish_time());
        float hours = (float) day.getFinish_time().getHour() - day.getStart_time().getHour();
        hours += (float) (day.getFinish_time().getMinute() - day.getStart_time().getMinute())/60;
        dayDTO.setWorking_hours(hours);
        return dayDTO;
    }

    @Override
    public Set<DayDTO> DayListToDayDtoSet(List<Day> dayList) {
        Set<DayDTO> dayDTOSet = new HashSet<>();
        for (Day day: dayList){
            dayDTOSet.add(DayToDayDto(day));
        }
        return dayDTOSet;
    }

    @Override
    public DayFilter DayFilterDtoToDayFilter(DayFilterDTO dayFilterDTO) {
        DayFilter dayFilter = new DayFilter();
        dayFilter.setDates(dayFilterDTO.getDates());
        return dayFilter;
    }
}
