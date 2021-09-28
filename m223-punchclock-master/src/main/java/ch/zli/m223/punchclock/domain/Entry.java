package ch.zli.m223.punchclock.domain;

import ch.zli.m223.punchclock.exception.LocalDateTimeIsInvalid;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(nullable = false)
    private LocalDateTime checkIn;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(nullable = false)
    private LocalDateTime checkOut;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="categorie_id", referencedColumnName = "id")
    private Categories categories;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="place_id", referencedColumnName = "id")
    private Place place;

    @Column(name = "application_user_id")
    private Long applicationUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) throws LocalDateTimeIsInvalid {
        if (checkOut.isAfter(getCheckIn())) {
            this.checkOut = checkOut;
        } else {
            throw new LocalDateTimeIsInvalid(checkOut + "is before than" + getCheckIn());
        }
    }
}
