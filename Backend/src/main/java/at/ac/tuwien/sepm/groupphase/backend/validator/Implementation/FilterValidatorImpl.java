package at.ac.tuwien.sepm.groupphase.backend.validator.Implementation;

import at.ac.tuwien.sepm.groupphase.backend.entity.DayFilter;
import at.ac.tuwien.sepm.groupphase.backend.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class FilterValidatorImpl implements Validator<DayFilter>{
    @Override
    public boolean validate(DayFilter o) {
        if(o == null || o.getDates() == null){
            throw new ValidationException("Date must be set");
        }
        return true;
    }
}
