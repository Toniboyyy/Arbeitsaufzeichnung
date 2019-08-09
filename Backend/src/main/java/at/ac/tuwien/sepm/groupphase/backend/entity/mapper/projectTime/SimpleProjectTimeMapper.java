package at.ac.tuwien.sepm.groupphase.backend.entity.mapper.projectTime;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.projectTime.ProjectTimeDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.ProjectTime;

import java.util.List;
import java.util.Set;

public class SimpleProjectTimeMapper implements ProjectTimeMapper {
    @Override
    public ProjectTime TimeDtoToTime(ProjectTimeDTO projectTimeDTO) {
        return null;
    }

    @Override
    public ProjectTimeDTO TimeToTimeDto(ProjectTime projectTime) {
        return null;
    }

    @Override
    public Set<ProjectTimeDTO> TimeListToTimeDto(List<ProjectTime> projectTimesList) {
        return null;
    }
}
