package at.ac.tuwien.sepm.groupphase.backend.validator.Implementation;

import at.ac.tuwien.sepm.groupphase.backend.entity.Project;
import at.ac.tuwien.sepm.groupphase.backend.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class ProjectValidatorImpl implements Validator<Project> {
    @Override
    public boolean validate(Project p) {
        if(p.getProject_id() == null || p.getProject_id() < 0){
            throw new ValidationException("Projectnumber can't be negativ");
        }
        if(p.getProject_name() == null || p.getProject_name().isEmpty()){
            throw new ValidationException("Projectname can't be empty");
        }
        if(p.getProject_desc() == null || p.getProject_desc().isEmpty()){
            throw new ValidationException("Projectdesc can't be empty");
        }
        return true;
    }
}
