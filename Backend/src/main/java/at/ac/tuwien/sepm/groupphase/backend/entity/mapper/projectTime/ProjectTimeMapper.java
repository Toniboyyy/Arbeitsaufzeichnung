package at.ac.tuwien.sepm.groupphase.backend.entity.mapper.projectTime;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.projectTime.ProjectTimeDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.ProjectTime;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface ProjectTimeMapper {

    ProjectTime TimeDtoToTime(ProjectTimeDTO projectTimeDTO);

    ProjectTimeDTO TimeToTimeDto(ProjectTime projectTime);

    Set<ProjectTimeDTO> TimeListToTimeDto (List<ProjectTime> projectTimesList);
}
