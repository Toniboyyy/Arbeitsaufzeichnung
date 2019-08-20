package at.ac.tuwien.sepm.groupphase.backend.validator.Implementation;

import at.ac.tuwien.sepm.groupphase.backend.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectValidatorImpl implements Validator<Project> {
    @Override
    public boolean validate(Project Object) {
        return false;
    }
}
