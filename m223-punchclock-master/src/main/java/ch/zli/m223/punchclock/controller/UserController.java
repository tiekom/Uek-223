package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.domain.ERole;
import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import ch.zli.m223.punchclock.service.UserDetailsServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserDetailsServiceImpl userDetailsService;

    public UserController(ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsServiceImpl userDetailsService) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/sign-up")
    public ApplicationUser signUp(@RequestBody ApplicationUser user) {
        if (!applicationUserRepository.existsByUsername(user.getUsername())) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setERole(ERole.USER);
            applicationUserRepository.save(user);
            return user;
        }
        return null;
    }

    @PostMapping("/sign-in")
    public void signIn(@RequestBody ApplicationUser user) {
        this.userDetailsService.loadUserByUsername(user.getUsername());
    }

    @GetMapping
    public List<ApplicationUser> getUsers() {
        return applicationUserRepository.findAll();
    }
}
