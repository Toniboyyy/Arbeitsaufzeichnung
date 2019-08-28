package at.ac.tuwien.sepm.groupphase.backend.configuration;

import at.ac.tuwien.sepm.groupphase.backend.entity.Enum.AuthorityType;
import at.ac.tuwien.sepm.groupphase.backend.entity.User;
import at.ac.tuwien.sepm.groupphase.backend.repository.ProjectTimeRepository;
import at.ac.tuwien.sepm.groupphase.backend.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class InitialDataLoader implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitialDataLoader.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private User admin1;
    private User admin2;

    public InitialDataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        setUsers();
    }

    private void setUsers() {
        admin1 = new User();
        admin1.setFirstname("ADMIN");
        admin1.setLastname("ADMIN");
        admin1.setAuthorityType(AuthorityType.ROLE_ADMIN);
        admin1.setUsername("admin1");
        admin1.setPassword(passwordEncoder.encode("ThWh1337Omg"));

        admin2 = new User();
        admin2.setFirstname("ADMIN");
        admin2.setLastname("ADMIN");
        admin2.setAuthorityType(AuthorityType.ROLE_ADMIN);
        admin2.setUsername("admin2");
        admin2.setPassword(passwordEncoder.encode("has_inst"));
    }

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        LOGGER.info("Check if admin is in database");
        List<User> users = userRepository.findAll();
        if(users == null || users.isEmpty()){
            LOGGER.info("Create admin1 Account");
            userRepository.save(admin1);
            LOGGER.info("Create admin2 Account");
            userRepository.save(admin2);
        }
    }
}
