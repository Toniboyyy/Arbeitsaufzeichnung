package at.ac.tuwien.sepm.groupphase.backend.entity.mapper.user;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.User.UserDTO;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.User.UserWithoutPWDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    UserWithoutPWDTO UserToUserWithoutPwDTO (User user);

    User UserDTOToUser(UserDTO userDTO);
}
