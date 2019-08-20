package at.ac.tuwien.sepm.groupphase.backend.entity.mapper.user;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.User.UserDTO;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.User.UserWithoutPWDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.User;
import org.springframework.stereotype.Component;

@Component
public class SimpleUserMapper implements UserMapper {
    @Override
    public UserWithoutPWDTO UserToUserWithoutPwDTO(User user) {
        UserWithoutPWDTO userWithoutPWDTO = new UserWithoutPWDTO();
        userWithoutPWDTO.setId(user.getId());
        userWithoutPWDTO.setFirstname(user.getFirstname());
        userWithoutPWDTO.setLastname(user.getLastname());
        userWithoutPWDTO.setUsername(user.getUsername());
        return userWithoutPWDTO;
    }

    @Override
    public User UserDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        return user;
    }
}
