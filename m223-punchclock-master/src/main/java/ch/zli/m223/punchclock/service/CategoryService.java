package ch.zli.m223.punchclock.service;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryService categoryService;

    public CategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
