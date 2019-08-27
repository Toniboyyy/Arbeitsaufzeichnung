package at.ac.tuwien.sepm.groupphase.backend.service;

import at.ac.tuwien.sepm.groupphase.backend.entity.User;

public interface UserService {

    /**
     * @param user to be saved to the db
     * @return the added user with the set Id
     */
    User create(User user);

    /**
     * @param username of the user to search for
     * @return the user with the username
     */
    User findUserByName(String username);
}
