package at.ac.tuwien.sepm.groupphase.backend.validator.Implementation;

import at.ac.tuwien.sepm.groupphase.backend.entity.ProjectTime;
import at.ac.tuwien.sepm.groupphase.backend.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class ProjectTimeValidatorImpl implements Validator<ProjectTime> {

    @Override
    public boolean validate(ProjectTime p) {
        if(p == null){
            throw new ValidationException("Time can't be empty!");
        }
        if(p.getStart_time() == null || p.getFinish_time() == null){
            throw new ValidationException("Start or finish time must be set!");
        }
        if(p.getStart_time().isAfter(p.getFinish_time())){
            throw new ValidationException("Finish time must be after start time!");
        }
        if(p.getDay() == null || p.getDay().getId() == null || p.getDay().getId() < 0){
            throw new ValidationException("Day must be set!");
        }
        if(p.getProject() == null || p.getProject().getId() == null || p.getProject().getId() < 0){
            throw new ValidationException("Day must be set!");
        }

    return true;
    }
}
