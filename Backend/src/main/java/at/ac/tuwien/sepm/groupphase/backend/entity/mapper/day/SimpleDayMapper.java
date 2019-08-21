package at.ac.tuwien.sepm.groupphase.backend.entity.mapper.day;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayDTO;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.day.DayFilterDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import at.ac.tuwien.sepm.groupphase.backend.entity.DayFilter;
import at.ac.tuwien.sepm.groupphase.backend.entity.ProjectTime;
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
        day.setWork_date(dayDTO.getDates());
        return day;
    }

    @Override
    public DayDTO DayToDayDto(Day day) {
        DayDTO dayDTO = new DayDTO();
        dayDTO.setId(day.getId());
        dayDTO.setDates(day.getWork_date());
        float project_hours = 0f;
        for(ProjectTime projectTime: day.getProject_times()){
            project_hours += (float) projectTime.getFinish_time().getHour() - projectTime.getStart_time().getHour();
            project_hours += (float)  (projectTime.getFinish_time().getMinute() - projectTime.getStart_time().getMinute())/60;
        }
        dayDTO.setProject_hours(project_hours);
        dayDTO.setProject_amount(day.getProject_times().size());
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
