package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.User;

import at.ac.tuwien.sepm.groupphase.backend.entity.Enum.AuthorityType;

public class UserWithoutPWDTO {

    private Long id;

    private String username;

    private String firstname;

    private String lastname;

    private AuthorityType authorityType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public AuthorityType getAuthorityType() {
        return authorityType;
    }

    public void setAuthorityType(AuthorityType authorityType) {
        this.authorityType = authorityType;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
