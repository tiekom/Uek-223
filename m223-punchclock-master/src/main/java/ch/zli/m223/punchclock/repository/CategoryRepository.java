package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByApplicationUserId(Long id);

    void deleteByIdAndApplicationUserId(Long id, Long applicationUserId);

    boolean existsByIdAndApplicationUserId(Long id, Long applicationUserId);
}
