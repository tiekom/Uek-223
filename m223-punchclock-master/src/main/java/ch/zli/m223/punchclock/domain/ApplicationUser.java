package ch.zli.m223.punchclock.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "e_role")
    private ERole eRole;
    @Column(name = "active")
    private boolean active;

    public ApplicationUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.active = true;
    }
}
