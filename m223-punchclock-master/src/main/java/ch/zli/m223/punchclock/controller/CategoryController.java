package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.service.CategoryService;
import ch.zli.m223.punchclock.service.UserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final UserDetailsService userDetailsService;

    public CategoryController(CategoryService categoryService, UserDetailsService userDetailsService) {
        this.categoryService = categoryService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getAllEntries(Authentication authentication) {
        ApplicationUser applicationUser = this.userDetailsService.findByUsername(authentication.getName());

        return categoryService.findAllByApplicationUserId(applicationUser.getId());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@Valid @RequestBody Category category, Authentication authentication) {
        return categoryService.create(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long id, Authentication authentication) {
        ApplicationUser applicationUser = this.userDetailsService.findByUsername(authentication.getName());
        if (categoryService.existsByIdAndApplicationUserId(id, applicationUser.getId())) {
            categoryService.deleteByIdAndApplicationUserId(id, applicationUser.getId());
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCategory(@RequestBody Category category, @PathVariable Long id, Authentication authentication) {
        ApplicationUser applicationUser = this.userDetailsService.findByUsername(authentication.getName());
        if (categoryService.existsByIdAndApplicationUserId(id, applicationUser.getId())) {
            categoryService.update(category);
        }
    }
}
