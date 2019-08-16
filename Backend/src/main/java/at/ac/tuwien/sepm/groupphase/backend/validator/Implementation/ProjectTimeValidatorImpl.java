package at.ac.tuwien.sepm.groupphase.backend.validator.Implementation;

import at.ac.tuwien.sepm.groupphase.backend.entity.ProjectTime;
import org.springframework.stereotype.Component;

@Component
public class ProjectTimeValidatorImpl implements Validator<ProjectTime> {

    @Override
    public boolean validate(ProjectTime p) {
        return false;
    }
}
