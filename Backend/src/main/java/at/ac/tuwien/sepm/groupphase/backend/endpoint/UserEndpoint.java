package at.ac.tuwien.sepm.groupphase.backend.endpoint;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.User.UserDTO;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.User.UserWithoutPWDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.mapper.user.UserMapper;
import at.ac.tuwien.sepm.groupphase.backend.exception.NotFoundException;
import at.ac.tuwien.sepm.groupphase.backend.exception.ValidationException;
import at.ac.tuwien.sepm.groupphase.backend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@RestController
@RequestMapping(value = "/user")
@Api(value = "user")
public class UserEndpoint {

    private final UserMapper userMapper;
    private final UserService userService;

    public UserEndpoint(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Create a User", authorizations = {@Authorization(value = "apiKey")})
    public UserWithoutPWDTO create(@RequestBody UserDTO userDTO){
        try {
            return userMapper.UserToUserWithoutPwDTO(userService.create(userMapper.UserDTOToUser(userDTO)));
        }catch (ValidationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get Username and First/Lastname", authorizations = {@Authorization(value = "apiKey")})
    public UserWithoutPWDTO getUsername(Principal principal){
        try {
            return userMapper.UserToUserWithoutPwDTO(userService.findUserByName(principal.getName()));
        }catch (ValidationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
