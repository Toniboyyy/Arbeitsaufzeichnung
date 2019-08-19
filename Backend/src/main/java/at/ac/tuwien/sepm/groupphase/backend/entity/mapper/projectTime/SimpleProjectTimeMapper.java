package at.ac.tuwien.sepm.groupphase.backend.entity.mapper.projectTime;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.projectTime.ProjectTimeDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.ProjectTime;
import at.ac.tuwien.sepm.groupphase.backend.entity.mapper.day.DayMapper;
import at.ac.tuwien.sepm.groupphase.backend.entity.mapper.project.ProjectMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SimpleProjectTimeMapper implements ProjectTimeMapper {

    private final DayMapper dayMapper;
    private final ProjectMapper projectMapper;

    public SimpleProjectTimeMapper(DayMapper dayMapper, ProjectMapper projectMapper) {
        this.dayMapper = dayMapper;
        this.projectMapper = projectMapper;
    }


    @Override
    public ProjectTime TimeDtoToTime(ProjectTimeDTO projectTimeDTO) {
        ProjectTime projectTime = new ProjectTime();
        projectTime.setId(projectTimeDTO.getId());
        projectTime.setDay(dayMapper.DayDtoToDay(projectTimeDTO.getDay()));
        projectTime.setStart_time(projectTimeDTO.getStart());
        projectTime.setFinish_time(projectTimeDTO.getFinish());
        projectTime.setProject(projectMapper.ProjectDtoToProject(projectTimeDTO.getProjectEntity()));
        return projectTime;
    }

    @Override
    public ProjectTimeDTO TimeToTimeDto(ProjectTime projectTime) {
        ProjectTimeDTO projectTimeDTO = new ProjectTimeDTO();
        projectTimeDTO.setId(projectTime.getId());
        projectTimeDTO.setDay(dayMapper.DayToDayDto(projectTime.getDay()));
        projectTimeDTO.setFinish(projectTime.getFinish_time());
        projectTimeDTO.setStart(projectTime.getStart_time());
        projectTimeDTO.setProjectEntity(projectMapper.ProjectToProjectDto(projectTime.getProject()));
        float hours = (float) projectTime.getFinish_time().getHour() - projectTime.getStart_time().getHour();
        hours += (float) (projectTime.getFinish_time().getMinute() - projectTime.getStart_time().getMinute())/60;
        projectTimeDTO.setWorking_hours(hours);
        return projectTimeDTO;
    }

    @Override
    public Set<ProjectTimeDTO> TimeListToTimeDto(List<ProjectTime> projectTimesList) {
        Set<ProjectTimeDTO> projectTimeDTOSet = new HashSet<>();
        for(ProjectTime projectTime: projectTimesList){
            projectTimeDTOSet.add(TimeToTimeDto(projectTime));
        }
        return projectTimeDTOSet;
    }
}
