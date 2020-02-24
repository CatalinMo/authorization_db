package ro.fortech.AuthorizationServer.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Authorities {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String authority;

    public Authorities() {
    }

    public Authorities(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }
}
