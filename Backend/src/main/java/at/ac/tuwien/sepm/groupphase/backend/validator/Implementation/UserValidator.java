package at.ac.tuwien.sepm.groupphase.backend.validator.Implementation;

import at.ac.tuwien.sepm.groupphase.backend.entity.User;
import at.ac.tuwien.sepm.groupphase.backend.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class UserValidator implements Validator<User> {

    @Override
    public boolean validate(User user) {
        if(user.getUsername() == null || user.getUsername().isEmpty()){
            throw new ValidationException("Username can't be empty");
        }
        if(user.getPassword() == null || user.getPassword().isEmpty()){
            throw new ValidationException("Password can't be empty");
        }
        if(user.getFirstname() == null|| user.getFirstname().isEmpty()){
            throw new ValidationException("Firstname can't be empty");
        }
        if(user.getLastname() == null|| user.getLastname().isEmpty()){
            throw new ValidationException("Lastname can't be empty");
        }
    return true;
    }

}
