package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long>{
    List<Categories> findAllByApplicationUserId(Long id);
    void deleteByIdAndApplicationUserId(Long id, Long applicationUserId);
}
