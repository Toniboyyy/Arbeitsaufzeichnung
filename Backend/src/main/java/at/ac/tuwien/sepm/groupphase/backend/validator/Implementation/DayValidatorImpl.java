package at.ac.tuwien.sepm.groupphase.backend.validator.Implementation;

import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import at.ac.tuwien.sepm.groupphase.backend.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class DayValidatorImpl implements Validator<Day>{
    @Override
    public boolean validate(Day d) {
        if (d == null){
            throw new ValidationException("Filter can't be null");
        }
        if(d.getStart_time() == null || d.getFinish_time() == null || d.getWork_date() == null){
            throw new ValidationException("Dates and time can't be null");
        }
        if(d.getStart_time().isAfter(d.getFinish_time())){
            throw new ValidationException("Time can't be negativ");
        }
    return true;
    }
}
