package ro.fortech.AuthorizationServer.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL)
    private Authorities authorities;

    public Users() {
    }

    public Users(String username, String password, boolean enabled, Authorities authorities) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }
}
