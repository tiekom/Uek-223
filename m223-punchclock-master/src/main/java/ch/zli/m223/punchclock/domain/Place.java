package ch.zli.m223.punchclock.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "application_user_id")
    private Long applicationUserId;
    @Column(name = "e_icon")
    private EIcon eIcon;
    @Column(name="name")
    private String name;
}
