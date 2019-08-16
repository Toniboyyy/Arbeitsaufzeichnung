package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.User;

import at.ac.tuwien.sepm.groupphase.backend.entity.Enum.AuthorityType;

public class UserWithoutPWDTO {

    private Long id;

    private String username;

    private String lastname;

    private AuthorityType authorityType;
}
