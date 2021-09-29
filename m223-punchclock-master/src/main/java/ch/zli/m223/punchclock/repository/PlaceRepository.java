package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAllByApplicationUserId(Long id);

    void deleteByIdAndApplicationUserId(Long id, Long applicationUserId);

    boolean existsByIdAndApplicationUserId(Long id, Long applicationUserId);
}
