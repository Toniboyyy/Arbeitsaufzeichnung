package at.ac.tuwien.sepm.groupphase.backend.service;

import at.ac.tuwien.sepm.groupphase.backend.entity.User;

public interface UserService {

    User create(User user);

    User findUserByName(String username);
}
