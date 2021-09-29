package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    public List<Category> findAllByApplicationUserId(Long id) {
        return categoryRepository.findAllByApplicationUserId(id);
    }

    public void deleteByIdAndApplicationUserId(Long id, Long userId) {
        categoryRepository.deleteByIdAndApplicationUserId(id, userId);
    }

    public boolean existsByIdAndApplicationUserId(Long id, Long userId) {
        return categoryRepository.existsByIdAndApplicationUserId(id, userId);
    }

    public void update(Category category) {
        categoryRepository.save(category);
    }
}
