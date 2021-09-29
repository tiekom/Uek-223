package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.domain.Place;
import ch.zli.m223.punchclock.domain.Place;
import ch.zli.m223.punchclock.service.PlaceService;
import ch.zli.m223.punchclock.service.UserDetailsService;
import ch.zli.m223.punchclock.service.UserDetailsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {
    private final PlaceService placeService;
    private final UserDetailsService userDetailsService;

    public PlaceController(PlaceService placeService, UserDetailsService userDetailsService) {
        this.placeService = placeService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Place> getAllEntries(Authentication authentication) {
        ApplicationUser applicationUser = this.userDetailsService.findByUsername(authentication.getName());

        return placeService.findAllByApplicationUserId(applicationUser.getId());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Place createPlace(@Valid @RequestBody Place place, Authentication authentication) {
        return placeService.create(place);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlace(@PathVariable Long id, Authentication authentication) {
        ApplicationUser applicationUser = this.userDetailsService.findByUsername(authentication.getName());
        if (placeService.existsByIdAndApplicationUserId(id, applicationUser.getId())) {
            placeService.deleteByIdAndApplicationUserId(id, applicationUser.getId());
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePlace(@RequestBody Place place, @PathVariable Long id, Authentication authentication) {
        ApplicationUser applicationUser = this.userDetailsService.findByUsername(authentication.getName());
        if (placeService.existsByIdAndApplicationUserId(id, applicationUser.getId())) {
            placeService.update(place);
        }
    }
}
