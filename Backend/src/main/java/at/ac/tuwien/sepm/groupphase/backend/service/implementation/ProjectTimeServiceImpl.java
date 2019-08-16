package at.ac.tuwien.sepm.groupphase.backend.service.implementation;

import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import at.ac.tuwien.sepm.groupphase.backend.entity.ProjectTime;
import at.ac.tuwien.sepm.groupphase.backend.exception.ValidationException;
import at.ac.tuwien.sepm.groupphase.backend.repository.DayRepository;
import at.ac.tuwien.sepm.groupphase.backend.repository.ProjectTimeRepository;
import at.ac.tuwien.sepm.groupphase.backend.service.ProjectTimeService;
import at.ac.tuwien.sepm.groupphase.backend.validator.Implementation.Validator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectTimeServiceImpl implements ProjectTimeService {

    private final ProjectTimeRepository projectTimeRepository;
    private final DayRepository dayRepository;
    private final Validator<ProjectTime> projectTimeValidator;

    public ProjectTimeServiceImpl(ProjectTimeRepository projectTimeRepository, DayRepository dayRepository, Validator<ProjectTime> projectTimeValidator) {
        this.projectTimeRepository = projectTimeRepository;
        this.dayRepository = dayRepository;
        this.projectTimeValidator = projectTimeValidator;
    }

    @Override
    public ProjectTime add(ProjectTime projectTime, Long dayId, String username) {
        projectTimeValidator.validate(projectTime);
        if(dayId < 0){
            throw new ValidationException("Id can't be negativ.");
        }
        Optional<Day> dayOptional = dayRepository.findOneById(dayId);
        Day day = dayOptional.get();
        projectTime.setDay(day);
        return projectTimeRepository.save(projectTime);
    }

    @Override
    public ProjectTime change(ProjectTime projectTime, String username) {
        if(projectTime.getId() < 0){
            throw new ValidationException("Id can't be negativ.");
        }
        return projectTimeRepository.save(projectTime);
    }

    @Override
    public void delete(Long id, String username) {
        if(id < 0){
            throw new ValidationException("Id can't be negativ.");
        }
        projectTimeRepository.deleteById(id);
    }

    @Override
    public List<ProjectTime> getByDayId(Long id, String username) {
        if(id < 0){
            throw new ValidationException("Id can't be negativ.");
        }
        return projectTimeRepository.getProjectsByDayId(id, username);
    }
}
