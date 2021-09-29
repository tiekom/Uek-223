package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.domain.ERole;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import ch.zli.m223.punchclock.service.UserDetailsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final ApplicationUserRepository applicationUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserDetailsServiceImpl userDetailsService;

    public UserController(ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsServiceImpl userDetailsService) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.OK)
    public ApplicationUser signUp(@RequestBody ApplicationUser user) {
        if (!applicationUserRepository.existsByUsername(user.getUsername())) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setERole(ERole.USER);
            user.setActive(true);
            applicationUserRepository.save(user);
            return user;
        }
        return null;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ApplicationUser> findAll(){
        return applicationUserRepository.findAll();
    }

    @GetMapping("/info")
    @ResponseStatus(HttpStatus.OK)
    public ApplicationUser findUser(Authentication authentication){
        return applicationUserRepository.findByUsername(authentication.getName());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveUser(ApplicationUser applicationUser){
        applicationUserRepository.save(applicationUser);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id){
        applicationUserRepository.deleteById(id);
    }
}
