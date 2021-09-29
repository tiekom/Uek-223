package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findAllByApplicationUserId(Long id);

    void deleteByIdAndApplicationUserId(Long id, Long applicationUserId);

    boolean existsByIdAndApplicationUserId(Long id, Long applicationUserId);
}
