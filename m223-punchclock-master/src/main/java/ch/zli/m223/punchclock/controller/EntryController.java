package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import ch.zli.m223.punchclock.service.EntryService;
import ch.zli.m223.punchclock.service.UserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entries")
public class EntryController {
    private final EntryService entryService;
    private final UserDetailsService userDetailsService;

    public EntryController(EntryService entryService, UserDetailsService userDetailsService) {
        this.entryService = entryService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getAllEntries(Authentication authentication) {
        ApplicationUser applicationUser = this.userDetailsService.findByUsername(authentication.getName());

        return entryService.findAllByApplicationUserId(applicationUser.getId());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@Valid @RequestBody Entry entry, Authentication authentication) {
        return entryService.create(entry);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntry(@PathVariable Long id, Authentication authentication) {
        ApplicationUser applicationUser = this.userDetailsService.findByUsername(authentication.getName());
        if (entryService.existsByIdAndApplicationUserId(id, applicationUser.getId())) {
            entryService.deleteByIdAndApplicationUserId(id, applicationUser.getId());
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEntry(@RequestBody Entry entry, @PathVariable Long id, Authentication authentication) {
        ApplicationUser applicationUser = this.userDetailsService.findByUsername(authentication.getName());
        if (entryService.existsByIdAndApplicationUserId(id, applicationUser.getId())) {
            entryService.update(entry);
        }
    }
}
